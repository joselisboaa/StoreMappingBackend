FROM eclipse-temurin:17-jammy

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw
RUN ./mvnw clean package

COPY src ./src

VOLUME /tmp
EXPOSE 8081

CMD ["./mvnw", "spring-boot:run"]