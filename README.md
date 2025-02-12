# URL Shortener Project

A simple URL shortener built with **Spring Boot, JPA, and PostgreSQL**. It allows users to shorten URLs, customize short codes, and redirect to original links.

## 🚀 Features
- Generate a **short URL** for any long URL.
- Support for **custom short codes**.
- **Automatic redirection** when visiting a short URL.
- **Persistent storage** using PostgreSQL.
- **RESTful API** for easy integration.

## 🛠️ Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/yourusername/url-shortener.git
cd url-shortener
```

### 2️⃣ Configure the Database
Ensure PostgreSQL is installed and running. Then, create a database:
```sh
psql -U postgres -c "CREATE DATABASE url_shortener_db;"
```

### 3️⃣ Update `application.properties`
Edit `src/main/resources/application.properties` to match your PostgreSQL credentials:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/url_shortener_db
spring.datasource.username=postgres
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```

### 4️⃣ Build & Run the Project
```sh
mvn clean package
mvn spring-boot:run
```

The application will start at **`http://localhost:8080`**.

## 🚀 API Usage

### 🔹 Shorten a URL
```sh
curl -X POST "http://localhost:8080/api/api/shorten?LongUrl=https://www.google.com"
```
📌 **Response:**
```json
{"shortUrl": "http://localhost:8080/api/abc123"}
```

### 🔹 Custom Short URL
```sh
curl -X POST "http://localhost:8080/api/api/shorten?LongUrl=https://www.google.com&customNameUrl=myGoogle"
```
📌 **Response:**
```json
{"shortUrl": "http://localhost:8080/api/myGoogle"}
```

### 🔹 Redirect to Original URL
```sh
curl -i "http://localhost:8080/api/abc123"
```
📌 **Response:**
```
HTTP/1.1 302 Found
Location: https://www.google.com
```

## 🛠️ Technologies Used
- **Spring Boot** - Backend Framework
- **Spring Data JPA** - ORM for database management
- **PostgreSQL** - Database
- **Maven** - Dependency Management
- **Lombok** - Reduces boilerplate code

## 📜 License
This project is **open-source** and available under the [MIT License](LICENSE).

## 🤝 Contributing
1. **Fork** the repository
2. **Create** a feature branch (`git checkout -b feature-name`)
3. **Commit** your changes (`git commit -m 'Added a new feature'`)
4. **Push** to your branch (`git push origin feature-name`)
5. **Create a Pull Request** 🚀

## 📧 Contact
For any issues, please open an **[Issue](https://github.com/yourusername/url-shortener/issues)** or reach out via email.

---
🔥 **Enjoy coding!** 🚀
