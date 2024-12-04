springboot-mongodb-docker
Deploying Spring Boot and MongoDB as Containers Using Docker and Docker Compose

Steps & Commands

 pull mongo image from docker hub docker pull mongo:latest
 run mongo image docker run -d -p 27017:27017 --name javatechiemongodb mongo:latest
 dockerize spring boot application docker build -t springboot-mongodb:1.0 .
 run spring boot docker image and link that container to mongo container 
 docker run -p 8080:8080 --name springboot-mongodb --link javatechiemongodb:mongo -d springboot-mongodb:1.0
 check docker running containers docker ps it should display two container ids
 check logs of spring boot image docker logs springboot-mongodb
 if all good access your api 🎉
curl --location --request POST 'http://localhost:8080/books' \
--header 'Content-Type: application/json' \
--data-raw '{
    "id":1,
    "bookName":"corejava",
    "authorName":"Basant"
}'
 login to mongo terminal to verify records docker exec -it javatechiemongodb bash
type mongo and enter
show dbs
use book
show collections
db.book.find().pretty()
Use Docker Compose

 Kill running container:
docker rm <containerId>
docker-compose.yml
version: "3"
services:
  javatechiemongodb:
    image: mongo:latest
    container_name: "javatechiemongodb"
    ports:
      - 27017:27017
  springboot-mongodb:
    image: springboot-mongodb:1.0
    container_name: springboot-mongodb
    ports:
      - 8080:8080
    links:
      - javatechiemongodb
 navigate to resources folder:
springboot-mongo-docker/src/main/resources and run docker-compose up
