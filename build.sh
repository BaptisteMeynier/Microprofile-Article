#bin/bash!

sudo service docker start

docker build -t keywer/microprofile/k3s-init-database:v1.0.0 -f ./src/main/docker/db/init/Dockerfile .
docker build -t keywer/microprofile/k3s-database:v1.0.0 -f ./src/main/docker/db/Dockerfile .
docker build -t keywer/microprofile/k3s-application:v1.0.0 -f ./src/main/docker/app/Dockerfile .

docker save keywer/microprofile/k3s-init-database:v1.0.0 -o target/init-database.tar
docker save keywer/microprofile/k3s-database:v1.0.0 -o target/database.tar
docker save keywer/microprofile/k3s-application:v1.0.0 -o target/application.tar

sudo mv ./target/*.tar /var/lib/rancher/k3s/agent/images/

sudo k3s crictl images