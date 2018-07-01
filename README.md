# Kata Bank Account

Spring boot Application with H2 embedded database
compile & install : mvn clean install

---------------------------------------------------------------
GET : RETURN ACCOUNT
http://localhost:8080/bankAccount/{ID}
---------------------------------------------------------------
POST : ADD NEW RECORD WITH TYPE (WITHDRAWAL or DEPOSIT)
http://localhost:8080/bankAccount/{ID}

BODY : {
		"amount":1000,
		"type":"WITHDRAWAL"
	   }
---------------------------------------------------------------
GET : RETURN ALL RECORDS FOR TH CURRENT ACCOUNT
http://localhost:8080/bankAccount/{ID}/records