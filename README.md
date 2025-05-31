# 📦 Scalable Tracking Number Generator API

This is a RESTful API built with **Java Spring Boot** that generates **unique tracking numbers** for parcels. It is designed to be **scalable**, **efficient**, and capable of handling **high concurrency**.

---

## 🚀 Features

- Generate tracking numbers that match: `^[A-Z0-9]{1,16}$`
- Ensures uniqueness (no duplicates)
- Thread-safe and stateless — scalable horizontally
- Uses `SecureRandom` for secure ID generation
- Accepts order metadata as query parameters

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot 3+
- Maven
- H2 (in-memory DB, can switch to MySQL/Postgres)
- Lombok
- REST API (GET method)

---

## 📦 Setup Instructions

### 1. ✅ Prerequisites

- Java 17+
- Maven 3.6+
- IDE (IntelliJ or Eclipse recommended)
- Internet access for dependency downloads

---

### 2. ⏬ Clone the Repository

```bash
git clone https://github.com/Shehbaaz15/tracking_number_api.git
cd tracking_number_api

###
Api endpoint: http://localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2025-05-29T10:00:00%2B08:00&customer_id=de619854-b59b-425e-9db4-943979e1bd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics