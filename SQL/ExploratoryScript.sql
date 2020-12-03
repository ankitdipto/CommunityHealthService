create database CHM_System;
create user ankitdipto identified by 'ankitdipto';
grant all on CHM_System.* to ankitdipto;
use CHM_System;
show tables;
select * from dummy;
#drop table dummy;
create database hospital;
grant all on hospital.* to  ankitdipto;
use hospital;
show tables;
use CHM_System;
show tables;
drop table public_records;
drop table isolation_centre_details;
select * from public_records;
select * from covid19_active;
select * from zone;
select * from isolation_centre_details;
insert into public_records
values (12346,22,"O+",91782,"Fine and well","Rahul Srivastava",3,"Hardware Engineer");

insert into public_records
values (43219,23,"O-",890341,"Fine and well","Koushik Chakravarty",3,"Software Engineer");

select count(*) from public_records;
describe public_records;
drop table zone;
show tables;
drop table public_records;
show tables;
describe public_records;
select * from public_records;
use CHM_System;
select * from isolation_centre_details;
describe isolation_centre_details;
describe zone;
select * from public_records;
set @dt=now();
select @dt;
select date(@dt);
select time(@dt);
drop table zone;
describe zone;
select * from zone;
insert into zone
values (141,"Sovan Chatterjee",80,2000,50,now());
drop table isolation_centre_details;
drop table zone;
select * from isolation_centre_details;
select * from zone;
insert into zone
values (144,"Partha Chatterjee",100,3000,60,now());
describe isolation_centre_details;
insert into isolation_centre_details
values (5691,100,"...","...",30,700021,500,"...",350,141);
insert into isolation_centre_details
values (7846,90,"...","...",15,700034,600,"...",300,144);
delete from zone
where ward_no=144;
describe zone;
describe covid19_active;
select * from public_records;
drop table covid19_active;
insert into covid19_active
values (1,false,null,null,12346);
select * from covid19_active;

insert into covid19_active
values (2,false,"asthma",null,43219);
select * from covid19_active;

delete from public_records
where aadhar_no=2411239;

select * from public_records;
select * from covid19_active;

delete from public_records
where aadhar_no=43219;

#delete from covid19_active
#where aadhar_no=2411239;
use CHM_System;
show tables;
select * from medical_help_records;
select * from requirements;
select * from covid19_active;
select * from covid19_recovered;
select * from dengue_active;
select * from hospital_information;
select * from isolation_centre_details;
#alter table isolation_centre_details drop location;
select * from public_records;
#alter table public_records drop no_of_family_members,drop work_information;
select * from zone;
select * from ambulance_details;
#alter table ambulance_details drop equipments_available,drop parking_location;
select * from club_member_records;
select * from doctors;
#alter table doctors drop chamber_location,drop chamber_pincode,drop chamber_stree;
select * from hibernate_sequence;
select * from dummy;
select * from users;

insert into zone
values (126,"Dilip Ghosh",67,2877,40,date(now())),
       (571,"Rahul Sinha",198,4451,55,date(now())),
       (87,"Shuvendu Adhikari",88,3120,60,date(now())),
       (265,"Anubrata Mondal",145,1822,35,date(now())),
       (314,"Bobi Hakim",816,7362,68,date(now()));
       
select * from zone
order by number_of_covid19_cases desc; 

#alter table covid19_active drop breathing_porblem;
select * from public_records;

insert into public_records
values (200,30,"A-",728192730,"fine","Raghav Singh",5,"Software Engineer"),
	   (201,32,"A+",837932730,"ill","Keshav Chandra Sen",4,"Hardware Engineer"),
	   (202,43,"B+",324281929,"fine","Rahul Das",3,"Chartered Accountant"),
       (203,28,"O-",578272768,"fine","Manoj Bhattacharya",4,"Businessman"),
       (204,51,"O-",564722188,"ill","Prasenjit Sarkar",3,"Actor");
      
describe public_records;
describe covid19_active;
select * from public_records;
insert into covid19_active
values (1,"asthma","high fever",201,true),
	   (2,"hyper-tension","high fever and weakness",204,false);
	
select * from covid19_active;
insert into public_records
values (207,47,"A+",648271983,"ill","Koushik Banerjee",6,"singer");

insert into covid19_active
values (3,"High Cholestrol","fever and cough",207,true);

select * from covid19_active;
delete from public_records 
where aadhar_no=204;

select * from isolation_centre_details;
select * from zone;
delete from zone 
where ward_no=144;

show create table isolation_centre_details;
alter table isolation_centre_details
drop foreign key `FK1jeyav4y8a7my1an1n7rlkq0h`;

select * from isolation_centre_details;
alter table isolation_centre_details
add foreign key (locality) references zone(ward_no) on delete cascade on update cascade;

show create table isolation_centre_details;
select * from zone;

delete from zone
where ward_no=144;

select * from isolation_centre_details;
set @a=90;
select @a as nomenclature;
set @a=@a+73;
select @a as A;

select * from covid19_recovered;
select * from public_records;

drop trigger if exists recovery_from_covid19;
delimiter //
create trigger recovery_from_covid19 after delete on covid19_active
for each row 
	begin
			set @aadhar_card_no = OLD.aadhar_id;
			set @uname = (select name from public_records where aadhar_no = @aadhar_card_no);
            #set @age = (select age from public_records where aadhar_no = @aadhar_card_no);
            set @blood_group = (select blood_group from public_records where aadhar_no = @aadhar_card_no);
            insert into covid19_recovered
            values (@aadhar_card_no,@blood_group,1,@uname);
            #delete from covid19_active where aadhar_id=@aadhar_card_no;
	end//
delimiter ;

delete from covid19_active where aadhar_id = 20000000;

select * from public_records;
select * from covid19_active;
update covid19_active set infection_status=0 where aadhar_id = 204;

#delete from covid19_active where aadhar_id=204;

delete from covid19_recovered where aadhar_id = 30000000;
insert into covid19_active values (30000000,18,0,1);


insert into covid19_active
values (8273283,25,0,1),
		(10000000,21,0,1),
        (20000000,30,0,1),
        (30000000,18,0,1),
        (40000000,40,0,1),
		(40000005,56,0,1);
        
select * from covid19_active;
select * from covid19_recovered;


#delete from covid19_recovered where aadhar_id = 204;
select * from isolation_centre_details;
describe isolation_centre_details;
update isolation_centre_details
set address = "Howrah",location = "Kolkata", street = "Grand Trunk Road"
where centre_code = 5691;

select * from isolation_centre_details;
select * from zone;
use CHM_System;
select * from ambulance_details;
select * from medical_help_records;
describe medical_help_records;
insert into medical_help_records
values (5000,"100 Banomali Naskar Road",true,"Ankit Sinha","ambulance driver",true);

insert into ambulance_details
values (1,"Oxygen Cylinder ,Blood Supply","Kamalesh Das","Banerjee para",5000);

insert into ambulance_details
values (2,"Oxygen Cylinder ,Heart Rate Monitor","Prajjwal Dey","Harish Chatterjee Lane",5001);

use CHM_system;
show tables;
#drop table ambulance_details,requirements,isolation_centre_details;
#drop table covid19_active,covid19_recovered,doctors,dengue_active,dummy;
#drop table club_member_records,hibernate_sequence,medical_help_records;
#drop table hospital_information,public_records,zone;
select * from zone;
delete from zone where ward_no=0;

insert into zone
values (142,"Rahul Sinha",98,1000,126,now()),
	   (160,"Partho Mukherjee",170,1300,200,now()),
       (138,"Shuvendu Adhikari",156,800,198,now()),
       (166,"Kaustav De",237,1893,371,now()),
       (182,"Firhad Hakim",117,1473,245,now());
       
select * from zone;
SELECT * FROM zone ORDER BY no_of_covid19cases DESC;
insert into users(email,enabled,locked,username,password,user_role)
values ("abc@gmail.com",1,0,"user","password",1);

select * from users;
#update users set password = "$2y$04$GOH7Yh1/NeMT6jiRIuuDRek6YEJsuIAuW01cZoiEVtAp0hozEIR8u" where id = 2;  
#delete from users where id =1 ;
describe users;
select * from users;
select * from zone;
select * from ambulance_details;

select * from medical_help_records;
insert into ambulance_details
values (1005,"Heart monitor","Paresh Saha","Khidderpore",3);

insert into medical_help_records
values(3,"Taratala",0,"Parnasree","Ambulance Driver");
select * from covid19_active;
#drop table covid19_active;
select * from covid19_recovered;
#drop table covid19_recovered;

select * from dengue_active;
select * from doctors;

describe doctors;
select * from public_records;

show tables;
alter table hospital_information drop street,drop pincode;
select * from hospital_information;
alter table hospital_information drop location;

set @tym = date(now());
select @tym  olddate,date_add(@tym,interval 8 DAY)  newdate;
select * from hospital_information;

show tables;
select * from infection_data;
alter table infection_data drop n,drop counts; 

use CHM_system;
select * from infection_data;

SET GLOBAL log_bin_trust_function_creators = 1;

drop procedure if exists RegisterInfectionData;
 
 delimiter //
 create procedure RegisterInfectionData() 
 	BEGIN
		declare previousValue int ;
		set @dt = date(now());
		set previousValue = (select  no_of_cases 
			from infection_data
			where date = @dt);
        
	if previousValue is not null then 
		set previousValue = previousValue+1;
        update infection_data 
		set no_of_cases = previousValue
        where date=@dt;
	else
		set previousValue = 1;
		insert into infection_data(date,no_of_cases)
        values(@dt,1);
	
    select preiousValue;
	end if;
    
    END//

delimiter ;

select * from covid19_active;

select * from public_records;

insert into public_records
values(40000000,40,"O+",5327432,"Prajjwal Rai","business man",null),
	  (40000005,56,"C-",871262310,"Shashank Aggrawal","Professor",null);

select * from infection_data;
insert into infection_data
values(1,date(now()),2);

select count(*) from infection_data;
update infection_data
set no_of_cases = 1
where day=1;

select * from infection_data;
call RegisterInfectionData();
 
select * from public_records;
select * from covid19_active;

set @dt=date(now());
insert into infection_data
values (2,date_add(@dt,INTERVAL 1 DAY),15),
	    (3,date_add(@dt,INTERVAL 2 DAY),30),
        (4,date_add(@dt,INTERVAL 3 DAY),50),
        (5,date_add(@dt,INTERVAL 4 DAY),90),
        (6,date_add(@dt,INTERVAL 5 DAY),130),
        (7,date_add(@dt,INTERVAL 6 DAY),196),
        (8,date_add(@dt,INTERVAL 7 DAY),280),
        (9,date_add(@dt,INTERVAL 8 DAY),392);
        
select * from infection_data;


        