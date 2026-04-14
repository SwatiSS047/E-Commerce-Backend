🚀 ShopSphere API – Multi-Vendor E-Commerce Backend System

📌 Project Overview

This is a secure Ecommerce REST API built using:

- Spring Boot
- Spring Security (JWT-based authentication)
- Redis (OTP storage)
- Razorpay (Payment Integration)
- Java Mail (Email OTP)
- MySQL (Database)
- MapStruct (DTO Mapping)

👉 The system supports:

- Admin, Merchant, Customer roles
- Product management
- Cart & Order system
- OTP-based registration
- Online payment
  
🧱 Architecture (Layered Design)
```
Controller → Service → DAO → Database
             ↓
        Mapper (DTO Conversion)
             ↓
     Security (JWT)
             ↓
 External Services (Redis, Email, Razorpay)
```
📁 Project Structure

 src/main/java/com/jsp/ecommerse_api
```
│
├── config
│   ├── SecurityConfig.java
│   ├── JwtFilter.java
│   └── AppConfig.java
│
├── controller
│   ├── AuthController.java
│   ├── AdminController.java
│   ├── MerchantController.java
│   └── CustomerController.java
│
├── service
│   ├── AuthService.java
│   ├── AdminService.java
│   ├── MerchantService.java
│   ├── CustomerService.java
│   │
│   └── impl
│       ├── AuthServiceImpl.java
│       ├── AdminServiceImpl.java
│       ├── MerchantServiceImpl.java
│       └── CustomerServiceImpl.java
│
├── dao
│   ├── UserDao.java
│   └── ProductDao.java
│
├── repository
│   ├── UserRepository.java
│   ├── ProductRepository.java
│   ├── OrderRepository.java
│   └── CartRepository.java
│
├── entity
│   ├── User.java
│   ├── Customer.java
│   ├── Merchant.java
│   ├── Product.java
│   ├── Cart.java
│   ├── Item.java
│   └── CustomerOrder.java
│
├── dto
│   ├── UserDto.java
│   ├── CustomerDto.java
│   ├── MerchantDto.java
│   ├── ProductDto.java
│   ├── PaymentDto.java
│   ├── OtpDto.java
│   └── FakeStoreData.java
│
├── mapper
│   ├── UserMapper.java
│   └── ProductMapper.java
│
├── security
│   ├── JwtService.java
│   ├── CustomUserDetailsService.java
│   └── JwtAuthenticationFilter.java
│
├── util
│   ├── EmailService.java
│   ├── RedisService.java
│   └── AdminAccountCreator.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── OutOfStockException.java
│   └── CustomExceptions.java
│
├── enums
│   └── UserRole.java
│
└── EcommerceApplication.java
```

🔐 Security (JWT + Spring Security)
JwtService

Handles:

- Token generation
- Extract username & role
- Token validation
 ```
  generateToken(UserDetails userDetails)
  ```

✔ Adds:

username (subject)
role (custom claim)
expiration (1 hour)

👉 Used during login:
```
authenticationManager.authenticate(...)
jwtService.generateToken(...)
```
🔑 Authentication & OTP Flow
AuthServiceImp1
🔹 Login
- Uses AuthenticationManager
- Generates JWT token
🔹 Registration (Merchant & Customer)

Flow:

1. User submits details
2. OTP generated
3. OTP sent via Email
4. Data stored in Redis temporarily
🔹 OTP Verification
- OTP checked from Redis
- If valid:
  - User saved in DB
  - Role assigned (Merchant/Customer)
    
🔹 Redis Usage
```
saveOtp → 5 minutes expiry
saveTempData → 30 minutes expiry
```
✔ Prevents duplicate registrations
✔ Improves performance

👨‍💼 Admin Module
AdminServiceImp1

Features:

- View all merchants/customers
- Block / Unblock users
- View all products
- Approve products
  ```
  user.setActive(false); // Block
  product.setApproved(true); // Approve
  ```
👉 Admin account auto-created using:
```
CommandLineRunner (AdminAccountCreator)
```
🛍️ Merchant Module
MerchantServiceImp1

Features:

- Add product
- Update product
- Delete product
- View own products
  
🔥 Extra Feature

Import products from external API:
```
https://fakestoreapi.com/products
```
✔ Uses RestTemplate

🛒 Customer Module
CustomerServiceImp1
🔹 Product Browsing
- Pagination
- Sorting
- Filtering:
  - Name
  - Category
  - Price range
    
🔹 Cart Management
- Add to cart
- Remove from cart
- View cart

✔ Handles:

- Quantity update
- Stock validation
  
🔹 Order & Payment
Step 1: Create Order
- Calculates total amount
- Creates Razorpay order
- Saves order in DB
  
Step 2: Payment
- Stores payment ID
- Marks payment success
- Clears cart
- 
💳 Razorpay Integration

Used for:

- Order creation
- Payment processing
```
RazorpayClient client = new RazorpayClient(key, secret);
client.orders.create(...)
```

✔ Returns:

- orderId
- amount
- key for frontend
  
📧 Email Service
EmailService
- Sends OTP via email
- Uses:
  ```
  JavaMailSender
  ```
✔ Async execution → improves performance

⚡ Redis Service
RedisService

Stores:

- OTP (5 mins)
- Temporary user data (30 mins)

✔ Prevents DB overload
✔ Enables fast OTP validation

🔄 DTO Mapping (MapStruct)

Used for:

Entity ↔ DTO conversion

✔ Clean architecture
✔ Avoids exposing entity directly

🗄️ Database

Using:

- MySQL
- Spring Data JPA

Entities:

- User
- Customer
- Merchant
- Product
- Cart
- Item
- Order
🧪 Dependencies Highlights

From your pom.xml:

- JWT → jjwt
- Payment → razorpay-java
- Redis → spring-boot-starter-data-redis
- Mail → spring-boot-starter-mail
- Security → spring-boot-starter-security
- Mapping → mapstruct
