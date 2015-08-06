khs-spring-batch-example
========================

Example Spring Batch Example jobs with admin console to launch and manage

This example implements the following two jobs that read/write flat files and an in memory
(HSQL) relational database.

Example Jobs (time sheet import,invoice,and PDF output)
-------------------------------------------------------

Job Configuration location
MET-INF/spring/batch/jobs/timesheet-job.xml
	
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
Project is in a Maven WAR format

To build it clone then use Maven:

    $ git clone ...
	$ cd khs-spring-batch-example
	
	Compile and build WAR
	$ mvn clean package
	
	or 
	
	Import into STS Eclipse and configure as a Maven Project
	
	
	Deploy war to app server, start and access with...
	http://localhost:8080/khs-spring-batch-example
