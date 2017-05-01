package model;
import spring.controllers.*;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
public class createRemDao  {
        private DataSource dataSource;

        public void setDataSource(DataSource ds) {
                dataSource = ds;
        }

        public void create(CreateRem obj) {
                JdbcTemplate insert = new JdbcTemplate(dataSource);
                insert.update("INSERT INTO Reminder (owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted) VALUES(?,?,?,?,?,?,?,?,false)",
                                new Object[] { obj.getOwner(), obj.getName(),obj.getCategory(),obj.getFrequency(),obj.getNotifMode(),obj.getStartTime(),obj.getEndTime(),obj.getRewardPoints() });
        }
        public List<CreateRem> selectAll(String username) {
            JdbcTemplate select = new JdbcTemplate(dataSource);
            return select.query("select name,category,frequency,starttime,endtime,id,notifmode from Reminder where owner='"+username+"' and iscompleted='0'",
                            new CreateRemRowMapper());
        }
        public List<CreateRem> select(String username, int reminderId){
        	CreateRem userExists = new CreateRem();
    		JdbcTemplate select= new JdbcTemplate(dataSource);
    		 return select.query("select name,category,frequency,starttime,endtime,id,notifmode from Reminder where owner='"+username+"' and id='"+reminderId+"' and iscompleted='0'",
                     new CreateRemRowMapper());
    		       
 }
            
}

/*
		   public List<Person> selectAll() {
    JdbcTemplate select = new JdbcTemplate(dataSource);
    return select.query("select FIRSTNAME, LASTNAME from PERSON",
                    new PersonRowMapper());
}

public void deleteAll() {
    JdbcTemplate delete = new JdbcTemplate(dataSource);
    delete.update("DELETE from PERSON");
}

public void delete(String firstName, String lastName) {
    JdbcTemplate delete = new JdbcTemplate(dataSource);
    delete.update("DELETE from PERSON where FIRSTNAME= ? AND LASTNAME = ?",
                    new Object[] { firstName, lastName });
}
*/
