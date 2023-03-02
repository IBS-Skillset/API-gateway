# API-gateway

## Docker commands to run in local

 `docker build -t api-gateway .`

 `docker run -p 9192:9192 -e EUREKA_SERVER=http://172.17.0.2:8761/eureka/ -e AUTH_SERVER=http://172.17.0.4:9000/auth-server --name api-gateway api-gateway`

NOTE : The ip in the url has to be replaced by the container ip of the respective containers. To get the container ip run the following command.

docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container-name

eg:- docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' service-registry

