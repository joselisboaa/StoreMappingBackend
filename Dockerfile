FROM eclipse-temurin:17-jammy

RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo
USER demo

WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN ./mvnw dependency:go-offline

COPY src ./src

VOLUME /tmp
EXPOSE 8081

CMD ["./mvnw", "spring-boot:run"]