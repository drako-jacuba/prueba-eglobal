# Transaction System

## Descripción

Transaction System es una aplicación desarrollada bajo una arquitectura basada en microservicios que permite:

- Autenticación de usuarios
- Creación de transacciones
- Consulta de transacciones
- Consulta de detalle por referencia
- Cancelación de transacciones
- Dashboard con indicadores en tiempo real

La solución está compuesta por:

- Frontend React + Vite
- API Gateway / Backend API (Spring Boot)
- Microservicio de Transacciones (Spring Boot)
- Base de datos H2

---

# Arquitectura

```text
┌─────────────────┐
│  React + Vite   │
│     5173        │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│ transaction-api │
│      8001       │
└────────┬────────┘
         │ REST
         ▼
┌─────────────────┐
│ transaction-ms  │
│      8002       │
└────────┬────────┘
         │
         ▼
┌─────────────────┐
│       H2        │
└─────────────────┘
```

---

# Tecnologías utilizadas

## Backend

- Java 17
- Spring Boot 3
- Spring Data JPA
- H2 Database
- Maven
- Swagger OpenAPI

## Frontend

- React
- Vite
- React Router DOM
- Axios

## Seguridad

- AES Encryption
- CORS Configuration

---

# Estructura del proyecto

```text
Transaction-System
│
├── transaction-api-ms
│
├── transaction-service-ms
│
├── transaction-web
│
└── README.md
```

---

# Requisitos

## Backend

- Java 17
- Maven 3.9+

Verificar instalación:

```bash
java -version
mvn -version
```

## Frontend

- NodeJS 22+
- NPM 10+

Verificar instalación:

```bash
node -v
npm -v
```

---

# Ejecución

## 1. Levantar transaction-service-ms

Ubicarse en:

```bash
cd transaction-service-ms
```

Ejecutar:

```bash
mvn spring-boot:run
```

Puerto:

```text
http://localhost:8002
```

---

## 2. Levantar transaction-api-ms

Ubicarse en:

```bash
cd transaction-api-ms
```

Ejecutar:

```bash
mvn spring-boot:run
```

Puerto:

```text
http://localhost:8001
```

Swagger:

```text
http://localhost:8001/swagger-ui/index.html
```

---

## 3. Levantar Frontend

Ubicarse en:

```bash
cd transaction-web
```

Instalar dependencias:

```bash
npm install
```

Ejecutar:

```bash
npm run dev
```

Frontend:

```text
http://localhost:5173
```

---

# Usuario de prueba

```text
Usuario : admin
Password: password
```

---

# Funcionalidades implementadas

## Login

Permite autenticarse contra el backend.

---

## Dashboard

Visualización de:

- Total Transactions
- Approved Transactions
- Cancelled Transactions
- Total Amount

---

## Transactions

Consulta paginada de transacciones.

Información mostrada:

- ID
- Reference
- Client
- Operation
- Status

---

## Transaction Detail

Consulta individual por referencia.

Información:

- ID
- Reference
- Client
- Operation
- Status
- Amount

---

## New Transaction

Permite registrar nuevas transacciones.

Campos:

- Client
- Amount
- Operation
- Secret

---

## Cancel Transaction

Permite cancelar una transacción aprobada.

Validaciones:

- Confirmación previa
- Actualización automática de estatus

---

# Base de datos

Motor utilizado:

```text
H2 Database
```

Consola:

```text
http://localhost:8002/h2-console
```

Datasource:

```text
jdbc:h2:mem:transactiondb
```

Usuario:

```text
sa
```

Password:

```text
(blank)
```

---

# Endpoints principales

## Login

```http
POST /auth/login
```

---

## Crear transacción

```http
POST /api/transactions
```

---

## Obtener transacciones

```http
GET /api/transactions?page=0&size=5
```

---

## Obtener por referencia

```http
GET /api/transactions/{reference}
```

---

## Cancelar transacción

```http
PATCH /transactions/cancel
```

---

# Autor

Desarrollado como prueba técnica utilizando:

- React
- Spring Boot
- Arquitectura de Microservicios
- H2 Database
- AES Encryption