# jfx-playground

## Description

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

## Technologies Used

The project uses the following technologies:

- **Java JDK 21**: The latest version of Java Development Kit is used for implementing the application logic.
- **JavaFX 21**: A software platform for creating and delivering desktop applications.
- **Spring Boot v3.2.0**: An open source Java-based framework used to create a Micro Service. It is developed by Pivotal Team.

## Getting Started

### Prerequisites 

- Java JDK version 21.
- An IDE that supports Java and Spring MVC development, such as IntelliJ IDEA
- Maven or Gradle

### Installing

1. Clone the repository `git clone git@github.com:ehayik/jfx-playground.git`
2. Open the project folder.
3. Run `mvn clean compile` to install the necessary dependencies from the POM file.

### Running locally

- Open the command line and navigate to the project folder.
- To run with maven use `./mvnw spring-boot:run` command.
- To run with gradle use `./gradlew bootRun` command.
