# celebrities-repository
It is the repository to store all development for finding celebrities from a data provided in database.

# Assumptions
1. We have the entire information entered into the DB, knowing if each person is a celebrity or not with a flag.
2. For finding the celebrity we only have one person that is a celebrity.

# Getting Started
1. Import proyect as a maven project in your workspace.
2. Click-right on celebrites, then Run as > Spring Boot Application
3. The project has a H2 DB that can be acceded from "localhost:8080/console" with the following information:
    JDBC URL: jdbc:h2:mem:example-app;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    User Name: celebritiesDBUser
    Password: celebritiesDBPwd
    Driver Class: org.h2.Driver
4. For knowing if there is a celebrity into the team, you can access from an internet browser to the web service "localhost:8080/celebrity"

# Changing H2 Data
You can add, remove or change data into the file import.sql and when you save the changes, the SpringBoot Project will restart autmatically and you can test with the new information for knowing if everything is working fine.
