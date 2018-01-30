

# reading data from repository using webflux
```
mvn spring-boot:run
curl http://localhost:8081/cars

```


# inject data into reactive repository and streams the data with reactive mongo and webflux
```
curl -v –H "Accept: application/stream+json" http://localhost:8081/cars

java -jar ./target/demo-reactive-spring-livecoding-0.0.1-SNAPSHOT.jar
```
