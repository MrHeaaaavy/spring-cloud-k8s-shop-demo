.PHONY: build docker publish

build:
	mvn -N clean install -DskipTests
	mvn clean install -DskipTests

docker: build
	mvn clean docker:build -DskipTests

publish:
	mvn docker:push
