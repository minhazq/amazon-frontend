amazon-frontend
<p><h1>Demo Automation Framework:</h1></p>
<p>The Reuqirement :</p> 
1) Execute POM file with the following parameter:
  environment = qa01
  browser = firefox or chrome ( your choice)
  
  IF you do not sent any argument then default browser will be firefox and default environment will be qa01
2) You must have to be able to connect to my personal database. Frameowrk consist of user name and password hard coded. You might see firewall issue or connectivity issue. If you see this please run the following script :

<p>Create database amazon_userprofile_db ;</p>
<p>use amazon_userprofile_db;</p>
<p>create table accountprofile (
	id int(11) primary key auto_increment,
	user_name varchar(30),
	user_password varchar(30),
	user_fullname varchar(30),
	user_addressline_1 varchar(30),
	user_city varchar(10),
	user_state varchar(10),
	user_country varchar(30),
	user_phonenumber varchar(30)
);</p>	

<P>INSERT into accountprofile (user_name,user_password,user_fullname,user_addressline_1,
	user_city,user_state,user_country,user_phonenumber) values ("Min2","mypassword123","Minhajul quraishi","123 queens","Queens","NY",
			"USA","7184234565");</p>
<p> Now you are good to go</p>


