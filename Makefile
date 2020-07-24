SUBMODULES = gateway member-service product-service trade-service

.PHONY: build docker publish

build:
	mvn clean install -DskipTests

docker: build
	mvn -pl gateway clean package docker:build -DskipTests
	mvn -pl member-service clean package docker:build -DskipTests
	mvn -pl product-service clean package docker:build -DskipTests
	mvn -pl trade-service clean package docker:build -DskipTests

publish:
	mvn -pl gateway docker:push
	mvn -pl member-service docker:push
	mvn -pl product-service docker:push
	mvn -pl trade-service docker:push
