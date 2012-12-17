khs-spring-batch-example
========================

Example Spring Batch Example jobs with admin console

This example implements the following two jobs that read and write from flat files and an in memory
(HSQL) relational database.

Example Jobs 
------------

Time sheet invoicing Job Steps:
	
	Step 1
	
	Read time sheet flat file using spring batch supplied FlatFileItemReader
	Write to Time sheet database using Time sheet DAO

	Step 2
	
	Read time sheet records using JPAPagingItemReader
	Process to InvoiceItem object
	Write InvoieItem object to table using DAO

	Step 3
	Read Time sheets 
	Process and format PDF report
	Write PDF output report
	

Getting Started
---------------
To build it clone then use Maven:

    $ git clone ...
	$ cd khs-spring-batch-example
	
	Compile and build WAR
	$ mvn clean package
	
	Deploy war to app server, start and access with...
	http://localhost:8080/khs-spring-batch-example
