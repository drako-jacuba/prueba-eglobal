# Transaction Web

Frontend desarrollado con React + Vite.

## Tecnologías

- React
- Vite
- Axios
- React Router DOM

## Instalación

```bash
npm install
```

## Ejecución

```bash
npm run dev
```

Aplicación disponible en:

```text
http://localhost:5173
```

## Funcionalidades

### Login

Permite autenticarse contra el backend.

### Dashboard

Muestra:

- Total Transactions
- Approved Transactions
- Cancelled Transactions
- Total Amount

### Transactions

Consulta de transacciones registradas.

### Transaction Detail

Consulta detalle por referencia.

### New Transaction

Permite registrar nuevas transacciones.

### Cancel Transaction

Permite cancelar transacciones aprobadas.

## Dependencias principales

```bash
npm install axios
npm install react-router-dom
```

## Backend requerido

El frontend requiere:

```text
transaction-api-ms
```

ejecutándose en:

```text
http://localhost:8001
```