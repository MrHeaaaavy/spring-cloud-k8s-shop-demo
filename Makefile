SUBMODULES = gateway,member-service,product-service,trade-service

.PHONY: build docker publish

build:
	mvn -N clean install -DskipTests
	mvn clean install -DskipTests

docker: build
	mvn -pl ${SUBMODULES} clean package docker:build -DskipTests

publish:
	mvn -pl ${SUBMODULES} docker:push
