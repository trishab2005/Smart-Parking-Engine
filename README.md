# 🚗 SMART PARKING ENGINE 

A full-stack **Smart Parking Management System** built using **Spring Boot + React** that automates vehicle parking, exit, and real-time slot tracking.

---

## 📌 OVERVIEW

Smart Parking Engine is designed to solve real-world parking problems by:

- Reducing manual effort
- Automating slot allocation
- Providing real-time parking status
- Calculating fees on exit

It follows a **client-server architecture** with a REST API backend and a modern UI frontend.

---

## 🌟 FEATURES

### 🚗 Park Vehicle
- Enter vehicle number
- Select vehicle type (CAR / BIKE)
- Automatically assigns an available slot

### 🚪 Exit Vehicle
- Exit using **Record ID**
- Calculates parking fee
- Frees the occupied slot

### 🅿️ Slot Management
- View all parking slots
- Shows:
  - Slot number
  - Vehicle type
  - Availability status

### 📊 Dashboard
- Displays:
  - Total Vehicles
  - Available Slots
  - Occupied Slots
- Quick navigation cards

---

## 🧱 ARCHITECTURE

Frontend and backend are separated:

- React handles UI
- Spring Boot handles business logic
- Database stores slots & parking records

---

## 🛠️ TECH STACK

### Frontend
- React.js
- Tailwind CSS
- Axios
- React Router

### Backend
- Spring Boot
- REST APIs
- Hibernate / JPA

### Database
- MySQL / H2

---
## 📂 PROJECT STRUCTURE
```bash
Smart-Parking-Engine/
│
├── backend/
│ ├── controller/
│ ├── service/
│ ├── dto/
│ ├── entity/
│ └── repository/
│
├── frontend/
│ ├── src/
│ │ ├── api/
│ │ ├── components/
│ │ ├── pages/
│ │ └── App.jsx
│
└── README.md

```


---

## 🚀 INSTALLATION AND SETUP

### 1️⃣ Clone Repository

```bash
git clone https://github.com/trishab2005/Smart-Parking-Engine.git
cd Smart-Parking-Engine
```

### 2️⃣ Run Backend

```bash
cd backend
mvn spring-boot:run

http://localhost:8080
```

### 3️⃣ Run Frontend

```bash
cd frontend
npm install
npm run dev

http://localhost:5173
```

## 🔗 API ENDPOINTS

### Parking APIs

```bash
| Method | Endpoint        | Description         |
| ------ | --------------- | ------------------- |
| POST   | /parking/park   | Park a vehicle      |
| POST   | /parking/exit   | Exit vehicle        |
| GET    | /parking        | Get all records     |
| GET    | /parking/active | Get active vehicles |
```

### Slot APIs

```bash
| Method | Endpoint                  | Description     |
| ------ | ------------------------- | --------------- |
| GET    | /slots                    | Get all slots   |
| GET    | /slots/available?type=CAR | Available slots |
| GET    | /slots/occupied           | Occupied slots  |
```
---

## 🧪 How to Test

### Step 1: Park Vehicle

- Go to `/park`
- Enter:
  - Vehicle Number (e.g. WB1234)
  - Type (CAR/BIKE)
- Click **Park**

---

### Step 2: Get Record ID

Open:-

http://localhost:8080/parking/active

Copy an ID like:- "id": 32

---

### Step 3: Exit Vehicle

- Go to `/exit`
- Enter: 32

- Click **Exit**

---

## 📸 SCREENSHOTS

---
### Faker API use in OracleDB 
---
<img width="1434" height="428" alt="image" src="https://github.com/user-attachments/assets/6d3273d7-ad12-41b7-8e96-b8bba7f049ff" />
<img width="1280" height="149" alt="image" src="https://github.com/user-attachments/assets/c39bc511-45b4-40f3-9c69-1fab31195b46" />
<img width="504" height="1588" alt="image" src="https://github.com/user-attachments/assets/411992b7-ee8e-4113-827c-46b0e613951d" />
<img width="1600" height="274" alt="image" src="https://github.com/user-attachments/assets/368090b3-9217-43e6-b968-afb00f7c69a5" />

---
###  Repository Test Cases Check
---

<img width="1288" height="1166" alt="image" src="https://github.com/user-attachments/assets/7fb0e7e4-1dea-4454-892f-38f2d8dca0f0" />
<img width="1396" height="1490" alt="image" src="https://github.com/user-attachments/assets/454b81b4-a5af-47b1-98e8-dd5a685f0372" />

---
### API Tests
---
<img width="1418" height="1180" alt="image" src="https://github.com/user-attachments/assets/a32adbea-4b5d-439d-be7a-e3707b0fa56b" />
<img width="1416" height="878" alt="image" src="https://github.com/user-attachments/assets/21a10969-2681-42e2-a1ff-7ab026f1bde3" />
<img width="1434" height="1326" alt="image" src="https://github.com/user-attachments/assets/77ff0aad-005b-49ff-9d53-7040b08ec3f1" />
<img width="1402" height="1334" alt="image" src="https://github.com/user-attachments/assets/d822eb23-dd79-40a0-9118-5e403857ff0d" />
<img width="1412" height="1076" alt="image" src="https://github.com/user-attachments/assets/aae07320-5b6f-488e-bc5a-feb041db12fb" />
<img width="1426" height="1326" alt="image" src="https://github.com/user-attachments/assets/f2ca032b-2175-42ab-971a-18f510f11674" />
<img width="1442" height="1344" alt="image" src="https://github.com/user-attachments/assets/fe9edbc0-2954-4930-aa8a-6f5e4615ea8a" />
<img width="1416" height="894" alt="image" src="https://github.com/user-attachments/assets/9d50e5cf-0123-43db-b68d-3e2b5fb93735" />
<img width="1438" height="1342" alt="image" src="https://github.com/user-attachments/assets/4402ffdd-e5cf-456e-bd78-85fea148a62e" />
<img width="1426" height="1094" alt="image" src="https://github.com/user-attachments/assets/35a7ab48-73d7-4f4b-bbaa-11f470b0a749" />
<img width="1428" height="1036" alt="image" src="https://github.com/user-attachments/assets/c7fa7110-69a4-43ea-97e9-a99ecccc67ad" />
<img width="1428" height="924" alt="image" src="https://github.com/user-attachments/assets/15522a67-6cc2-4e56-a9d9-f52787e517dd" />
<img width="1424" height="852" alt="image" src="https://github.com/user-attachments/assets/9ecafec5-4fb9-44b3-b58d-62466d250a7f" />

---
### Frontend Including Validation Checks 
---

<img width="1280" height="691" alt="image" src="https://github.com/user-attachments/assets/e4173fff-adc4-4c1c-ba4d-7fed2ea1ef99" />
<img width="1280" height="685" alt="image" src="https://github.com/user-attachments/assets/b0d83b56-54d3-4217-b483-5048fab5e3d5" />
<img width="1280" height="692" alt="image" src="https://github.com/user-attachments/assets/01537d80-9aba-4941-9a51-650f63c2ab3c" />
<img width="1280" height="692" alt="image" src="https://github.com/user-attachments/assets/019df819-7bc6-4629-93e5-f981c9bbb526" />
<img width="1280" height="688" alt="image" src="https://github.com/user-attachments/assets/4105fb6c-7f97-477c-82d5-e96aa0df54b7" />
<img width="1280" height="690" alt="image" src="https://github.com/user-attachments/assets/01529401-9c3f-4094-959e-a44448da9adf" />
<img width="2880" height="1564" alt="image" src="https://github.com/user-attachments/assets/f0a5d81c-926f-4d57-9e0d-b5ad345d8ca5" />
<img width="1280" height="694" alt="image" src="https://github.com/user-attachments/assets/7cc105a7-8d97-43b5-9c60-e0efa8ea76ff" />

---






