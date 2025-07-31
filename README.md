# 🔗 REST API Testing Project — Manual & Automation (Postman + Rest Assured)

## 📌 Overview

This project demonstrates a comprehensive REST API testing framework involving both **manual testing using Postman** and **automated API testing using Java + Rest Assured + TestNG**. It focuses on real-world use cases across various domains including:

- 🛒 **eCommerce APIs**  
- 📍 **Google Maps APIs**  
- 📚 **Library Management API**  
- ☁️ **Cloud Jira API (Basic Authentication)**  
- 🔎 **GraphQL (Query & Mutation)**

The framework follows best practices using **POJO classes**, **JSON serialization/deserialization**, and integrates with **Maven** for dependency management and **TestNG** for execution and reporting.

---

## 🧰 Tech Stack & Tools Used

![Java](https://img.shields.io/badge/Java-11-blue?logo=java)
![Maven](https://img.shields.io/badge/Maven-3.8.6-C71A36?logo=apachemaven)
![Rest Assured](https://img.shields.io/badge/Rest--Assured-5.4.0-green)
![TestNG](https://img.shields.io/badge/TestNG-7.9.0-FF6C37?logo=testng)
![Postman](https://img.shields.io/badge/Postman-Manual%20API%20Testing-orange?logo=postman)
![Eclipse IDE](https://img.shields.io/badge/Eclipse-2024--06-purple?logo=eclipseide)
![GitHub](https://img.shields.io/badge/GitHub-Version%20Control-181717?logo=github)
![JSON](https://img.shields.io/badge/JSON-Serialization%2FDeserialization-blue)
![POJO](https://img.shields.io/badge/POJO-Used%20for%20Payloads-yellow)

---

## 🧪 Manual Testing (Postman)

> Manual testing was performed using Postman for the following APIs:

- 🛒 **eCommerce domain APIs**
- 📍 **Google Maps Place APIs**
- 📚 **Library Management API**
- ☁️ **Jira Cloud APIs (Basic Auth)**
- 🔐 **OAuth 2.0 Client Credentials Flow**
- 🔎 **GraphQL APIs (Queries and Mutations)**

> **Assertions included**:  
- Status code  
- Response time  
- Schema validation  
- Field-level value matching  

---

## 🤖 Automation Testing (Rest Assured)

### ✅ Key Concepts Automated:

- **GET, POST, PUT, DELETE** methods
- **JSON Payload creation via POJOs**
- **Serialization & Deserialization**
- **Dynamic data handling**
- **Authorization tokens and headers**
- **TestNG annotations and test prioritization**
- **Reusable methods for requests & validations**

### 🚀 How to Run

# Clean and run all tests
mvn clean test


