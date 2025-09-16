import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import * as Stomp from '@stomp/stompjs';
import SockJS from 'sockjs-client';
import { Message } from '../models/message';

@Component({
  selector: 'app-chat',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './chat.component.html'
})
export class ChatComponent implements OnInit {
  client!: Stomp.Client;
  connected: boolean = false;

  messages: Message[] = [];
  message: Message;
  writing: string = '';
  clientId: string;

  constructor() {
    this.clientId = 'id-' + new Date().getTime() + '-' + Math.random().toString(36).substring(2);
    this.message = new Message();
  }

  ngOnInit(): void {
    this.client = new Stomp.Client({
      webSocketFactory: () => new SockJS('http://localhost:8080/chat-websocket'),
      debug: str => console.log(str),
      reconnectDelay: 5000
    });

    this.client.onConnect = (frame) => {
      this.connected = true;
      console.log(`Connected: ${this.client.connected} : ${frame}`);

      this.client.subscribe('/chat/message', e => {
        let message: Message = JSON.parse(e.body) as Message;
        message.date = new Date(message.date);
        if (this.message.username === message.username && !this.message.color && message.type === 'NEW_USER') {
          this.message.color = message.color;
        }
        this.messages.push(message);
      });

      this.client.subscribe('/chat/writing', e => {
        this.writing = e.body;
        setTimeout(() => this.writing = '', 3000);
      });

      this.client.subscribe(`/chat/history/${this.clientId}`, e => {
        const histories = JSON.parse(e.body) as Message[];
        this.messages = histories;
      });

      this.client.publish({ destination: '/app/history', body: this.clientId });

      this.message.type = 'NEW_USER';
      this.client.publish({
        destination: '/app/message',
        body: JSON.stringify(this.message)
      });
    };

    this.client.onDisconnect = (frame) => {
      this.connected = false;
      this.message = new Message();
      this.messages = [];
      this.writing = '';
      console.log(`Disconnected: ${!this.client.connected} : ${frame}`);
    };
  }

  connect(): void {
    if (!this.connected) {
      this.client.activate();
    }
  }

  deconnect(): void {
    if (this.connected) {
      this.client.deactivate();
    }
  }

  onSendMessage(): void {
    if (this.connected && this.message.text) {
      this.message.type = 'MESSAGE';
      this.client.publish({
        destination: '/app/message',
        body: JSON.stringify(this.message)
      });
      this.message.text = '';
    }
  }

  onWritingEvent(): void {
    if (this.connected && this.message.username) {
      this.client.publish({
        destination: '/app/writing',
        body: this.message.username
      });
    }
  }
}
