# 🛍️ E-Commerce Backend (Spring Boot + JWT Security)
A **production-grade e-commerce backend** built with **Spring Boot 3**, **Spring Security 6**, and **JWT Authentication**.  
This project showcases secure authentication, clean architecture, and modular design — ideal for real-world backend systems.

---

## 🚀 Tech Stack
| Layer | Technology |
|-------|-------------|
| **Language** | Java 17 |
| **Framework** | Spring Boot 3.x |
| **Security** | Spring Security + JWT |
| **Database** | MySQL / PostgreSQL |
| **ORM** | Spring Data JPA (Hibernate) |
| **Build Tool** | Maven |
| **Hashing** | BCrypt |
| **Testing Tool** | Postman |

---
## 🧾 API Endpoints
| **Endpoint** | **Method** | **Description** | **Auth** |
|---------------|-------------|------------------|-----------|
| `/api/auth/register` | POST | Register new user | ❌ |
| `/api/auth/login` | POST | Generate JWT token | ❌ |
| `/api/products` | GET | Get all products | ✅ |
| `/api/orders` | POST | Place new order | ✅ |
| `/api/orders/{id}` | GET | Fetch user orders | ✅ |

---


## 🧩 Main Modules

### 🔐 Authentication & Authorization
- Register & login using email and password.
- Passwords hashed using **BCrypt**.
- Stateless JWT authentication (no sessions).
- Custom `UserDetailsService` for authentication.
- `JwtAuthenticationFilter` validates tokens for every secured request.

### 🛒 Product Management
- CRUD operations for products.
- Category support and easy filtering.
- Ready for pagination and sorting.

### 📦 Order Management
- Each order contains multiple items (`OrderItem` entity).
- Maintains relationships between `Order`, `User`, and `Product`.
- Calculates quantities and total values per order.

### ❤️ Wishlist / Favorites *(Optional)*
- Add or remove products from the user’s wishlist.
- One-to-many mapping with `User`.

---

## 🔐 Security Overview

### ✅ Public Endpoints
POST /api/auth/register
POST /api/auth/login

### 🔒 Secured Endpoints
GET /api/products
POST /api/orders
Use JWT Bearer token in the header:

---

## ⚙️ Setup & Installation

### 1️⃣ Clone the Repository
```bash
git clone https://github.com/<your-username>/ecom-backend.git
cd ecom-backend
src/main/java/com/pushpender/ecombackend/
│
├── config/
│   ├── SecurityConfig.java
│   ├── JwtAuthenticationFilter.java
│
├── controllers/
│   ├── AuthController.java
│   ├── ProductController.java
│   ├── OrderController.java
│
├── entities/
│   ├── User.java
│   ├── Product.java
│   ├── Order.java
│   ├── OrderItem.java
│
├── repositories/
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── OrderRepository.java
│
├── services/
│   ├── JwtService.java
│   ├── CustomUserDetailsService.java
│   ├── OrderService.java
│
└── EcomBackendApplication.java



