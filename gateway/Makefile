.PHONY: docker

docker-clean:
	docker system prune -f

build:
	mvn clean package -DskipTests

docker: build docker-clean
	docker build . -t shop/gateway

tag:
	docker tag shop/gateway registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-gateway:latest

push:
	docker push registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-gateway