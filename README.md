# Medical Inventory Management System (Java Swing)

## 📌 Overview

The **Medical Inventory Management System** is a desktop application built using **Java Swing** for the graphical user interface and **MySQL** for database management. It is designed to streamline the management of medical stock, clients, suppliers, and billing processes, making it an ideal solution for pharmacies, clinics, and medical supply stores.

## ⚙️ Features

- **Stock Management**: Add, update, and track medical items in inventory.
- **Client Management**: Maintain client records and purchase histories.
- **Supplier Management**: Keep track of suppliers and their contact information.
- **Billing System**: Generate bills for clients with itemized details.
- **Tax Calculation**: Option to include or exclude tax in billing.
- **User-Friendly Interface**: Intuitive GUI built with Java Swing.

## 🛠️ Technologies Used

- **Frontend**: Java Swing
- **Backend**: MySQL
- **IDE**: NetBeans

### Installation & Setup

## 1. Clone the Repository
   git clone https://github.com/yashn555/Medical-Inventory-Management-Java-Swing.git

## 2. Import Project

- Open NetBeans IDE.

- Import the cloned project into NetBeans.

## 3. Set Up Database

Create a new MySQL database named:
**medical_inventory**

- Run the provided SQL script **medical.sql** in the repository to set up necessary tables.

## 4. Configure Database Connection

- Update the database connection settings in the project to match your MySQL credentials.

## 5. Run the Project

 - Run the project from NetBeans IDE.

## Screenshots

**Login Screen:**
<img width="1919" height="1079" alt="Screenshot 2025-09-13 211146" src="https://github.com/user-attachments/assets/e45c87a3-49b4-4d79-b55a-bda6e74f487e" />

**Dashboard:**
<img width="1919" height="1079" alt="Screenshot 2025-09-13 211203" src="https://github.com/user-attachments/assets/08443f55-d8be-4f95-98f8-85c50ac13079" />

**Billing Interface:**
<img width="1919" height="1026" alt="Screenshot 2025-09-13 211233" src="https://github.com/user-attachments/assets/f49b6a98-84ca-4649-a7a5-e0041d0e60c1" />


### Database Schema

The database consists of the following tables:

**1. products** – Stores information about medical products.

**2. clients** – Stores client details.

**3. suppliers**  – Stores supplier information.

**4. bills** – Stores billing and transaction details.

These tables are designed to ensure efficient data management and smooth operations.

### Usage
**Admin Login:**

Username: admin

Password: admin123

**Client Login:**

Username: client

Password: client123

After logging in, users can navigate through the system to manage stock, clients, suppliers, and generate bills.

