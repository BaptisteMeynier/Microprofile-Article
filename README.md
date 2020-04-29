
curl -sfL https://get.k3s.io | sh -

https://kauri.io/38-install-and-configure-a-kubernetes-cluster-with/418b3bc1e0544fbc955a4bbba6fff8a9/a

https://dzone.com/articles/lightweight-kubernetes-k3s-installation-and-spring

https://medium.com/better-programming/using-a-k3s-kubernetes-cluster-for-your-gitlab-project-b0b035c291a9

mvn clean package

sudo service docker start

docker build -t keywer/k3s-fishs:v1.0.0 -f ./src/main/docker/Dockerfile .

docker save keywer/k3s-fishs:v1.0.0 -o target/fish.tar

cd /var/lib/rancher/k3s/agent/
sudo mkdir images

sudo mv ./target/fish.tar /var/lib/rancher/k3s/agent/images/

restart k3s

sudo k3s kubectl create -f ./src/main/k3s/fishs-deployment.yaml

[Microprofile-Article]$ sudo k3s kubectl get pods -o wide
NAME                               READY   STATUS    RESTARTS   AGE   IP           NODE              NOMINATED NODE   READINESS GATES
fish-deployment-6dcbf9fb76-vwf2z   1/1     Running   0          38m   10.42.0.25   xxxxxxxxxxxxxxx   <none>           <none>

http://10.42.0.25:8080/shop/fish/family/Sphyrnidae

sudo k3s kubectl logs fish-deployment-59548dcc57-vjk86

docker build -t keywer/k3s-database-fishs:v1.0.0 -f ./src/main/k3s/database/Dockerfile .

docker run -p 8082:8082 -p 9092:9092 -d -it keywer/k3s-database-fishs:v1.0.0

init container:

java -cp <path_to_your_h2-*.jar> org.h2.tools.RunScript -url jdbc:h2:mem:testdb -script test.sql
jdbc:h2:mem:testdb

java -cp /home/baptiste/Resources/H2/2019-10-14/bin/h2-1.4.199.jar org.h2.tools.Server -web -webAllowOthers -webPort 8080 -tcp -tcpAllowOthers -tcpPort 1521 -baseDir ~/h2-data

java -cp /home/baptiste/Resources/H2/2019-10-14/bin/h2-1.4.199.jar org.h2.tools.RunScript -user sa -showResults -url jdbc:h2:mem:testdb -script ./src/main/k3s/database/schema.sql
java -cp /home/baptiste/Resources/H2/2019-10-14/bin/h2-1.4.199.jar org.h2.tools.RunScript -user sa -showResults -url jdbc:h2:tcp://localhost:1521/~/h2-data/fish -script ./src/main/k3s/database/schema.sql
java -cp /home/baptiste/Resources/H2/2019-10-14/bin/h2-1.4.199.jar org.h2.tools.RunScript -user sa -showResults -url jdbc:h2:file:~/h2-data/fish -script ./src/main/k3s/database/schema.sql

docker build -t keywer/k3s-init-database-fishs:v1.0.0 --network="host" -f ./src/main/k3s/database/init/Dockerfile .

keywer/microprofile/k3s-init-database:v1.0.0

sudo docker exec -it 8ca232ce5e7e /bin/bash

--------------------------

sudo service docker start

docker build -t keywer/microprofile/k3s-init-database:v1.0.0 -f ./src/main/docker/db/init/Dockerfile .
docker build -t keywer/microprofile/k3s-database:v1.0.0 -f ./src/main/docker/db/Dockerfile .
docker build -t keywer/microprofile/k3s-application:v1.0.0 -f ./src/main/docker/app/Dockerfile .

docker save keywer/microprofile/k3s-init-database:v1.0.0 -o target/init-database.tar
docker save keywer/microprofile/k3s-database:v1.0.0 -o target/database.tar
docker save keywer/microprofile/k3s-application:v1.0.0 -o target/database.tar

sudo mv ./target/*.tar /var/lib/rancher/k3s/agent/images/

sudo k3s crictl images

sudo k3s kubectl create -f ./src/main/k3s/fishs-database.yaml

sudo k3s kubectl create -f ./src/main/k3s/fishs-cm.yaml

sudo k3s kubectl create -f ./src/main/k3s/fishs-application.yaml

sudo k3s kubectl get pods -o wide

sudo kubectl exec -it fish-database -- /bin/bash

sudo k3s kubectl logs fishs-database

sudo k3s kubectl logs fishs-database -c init-database

sudo k3s kubectl logs fishs-application

sudo k3s kubectl describe fishs-database-745b745667-pdg9p

sudo k3s crictl rmi 46f889be77389

http://192.168.1.37:8080/shop/fish/family/Sphyrnidae


sudo k3s kubectl apply -f ./src/main/k3s/fishs-hpa.yaml

sudo k3s kubectl apply -f ./src/main/k3s/fishs-secret.yaml