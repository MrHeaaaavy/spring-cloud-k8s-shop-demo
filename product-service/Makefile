.PHONY: docker

docker-clean:
	docker system prune -f

docker: docker-clean
	docker build . -t shop/product-service

tag:
	docker tag shop/product-service registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-product-service:latest

push:
	docker push registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-product-service

