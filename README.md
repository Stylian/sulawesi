# sulawesi
the gradle wrapper requires java 17

view keycloak at http://localhost:8080/
view eureka   at http://localhost:8761/

needs before gradle build
docker compose up -d 

### TODO

currently keycloak doesn't work out of the box, configuration is needed as 
in https://www.youtube.com/watch?v=rbKzR6QWKLI&list=PLSVW22jAG8pBnhAdq9S8BpLnZ0_jVBj0c&index=7

circuit breaker can be tested when needed, on calling one service from another