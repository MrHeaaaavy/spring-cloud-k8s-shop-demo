## Spring Cloud K8s Shop Demo

* make sure you have a running Kubernetes cluster first
* clone this project to local
* `mvn clean package -DskipTests`
* prepare docker images: `make all`
* apply resources to Kubernetes:
  * `kubectl apply -f ./rbac.yaml`
  * `kubectl apply -f gateway/deploy/`
  * `kubectl apply -f member-service/deploy/`
  * `kubectl apply -f product-service/deploy/`
  * `kubectl apply -f trade-service/deploy/`
* `curl <cluster-ip>:30080/members/detail`


> member-service/members/detail -> trade-service/trades -> product-service/products
