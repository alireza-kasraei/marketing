# Online Shop

Online Shop Cloud Native Application with most recent cloud native patterns

# How to Start

as you can see it is a maven based project. for simplicity execute  :

```sh
mvn clean package -Poracle -DskipTests 
```
and then run
 
```sh
docker-compose up
```
and then execute same command for service-discovery modules and authorization-service.
please consider ports for each module.

after all you can test authorization-service with the following command :

```sh
curl -X POST \
-H"authorization: Basic aHRtbDU6cGFzc3dvcmQ=" \                  
-F"password=spring" \        
-F"client_secret=password" \
-F"client_id=html5" \
-F"username=jlong" \
-F"grant_type=password" \
-F"scope=openid" \
http://localhost:9191/uaa/oauth/token
```

and if everythis goes right with the given access-token , you can call the sample secured api with the given command :

```sh
curl \        
-H"Authorization: Bearer afa30a93-e1b7-4fff-a850-e2778dd13162" \ 
http://localhost:8080/greet/hello
```

if you want to pull images and run containers just run :

```sh
docker-compose pull
docker-compose up -d --no-build
```