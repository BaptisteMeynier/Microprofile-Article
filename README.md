
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

sudo k3s kubectl create -f ./src/main/k3s/fishs-deployment.yaml

[Microprofile-Article]$ sudo k3s kubectl get pods
NAME                               READY   STATUS             RESTARTS   AGE
fish-deployment-59548dcc57-vjk86   0/1     CrashLoopBackOff   5          35m


sudo k3s kubectl logs fish-deployment-59548dcc57-vjk86