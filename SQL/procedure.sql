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