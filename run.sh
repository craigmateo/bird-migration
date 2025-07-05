#!/bin/bash

#!/bin/bash

echo "🔨 Compiling with Maven..."
mvn compile

echo "🚀 Running application..."
mvn exec:java -Dexec.mainClass="com.craig.BirdMigrationApp"
