FROM eclipse-temurin:17-jdk

WORKDIR /app

COPY . .

RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# 👇 VERY IMPORTANT LINE
ENV PORT=8080

EXPOSE 8080

CMD ["java", "-Dserver.port=8080", "-jar", "target/lead-ai-backend-0.0.1-SNAPSHOT.jar"]