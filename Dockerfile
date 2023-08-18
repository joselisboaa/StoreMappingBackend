FROM eclipse-temurin:17-jammy

ENV SPRING_DATASOURCE_URL=jdbc:postgres://joseneto:xG5931geE9fE4zhvbOgTnMqx5TJlH2Bl@dpg-cis2v6h8g3n42ol22agg-a/store_db_oin1
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./

RUN chmod +x ./mvnw
RUN ./mvnw dependency:go-offline

RUN addgroup demogroup; adduser  --ingroup demogroup --disabled-password demo
USER demo

COPY src ./src

VOLUME /tmp
EXPOSE 8081

CMD ["./mvnw", "spring-boot:run"]