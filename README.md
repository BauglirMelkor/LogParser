# LogParser
A Spring Boot application that parses and inserts logs to a in memory database which is exchangeble with a MYSQL database
SQL queries were written by using Spring Data 
There are two entities which correspond to two databases names as IpTable and ForbiddenIpTable
If logged requests exceed the threshold spesified Ips will be inserted to ForbiddenIpTable
You can run unit tests which were written to ensure the following criterias below;


(1) java -cp "parser.jar" com.ef.Parser --startDate=2017-01-01.15:00:00 --duration=hourly --threshold=200

The output will have 192.168.11.231. If you open the log file, 192.168.11.231 has 200 or more requests between 2017-01-01.15:00:00 and 2017-01-01.15:59:59

(2) java -cp "parser.jar" com.ef.Parser --startDate=2017-01-01.00:00:00 --duration=daily --threshold=500

The output will have  192.168.102.136. If you open the log file, 192.168.102.136 has 500 or more requests between 2017-01-01.00:00:00 and 2017-01-01.23:59:59

