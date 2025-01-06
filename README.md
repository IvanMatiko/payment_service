# Payment Service

## Overview
Payment Service is a backend application designed for managing financial transactions and payment processing. It provides APIs to handle operations such as initiating, tracking, and updating payment statuses, as well as managing payment methods and user accounts.

## Features
- **Transaction Management:** Create, update, and retrieve payment transactions.
- **Payment Methods:** Support for multiple payment methods (e.g., credit cards, bank transfers).
- **Payment Status Tracking:** Real-time updates on the status of payments.
- **Integration-Friendly:** Exposes REST APIs for seamless integration with other services.
- **Swagger Documentation:** Built-in API documentation for developers.

## Getting Started

### Prerequisites
- Java 17
- Docker (optional for containerized deployment)
- Gradle

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/IvanMatiko/payment_service.git
   cd payment_service

2. Build the project:

   ./gradlew build

3. Run the application:

  ./gradlew bootRun

4. Optional (Build and run with Docker):

 docker build -t post-service . docker run -p 8080:8080 post-service

# API Endpoints
POST /payments: Initiate a new payment transaction.

GET /payments/{id}: Retrieve the status of a specific payment.

PUT /payments/{id}: Update payment details.

DELETE /payments/{id}: Cancel a payment by ID.

For detailed API specifications, refer to the Swagger documentation.

# Technologies Used
Java: Core programming language.

Spring Boot: Framework for backend development.

Gradle: Build tool for dependency management and automation.

Swagger: API documentation.

Docker: Containerization for deployment.
