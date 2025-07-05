# 🐦 Bird Migration Java + MySQL Demo

This is a simple Java project that connects to a MySQL database and can be extended to explore bird migration patterns — potentially using real-world data from sources like [eBird](https://documenter.getpostman.com/view/664302/ebird-api-20/2HTbHW).

---

## ✅ Prerequisites

- Java Development Kit (JDK) installed and on your PATH
- MySQL installed and running locally
- MySQL Workbench (optional GUI)
- MySQL Connector/J (`mysql-connector-j-9.3.0.jar`)
- Bash (WSL or Linux terminal)

---

## 📁 Project Structure

    bird-migration/
    ├── bin/ # Compiled Java .class files
    ├── lib/
    │ └── mysql-connector-j-9.3.0.jar # JDBC driver
    ├── src/
    │ └── BirdMigrationApp.java # Main Java source file
    ├── db.properties # Database credentials (not versioned)
    └── run.sh # Compile + Run script

---

## 🔧 Setup Steps

1. **Create the database in MySQL**:
    ```sql
    CREATE DATABASE bird_migration;
    USE bird_migration;
    ```

    (Add a `birds` table as needed.)

2. **Download MySQL Connector/J**:
    - Place `mysql-connector-j-9.3.0.jar` into the `lib/` folder.

3. **Create `db.properties` in the project root**:
    ```properties
    db.url=jdbc:mysql://localhost:3306/bird_migration
    db.user=root
    db.password=your_password_here
    ```

4. **Use `run.sh` to compile and run the project**:
    ```bash
    ./run.sh
    ```

---

## 🚀 Current Features

- Connects to local MySQL
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
- Add it to `.gitignore` if using Git.

