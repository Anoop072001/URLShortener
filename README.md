# URL Shortener Project

A simple URL shortener built with **Spring Boot, JPA, and PostgreSQL**. It allows users to shorten URLs, customize short codes, and redirect to original links. The backend is **hosted on Railway**.

## 🚀 Features
- Generate a **short URL** for any long URL.
- Support for **custom short codes**.
- **Automatic redirection** when visiting a short URL.
- **Persistent storage** using PostgreSQL.
- **RESTful API** for easy integration.
- **Deployed on Railway** for cloud hosting.

## 🛠️ Installation & Setup

### 1️⃣ Clone the Repository
```sh
git clone https://github.com/Anoop072001/URLShortener.git
cd url-shortener
```

### 2️⃣ Configure the Database
Ensure PostgreSQL is installed and running. Then, create a database:
```sh
psql -U postgres -c "CREATE DATABASE urlshortener;"
```

### 3️⃣ Update `application.properties`
Edit `src/main/resources/application.properties` to match your PostgreSQL credentials:
```properties
spring.application.name=URLShortener
spring.datasource.url=jdbc:postgresql://localhost:5432/urlshortener
spring.datasource.username=
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
```

### 4️⃣ Build & Run the Project
```sh
mvn clean package
mvn spring-boot:run
```

The application will start at **`http://localhost:8080`**.

## 🚀 Hosted Version
The backend is **deployed on Railway** and available at:
```
https://urlshortener-anoops.up.railway.app
```

## 🚀 API Usage

### 🔹 Shorten a URL
```sh
curl -X POST "https://urlshortener-anoops.up.railway.app/api/shorten?longUrl=https://www.google.com"
```
📌 **Response:**
```json
{"shortUrl": "https://urlshortener-anoops.up.railway.app/api/abc123"}
```

### 🔹 Custom Short URL
```sh
curl -X POST "https://urlshortener-anoops.up.railway.app/api/shorten?longUrl=https://www.google.com&customShortCode=myGoogle"
```
📌 **Response:**
```json
{"shortUrl": "https://urlshortener-anoops.up.railway.app/api/myGoogle"}
```

### 🔹 Redirect to Original URL
```sh
curl -i "https://urlshortener-anoops.up.railway.app/api/abc123"
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
- **Railway** - Cloud hosting platform

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
