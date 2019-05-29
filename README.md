# celebrities-repository
It is the repository to store all development for finding celebrities from a data provided in database.

# Assumptions
1. We have the entire information entered into the DB. For each person in the DB we know the other people he/she knows.
2. For finding the celebrity, we only have one person that is a celebrity.
3. For use the algorithm, we need MINIMUM 2 people into the DB.

# Getting Started
1. Download the celebrities-1.0.0-RELEASE.jar that you can find attached here and putting it in your preferred folder location.
2. Open a terminal (Git Bash) in the same folder location and writing: java -jar celebrities-1.0.0-RELEASE.jar
3. If you want to execute the algorithm, you can copy the following link in a internet browser. ==> http://localhost:8080/celebrity

# Changing H2 Data
You can add, remove or change data into the H2 embbeded DB with these informations:

1. If you want to access to the embedded DB,  you can copy the following link in a internet browser. ==>  http://localhost:8080/console/login.jsp
2. The information to access to the DB is:
    - JDBC URL: jdbc:h2:mem:example-app;DB_CLOSE_DELAY=-1;DB_CLOSE_ON_EXIT=FALSE
    - User Name: celebritiesDBUser
    -  Password: celebritiesDBPwd
    -  Driver Class: org.h2.Driver

# Tables
1. There are two tables, the first one PEOPLE with: ID, FIRST_NAME and LAST_NAME and the second one PERSON_KNOWN_PEOPLE with PERSON_ID and KNOWN_PEOPLE.
2. In the first table we have the people information and in the second one we have the relation "He/she knows him/her"
