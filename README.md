# java-dropwizard-app

This is a dropwizard application which includes

- /movies REST resource

- OAuth authorization basic bearer implementation

- health check

- metrics

When you run the application, it will be available on http://localhost:8080/application

http://localhost:8080/application/movies/all - returns all movies available (mock data with only 1 movie returned from MovieService

http://localhost:8081/metrics - shows metrics collected for the app using dropwizard metrics annotations like @Timed

For authorization using postman, use bearer authorization as shown below

![movies API with authorization](https://user-images.githubusercontent.com/40746508/177219250-c9999be4-7efb-45dd-b023-dbec02621f4e.jpg)

Metrics returned as shown below

![metrics](https://user-images.githubusercontent.com/40746508/177219344-ecdd203d-1832-4af3-8642-aab6944576f9.jpg)
