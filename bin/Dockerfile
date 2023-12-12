FROM eclipse-temurin:17-jammy

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline -e

RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo
USER demo

COPY src ./src

VOLUME /tmp
EXPOSE 8081

CMD ["./mvnw", "spring-boot:run"]