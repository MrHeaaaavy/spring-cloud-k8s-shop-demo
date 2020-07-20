.PHONY: docker

docker-clean:
	docker system prune -f

docker: docker-clean
	docker build . -t shop/trade-service

tag:
	docker tag shop/trade-service registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-trade-service:latest

push:
	docker push registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-trade-service

