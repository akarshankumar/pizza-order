This project takes unordered list of pizza orders from textfile (resources/sample_data_ordered (11).txt) and generates ordered list at mentioned location.

1) Run following command to clone the repository:
``git clone https://github.com/akarshankumar/pizza-order.git``

2) Run following command to install maven dependencies:
``mvn clean install``

3) Run following command to compile the project:
``mvn compile``

4) Run following command to create the package:
``mvn package``

5) Run following command to run the tests:
``mvn test``

6) Run following command to run the program:
``mvn exec:java -Dexec.args="<input file path> <output destination file path>``
  for e.g.: ``mvn exec:java -Dexec.args="/Users/ak/Downloads/sample_data_ordered (11).txt /Users/ak/Downloads/output.txt"``
  
Important Assumptions:
1) Input file remains same.
2) Right now there is no implementation required for DB and File upload feature. When they are required repository methods can me made accordingly.
3) User has proper permission to read and write files.
4) Repeated execution of program doesn't overwrite data in the output file, just appends to the existing data.

Design decisions:
1) This program has been written using SpringBoot which simplifies dependency injection.
2) Interaction with data sources have been incorporated in repository layer where we can add more adaptor methods to deal with different data sources.
3) The decision to use specific datasource is made based on the config parameters in application.properties. Which can be altered at runtime. A switch case has been introduced to invoke specific kind of repository method based on data source.