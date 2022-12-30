# jfx-playground

Demo project for integrating Spring Boot and JavaFX. The Demo has the following features:

1. Simple working sample code for a small desktop application.
2. Configuration for maven project to use JavaFX with Spring Boot, with the appropriate maven artifact 
   dependencies for basic development.
3. Uses recent, reasonably up-to-date JavaFX modules, with consistent versions 
   (which is something many beginners often don't do).
4. Demonstrates placing an FXML file in a resource directory, and looking it up as a resource at runtime
   (which is something many, many beginners get wrong).
5. Properly separates a Controller class from the Application class 
   (which is also something many beginners get wrong).


## Which technologies are being used ?

The project uses the following technologies:

- JavaFX 8
- Spring Boot v2.2.4.RELEASE

## Prerequisites and getting started

- Download and install Oracle JDK 8 (which includes all JavaFX modules).
- Open the command line and navigate to the project folder, then run the following commands:
    1. `./mvnw clean verify`
    2. `./mvnw spring-boot:run`
