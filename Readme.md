# Zuul, Eureka and Spring Boot Service

Original microservices BaseUrl : 
- http://localhost:8181/catalog/
- http://localhost:8182/movies/
- http://localhost:8183/ratingsdata/

Eureka Server Path:
- http://localhost:8761/

Registered Service Names on Eureka:
- MOVIE-CATALOG-SERVICE
- MOVIE-INFO-SERVICE
- MOVIE-RATING-SERVICE
- ZUUL-SERVER

Zuul Routes Location :
- http://localhost:8762/actuator/routes

Test the service **Routed Request**:
- http://localhost:8762/movie-catalog-service/catalog/1
