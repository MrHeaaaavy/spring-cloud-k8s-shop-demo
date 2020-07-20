.PHONY: docker

docker-clean:
	docker system prune -f

docker: docker-clean
	docker build . -t shop/member-service

tag:
	docker tag shop/member-service registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-member-service:latest

push:
	docker push registry.cn-shenzhen.aliyuncs.com/mrheaaaavy/shop-member-service
