## Spring Cloud K8s Shop Demo

* Make sure you have a running Kubernetes cluster first
* Clone this project to local
* Build with: `make -pl gateway,member-service,product-service,trade-service clean install docker:build -DskipTests`
* Apply resources to Kubernetes: `kubectl apply -R -f deploy/`
* `curl <cluster-ip>:30080/members/detail`


> member-service/members/detail -> trade-service/trades -> product-service/products

## Telepresence

* `curl <cluster-ip>:30080/members`

* Swap deployment in Kubernetes cluster with locals.

> `telepresence --swap-deployment member-service --expose 8081 --run mvn spring-boot:run -pl member-service`

* Modify member-service, save and rebuild, then it could be reloaded
