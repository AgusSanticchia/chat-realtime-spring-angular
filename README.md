# Chat en Tiempo Real - Spring Boot + Angular

Este proyecto es una aplicación de chat en tiempo real que utiliza Spring Boot como backend y Angular como frontend.

## Requisitos Previos

- Java 21 o superior
- Node.js 18 o superior
- MongoDB (instalado y ejecutándose en localhost:27017)
- Maven 3.6 o superior

## Instalación y Ejecución

### Backend (Spring Boot)

1. Navega al directorio del backend:
```bash
cd springboot-backend-chat
```

2. Ejecuta la aplicación Spring Boot:
```bash
./mvnw spring-boot:run
```

El backend estará disponible en: `http://localhost:8080`

### Frontend (Angular)

1. Navega al directorio del frontend:
```bash
cd angular-chat
```

2. Instala las dependencias:
```bash
npm install
```

3. Ejecuta la aplicación Angular:
```bash
npm start
```

El frontend estará disponible en: `http://localhost:4200`

## Características

- Chat en tiempo real usando WebSockets
- Almacenamiento de mensajes en MongoDB
- Interfaz de usuario moderna con Bootstrap
- Notificaciones de "usuario escribiendo"
- Historial de mensajes
- Colores únicos para cada usuario

## Estructura del Proyecto

```
chat-realtime-spring-angular/
├── springboot-backend-chat/     # Backend Spring Boot
│   ├── src/main/java/...        # Código Java
│   └── src/main/resources/      # Configuración
└── angular-chat/                # Frontend Angular
    ├── src/app/                 # Código TypeScript
    └── src/assets/              # Recursos estáticos
```

## Tecnologías Utilizadas

### Backend
- Spring Boot 3.5.4
- Spring WebSocket
- Spring Data MongoDB
- Lombok

### Frontend
- Angular 19
- Bootstrap 5
- STOMP.js
- SockJS

## Solución de Problemas

1. **Error de conexión a MongoDB**: Asegúrate de que MongoDB esté ejecutándose en localhost:27017
2. **Error de CORS**: El backend ya está configurado para permitir conexiones desde localhost:4200
3. **Error de WebSocket**: Verifica que ambos servicios estén ejecutándose en los puertos correctos