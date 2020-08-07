FROM adoptopenjdk/openjdk11:alpine as extractor
WORKDIR /application
COPY target/*.jar application.jar
RUN java -Djarmode=layertools -jar application.jar extract

FROM adoptopenjdk/openjdk11:alpine
WORKDIR /application
COPY --from=extractor /application/dependencies/ ./
COPY --from=extractor /application/snapshot-dependencies/ ./
COPY --from=extractor /application/spring-boot-loader/ ./
COPY --from=extractor /application/application/ ./
EXPOSE 8080
ENTRYPOINT ["java", "org.springframework.boot.loader.JarLauncher"]
