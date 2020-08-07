## Spring Cloud K8s Shop Demo

* Make sure you have a running Kubernetes cluster first
* Clone this project to local
* See `Makefile` fro details

## Telepresence

* `curl <cluster-ip>:30080/members`

* Swap deployment in Kubernetes cluster with locals.

> `telepresence --swap-deployment member-service --expose 8081 --run mvn spring-boot:run -pl member-service`

* Modify member-service, save and rebuild, then it could be reloaded

## Helm

* `cd deploy`
* `helm install shop-demo --debug --namespace=YOUR-NAMESPACE -n shop-demo-testing`

## KubeSphere App Store

* `cd deploy`
* `helm package shop-demo`
* Upload shop-demo-VERSION.tgz to KubeSphere.