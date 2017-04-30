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
                insert.update("INSERT INTO Reminder (owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,title) VALUES(?,?,?,?,?,?,?,?,false,?)",
                                new Object[] { obj.getOwner(), obj.getName(),obj.getCategory(),obj.getFrequency(),obj.getNotifMode(),obj.getStartTime(),obj.getEndTime(),obj.getRewardPoints(),obj.getTitle() });
        }
        public void update(CreateRem obj) {
            JdbcTemplate insert = new JdbcTemplate(dataSource);
            insert.update("UPDATE Reminder set frequency = ? ,notifmode = ?,starttime = ?,endtime =?,rewardpoints=?,iscompleted=? WHERE id = ?",
                            new Object[] { obj.getFrequency(),obj.getNotifMode(),obj.getStartTime(),obj.getEndTime(),obj.getRewardPoints(),obj.getisCompleted(),obj.getID() });
    }
        public List<CreateRem> selectAll(String username) {
            JdbcTemplate select = new JdbcTemplate(dataSource);
            return select.query("select owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,id,title from Reminder where owner='"+username+"' and iscompleted='0'",
                            new CreateRemRowMapper());
        }
        public List<CreateRem> select(String username, int reminderId){
        	CreateRem userExists = new CreateRem();
    		JdbcTemplate select= new JdbcTemplate(dataSource);
    		 return select.query("select owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,id,title from Reminder where owner='"+username+"' and id='"+reminderId+"' and iscompleted='0'",
                     new CreateRemRowMapper());
    		       
 }
        public void delete(String username, int reminderId){
        	JdbcTemplate select= new JdbcTemplate(dataSource);
    		 select.update("DELETE from Reminder where owner='"+username+"' and id='"+reminderId+"'");
    		       
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
