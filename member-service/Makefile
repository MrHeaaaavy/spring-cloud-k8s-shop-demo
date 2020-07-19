.PHONY: docker

docker-clean:
	docker system prune -f

build:
	mvn clean package -DskipTests

docker: build docker-clean
	docker build . -t shop/member-service
