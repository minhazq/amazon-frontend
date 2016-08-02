# amazon-frontend
Demo Automation Framework:

The Reuqirement : 
1) Execute POM file with the following parameter:
  environment = qa01
  browser = firefox or chrome ( your choice)
  
  ** IF you do not sent any argument then default browser will be firefox and default environment will be qa01
  
2) You must have to be able to connect to my personal database. Frameowrk consist of user name and password hard coded. You might see firewall issue 
or connectivity issue. If you see this please create a simple MySql database and table as follows:
1) Create amazon_userprofile_db database
2) create table accountprofile using the following entry:
id	int(11)	NO	PRI		auto_increment
user_name	varchar(30)	NO			
user_password	varchar(30)	NO			
user_fullname	varchar(30)	YES			
user_addressline_1	varchar(30)	YES			
user_city	varchar(10)	YES			
user_state	varchar(10)	YES			
user_country	varchar(30)	YES			
user_phonenumber	varchar(30)	YES	

And add at least one entry.
