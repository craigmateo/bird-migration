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

3. **Build the project with Maven**:

    ```bash
    mvn compile
    ```

4. **Run the project**:

    ```bash
    mvn exec:java -Dexec.mainClass="com.craig.birdmigration.BirdMigrationApp"
    ```

    *(Make sure you have added the `exec-maven-plugin` in your `pom.xml` for this.)*

---

## 🚀 Current Features

- Connects to local MySQL using Maven dependencies
- Reads credentials from `db.properties`
- Executes a basic `SELECT * FROM birds` query (if table exists)

---

## 🧭 Next Ideas

- Add insertion logic for birds and locations
- Integrate eBird API for real-time migration data
- Display migration routes on an interactive map (JavaFX or web frontend)
- Add user input or filters

---

## 🔒 Security Notes

- Never commit `db.properties` with real credentials to version control.
- Add it to `.gitignore`.
