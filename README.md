# flight.radar

Fetch the project and open terminal/command prompt in order to run this project
For depolying please use ths command: mvn spring-boot:run -Dapp.profiles=test
For running test case please use ths command: mvn test

PreRequists:
  Apache Maven
    https://maven.apache.org/download.cgi
  Minimum Java 16
    https://www.oracle.com/java/technologies/javase/jdk16-archive-downloads.html

  Dependencies used in project would be auto downloaded upro running the deploy command.
  IDE used is Eclipse, IntelliJ would work just as fine.

Basic Implementation for Sync Countries, Flight Info data from api to db.
Retrieving data from db using JDBC connection from mysql server.
Created three api as follows:

  Fetch all flight info records
  http://localhost:8090/getFlightInfo
  
  Fetch flight info records based on country name or country code filter
  http://localhost:8090/getFlightInfo/country/india
  
  Fetch flight info records based on arrival airport icta code
  http://localhost:8090/getFlightInfo/ArrivalAirport/cyul
