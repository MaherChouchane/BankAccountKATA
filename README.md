# Kata Bank Account

Spring boot Application with H2 embedded database.

Compile & install : mvn clean install

Run : mvn spring-boot:run

H2
--------------------------------------------------------------
http://localhost:8080/h2/

GET : RETURN ACCOUNT
---------------------------------------------------------------
http://localhost:8080/bankAccount/{ID_ACCOUNT}

POST : ADD NEW RECORD WITH TYPE (WITHDRAWAL or DEPOSIT)
---------------------------------------------------------------
http://localhost:8080/bankAccount/{ID_ACCOUNT}/record/add
BODY : {"amount":1000, "type":"WITHDRAWAL"}
	
GET : RETURN ALL RECORDS FOR TH CURRENT ACCOUNT
---------------------------------------------------------------
http://localhost:8080/bankAccount/{ID}/records
