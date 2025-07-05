#!/bin/bash

echo "🔨 Compiling..."
javac -cp "lib/mysql-connector-j-9.3.0.jar" -d bin src/BirdMigrationApp.java

if [ $? -eq 0 ]; then
    echo "🚀 Running..."
    java -cp "bin:lib/mysql-connector-j-9.3.0.jar" BirdMigrationApp
else
    echo "❌ Compilation failed."
fi
