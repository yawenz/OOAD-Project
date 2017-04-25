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
                insert.update("INSERT INTO Reminder (owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints) VALUES(?,?,?,?,?,?,?,?)",
                                new Object[] { obj.getOwner(), obj.getName(),obj.getCategory(),obj.getFrequency(),obj.getNotifMode(),obj.getStartTime(),obj.getEndTime(),obj.getRewardPoints() });
        }
        public boolean checkuser(String username, String password){
    		boolean userExists = false;
    		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
    		int rowcount = jdbcTemplate.queryForInt("select count(*) from User " +
    				" where username = ? and password = ?",
    				username,password);
    		if(rowcount==1){
    			userExists = true;
    		}
    		return userExists;       
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
