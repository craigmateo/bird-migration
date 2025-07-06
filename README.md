# 🐦 Bird Migration Java + MySQL Demo (Maven)

This Java project connects to a MySQL database and can be extended to explore bird migration patterns — potentially using real-world data from sources like [eBird](https://documenter.getpostman.com/view/664302/ebird-api-20/2HTbHW).

---

## ✅ Prerequisites

- Java Development Kit (JDK) installed and on your PATH  
- MySQL installed and running locally  
- MySQL Workbench (optional GUI)  
- Maven installed and configured  
- Bash (WSL or Linux terminal)  

---

## 📁 Project Structure (Maven Standard)

    bird-migration/
    ├── src/
    │ ├── main/
    │ │ ├── java/
    │ │ │ └── com/craig/birdmigration/
    │ │ │ └── BirdMigrationApp.java # Main Java source file
    │ │ └── resources/
    │ │ └── db.properties # Database credentials (not versioned)
    ├── target/ # Compiled classes and packaged JARs (auto-generated)
    ├── pom.xml # Maven project file
    └── run.sh # Optional script to run Maven commands

---


---

## 🔧 Setup Steps

1. **Create the database in MySQL**:

    ```sql
    CREATE DATABASE bird_migration;
    USE bird_migration;
    ```

2. **Configure your database credentials**:

    Create `src/main/resources/db.properties` (add to `.gitignore`):

    ```properties
    db.url=jdbc:mysql://localhost:3306/bird_migration
    db.user=root
    db.password=your_password_here
    ```

3. **(Recommended) Use environment variables for secrets**

    Instead of hardcoding credentials, export environment variables in your terminal or OS profile:

    ```bash
    export DB_USER=root
    export DB_PASSWORD=your_password_here
    export EBIRD_API_TOKEN=your_ebird_api_key_here
    ```

    These can be referenced in `application.properties` or your Java code as `${DB_USER}`, `${DB_PASSWORD}`, and `${EBIRD_API_TOKEN}`. This approach keeps your secrets out of the codebase.

4. **Build the project with Maven**:

    ```bash
    mvn compile
    ```

5. **Run the project**:

    ```bash
    mvn spring-boot:run
    ```

    *(Make sure you have the `spring-boot-maven-plugin` configured in your `pom.xml`.)*

---

## 🚀 Current Features

- Connects to local MySQL using Maven dependencies  
- Reads credentials from `db.properties` or environment variables  
- REST API exposes endpoints to:  
  - Fetch birds from the database  
  - Query eBird API for real-time bird data if not in local DB (e.g., `/api/ebird/bird/{name}`)  
- Saves eBird API results into the local database for caching  

---

## 🐦 eBird API Integration

- Base URL: `https://api.ebird.org/v2/`  
- Example endpoint to get recent observations for a region:  
  `GET /data/obs/{regionCode}/recent`  
- Authentication:  
  Include your API token in the header for all requests:  
