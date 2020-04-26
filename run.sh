#bin/bash!

sudo k3s kubectl apply -f ./src/main/k3s/fishs-database.yaml
sudo k3s kubectl apply -f ./src/main/k3s/fishs-cm.yaml
sudo k3s kubectl apply -f ./src/main/k3s/fishs-application.yaml

sudo k3s kubectl get all