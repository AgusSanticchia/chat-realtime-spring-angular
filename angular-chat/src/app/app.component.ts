import { Component } from '@angular/core';
import { ChatComponent } from './components/chat.component';  

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [ChatComponent, ],
  templateUrl: './app.component.html',
})
export class AppComponent {
}
