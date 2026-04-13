FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# 🔥 DO NOT hardcode port
CMD ["java", "-jar", "target/lead-ai-backend-0.0.1-SNAPSHOT.jar"]