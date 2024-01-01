# jfx-playground

Demo project for integrating _Spring Boot_ and _JavaFX_. The Demo has the following features:

1. Simple working sample code for a small desktop application.
2. Configuration for _maven_ or _gradle_ project to use _JavaFX_ with _Spring Boot_, with the appropriate maven artifact.
   dependencies for basic development.
3. Uses recent, reasonably up-to-date _JavaFX_ modules, with consistent versions.
4. Demonstrates placing an _FXML_ file in a resource directory, and looking it up as a resource at runtime.
5. Properly separates a controller class from the application class.
6. Demonstrates how to bootstrap _JavaFX_ application using _Spring Boot_.
7. Demonstrates how to use _Spring Boot_ features within _JavaFX_.
8. Showcase how to navigate between _JavaFX_ view using a router implementation, heavily inspired on Angular/Router.

## Which technologies are being used ?

The project uses the following technologies:

- JavaFX 17
- Spring Boot v3.2.0

## Developer Guide

### Prerequisites 

- Download and install JDK 17.

### How to run?

- Open the command line and navigate to the project folder.
- To run using maven use `./mvnw spring-boot:run` command.
- To run using gradle use `./gradlew bootRun` command.
