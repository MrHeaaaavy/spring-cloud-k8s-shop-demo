FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine as extractor
WORKDIR /application
COPY target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk11:jdk-11.0.8_10-alpine
WORKDIR /application
COPY --from=extractor /application/dependencies/ ./
COPY --from=extractor /application/snapshot-dependencies/ ./
COPY --from=extractor /application/spring-boot-loader/ ./
COPY --from=extractor /application/application/ ./
EXPOSE 8081
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
