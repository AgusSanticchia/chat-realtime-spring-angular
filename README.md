# 💬 Full Stack Real-Time Chat Application

A **real-time chat application** built with **Angular 19** (frontend) and **Spring Boot 3** (backend).  
It leverages **WebSocket/STOMP** for instant messaging and **MongoDB** for persistence.  
Designed with a **scalable modular architecture**, this project is perfect for learning:

- ✅ Frontend-backend integration  
- ✅ Real-time event handling  
- ✅ Modern development best practices  

---

## 🚀 Tech Stack

### Frontend
- **Angular 19**
- **RxJS** for reactive programming
- **Angular Material / TailwindCSS** (for UI components & styling)
- **WebSocket client** for real-time communication

### Backend
- **Spring Boot 3**
- **Spring WebSocket + STOMP**
- **Spring Data MongoDB**
- **Spring Security (optional)** for authentication/authorization

### Database
- **MongoDB** for storing users, messages, and chat rooms

---

## ⚙️ Features

- 👥 **User authentication & session management**  
- 💬 **1-to-1 and group chat support**  
- ⚡ **Instant messaging with WebSockets/STOMP**  
- 🕒 **Message history persistence with MongoDB**  
- 🔔 **Real-time notifications**  
- 📱 **Responsive design**  

---

## 🔧 Installation & Setup

### 1. Clone repository
```bash
git clone https://github.com/AgusSanticchia/chat-realtime-spring-angular.git
cd chat-realtime-spring-angular
```

### 2. Run Backend (Spring Boot)
```bash
cd backend
./mvnw spring-boot:run
```
Runs at: http://localhost:8080

### 3. Run Frontend (Angular)
```bash
cd frontend
npm install
ng start
```
Runs at: http://localhost:4200
