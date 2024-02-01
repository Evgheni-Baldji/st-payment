FROM maven:3.9.4-amazoncorretto-20 AS MAVEN_BUILD
ARG BUILD_ID=0.0.1-SNAPSHOT
COPY pom.xml /build/
COPY src /build/src/
RUN mkdir -p /root/.m2 \  && mkdir /root/.m2/repository
COPY settings.xml /root/.m2
WORKDIR /build/
RUN mvn clean package -DskipTests  -Dbuild.version=${BUILD_ID} -ntp

FROM openjdk:20
USER root
ENV DB_HOST=172.16.0.2
ENV DB_NAME=aphahold
ENV DB_USERNAME=postgres
ENV DB_PASSWORD=w3347986W
ENV DB_PORT=5432
ARG BUILD_ID=0.0.1-SNAPSHOT
RUN mkdir -p /app && mkdir -p /app/config
WORKDIR /app
COPY --from=MAVEN_BUILD /build/target/payment-${BUILD_ID}.jar /app/payment.jar
EXPOSE 8080

ENTRYPOINT exec java -jar -Dspring.profiles.active=release  payment.jar