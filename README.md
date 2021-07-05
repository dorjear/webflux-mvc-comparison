# Webflux vs Spring MVC
Compaction between spring 5 servlet stack vs WebFlux reactive stack

For testing, we have a rest endpoint POST /persons that accepts a json Person object and returns an object with UUID.
Gatlin is used to run the tests and generate report.

Start the app with
In person-registration-slow-service: mvn spring-boot:run
In sample-reactive-spring-boot-2 or sample-spring-boot-2 : mvn spring-boot:run
Run tests in perf-test-with-gatling with
./gradlew loadTest -D SIM_USERS=5000
