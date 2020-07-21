.PHONY: docker

docker-clean:
	docker system prune -f

docker: docker-clean
	docker build . -t shop/gateway

tag:
	docker tag shop/gateway registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-gateway:latest

push:
	docker push registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-gateway