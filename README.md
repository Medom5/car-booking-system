# Car Booking System

Java CLI car booking system with features like reservations, user management, and car availability tracking.

## Description

This project is a comprehensive car booking system implemented in Java, designed to provide users with a seamless experience for booking cars, managing reservations, and tracking car availability. The system emphasizes clean code practices and adheres to SOLID principles, ensuring maintainability and scalability.

## Demo

![project demo](assets/java.gif)

## Features

- **User Management**: Handle user registrations and maintain user profiles.
- **Car Reservations**: Allow users to book available cars and manage their reservations.
- **Availability Tracking**: Monitor and update the availability status of cars in real-time.
- **Data Persistence with Multiple Implementations**:
  - DAO design pattern with support for **CSV-based storage**, **in-memory storage**, and **Java Faker-generated data** for flexible testing and development.
- **Manual Dependency Injection**: Manage dependencies manually to maintain control over component interactions.
- **Stream API Utilization**: Leverage Java's Stream API for clean and efficient data processing.
- **Extensive Unit Testing**: Includes 28 unit tests to ensure system reliability and robustness.

## Technologies Used

- **Maven**: Utilized for build automation and dependency management.
- **Java Faker**: Employed for generating realistic fake data during development and testing.
- **JUnit 5**: Used for writing and executing unit tests to validate system functionality.

## Design Patterns and Principles

- **DAO Design Pattern**: Facilitates data persistence and retrieval with implementations for CSV, in-memory, and Java Faker-based data sources.
- **Manual Dependency Injection**: Enhances modularity and testability by manually managing component dependencies.
- **Stream API**: Enables concise and readable code for processing collections and data streams.
- **Clean Code Practices**: Ensures the codebase is readable, maintainable, and adheres to industry standards.
- **SOLID Principles**: Applied to achieve a robust, flexible, and scalable architecture.

## Prerequisites

- **Java Development Kit (JDK)**: Ensure that **JDK 17** or higher is installed on your system. You can check your JDK version by running:

```bash
java -version
```

If not installed, download it from the [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) or [OpenJDK](https://openjdk.org/) website.

- **Maven**: Verify that Apache Maven is installed and properly configured in your environment. You can check the version by running:

```bash
mvn -version
```

If Maven is not installed, download and install it from the [Maven](https://maven.apache.org/download.cgi) website.

## Installation and Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Medom5/car-booking-system.git
   cd car-booking-system
   ```

2. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Running the Project

To run the project, you can execute the main class directly from your IDE or create a JAR file.

### Running from IDE

Open the project in your preferred IDE (e.g., IntelliJ IDEA, Eclipse).
Locate the main class `carbookingsystem.Main` and run it.

### Creating and Running a JAR File

1. Package the application into a JAR file using Maven:
   ```bash
   mvn package
   ```
2. Run the JAR file:
    ```bash
    java -jar target/car-booking-system-1.0-SNAPSHOT-jar-with-dependencies.jar
    ```

## Testing
- **Mockito** was used for mocking dependencies, allowing for isolated unit tests that focus on individual components of the system without needing real dependencies like databases or external services.
- To run the unit tests, use the following Maven command:

```bash
mvn test
```

The project includes 28 unit tests to ensure the functionality and reliability of the system.

## Contributing

If you would like to contribute to this project, please fork the repository and submit a pull request. We welcome all contributions that help improve the project.
