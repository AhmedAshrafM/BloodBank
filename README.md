Creating comprehensive documentation for a project's API is an essential step to help users understand how to use your application. Based on the provided code snippets and assuming that your project includes various servlets and DAO classes, I'll provide you with a template for a GitHub-friendly documentation structure. Please customize it further based on your specific project's features and endpoints.

# Blood Bank Web Application API Documentation

## Introduction

The Blood Bank Web Application API provides access to various features of a blood bank management system. This API allows users to perform actions such as managing blood stock, donors, patients, and staff, as well as handling user authentication and logouts.

## Table of Contents

- [Authentication](#authentication)
- [Blood Stock](#blood-stock)
- [Donors](#donors)
- [Patients](#patients)
- [Staff](#staff)
- [Logging Out](#logging-out)

## Authentication

- **Endpoint**: `/login_AccessServlet`
- **Method**: GET
- **Description**: User authentication endpoint. Renders the login page.
- **Parameters**: None

### Request Example

```http
GET /login_AccessServlet
```

---

- **Endpoint**: `/login_getAuthorization_AjaxServlet`
- **Method**: POST
- **Description**: User authentication endpoint. Validates user credentials and logs them in if successful.
- **Parameters**:
  - `username` (String): User's username
  - `password` (String): User's password

### Request Example

```http
POST /login_getAuthorization_AjaxServlet
Content-Type: application/x-www-form-urlencoded

username=admin&password=admin
```

### Response Example

```json
Success
```

## Blood Stock

- **Endpoint**: `/bloodtransactions_AccessServlet`
- **Method**: GET
- **Description**: Retrieves and displays the list of blood transactions.
- **Parameters**: None

### Request Example

```http
GET /bloodtransactions_AccessServlet
```

---

- **Endpoint**: `/bloodstock_AccessServlet`
- **Method**: GET
- **Description**: Retrieves and displays the list of available blood stock.
- **Parameters**: None

### Request Example

```http
GET /bloodstock_AccessServlet
```

---

- **Endpoint**: `/bloodstock_AccessServlet`
- **Method**: POST
- **Description**: Adds a new blood stock entry.
- **Parameters**:
  - `bagId` (String): Blood bag ID
  - `bloodGroup` (String): Blood group
  - `expiryDate` (String): Expiry date

### Request Example

```http
POST /bloodstock_AccessServlet
Content-Type: application/x-www-form-urlencoded

bagId=BS001&bloodGroup=O+&expiryDate=2023-09-30
```

## Donors

- **Endpoint**: `/donors_AccessServlet`
- **Method**: GET
- **Description**: Retrieves and displays the list of donors.
- **Parameters**: None

### Request Example

```http
GET /donors_AccessServlet
```

---

- **Endpoint**: `/donors_AccessServlet`
- **Method**: POST
- **Description**: Adds a new donor.
- **Parameters**:
  - `name` (String): Donor's name
  - `natId` (String): National ID
  - `bloodGroup` (String): Blood group
  - `contact` (String): Contact information

### Request Example

```http
POST /donors_AccessServlet
Content-Type: application/x-www-form-urlencoded

name=John Doe&natId=1234567890&bloodGroup=A+&contact=johndoe@example.com
```

## Patients

- **Endpoint**: `/patients_AccessServlet`
- **Method**: GET
- **Description**: Retrieves and displays the list of patients.
- **Parameters**: None

### Request Example

```http
GET /patients_AccessServlet
```

---

- **Endpoint**: `/patients_AccessServlet`
- **Method**: POST
- **Description**: Adds a new patient.
- **Parameters**:
  - `name` (String): Patient's name
  - `natId` (String): National ID
  - `bloodGroup` (String): Blood group
  - `contact` (String): Contact information

### Request Example

```http
POST /patients_AccessServlet
Content-Type: application/x-www-form-urlencoded

name=Jane Doe&natId=0987654321&bloodGroup=B-&contact=janedoe@example.com
```

## Staff

- **Endpoint**: `/staff_AccessServlet`
- **Method**: GET
- **Description**: Retrieves and displays the list of staff members.
- **Parameters**: None

### Request Example

```http
GET /staff_AccessServlet
```

---

- **Endpoint**: `/staff_AccessServlet`
- **Method**: POST
- **Description**: Adds a new staff member.
- **Parameters**:
  - `name` (String): Staff member's name
  - `natId` (String): National ID
  - `position` (String): Staff member's position

### Request Example

```http
POST /staff_AccessServlet
Content-Type: application/x-www-form-urlencoded

name=John Smith&natId=5555555555&position=Nurse
```

## Logging Out

- **Endpoint**: `/logOut_ControllerServlet`
- **Method**: GET
- **Description**: Logs out the current user and invalidates the session.
- **Parameters**: None

### Request Example

```http
GET /logOut_ControllerServlet
```

---