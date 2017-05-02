package model;
import spring.controllers.*;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.JdbcTemplate;

public class removeUserDao {
	private DataSource dataSource;

    public void setDataSource(DataSource ds) {
            dataSource = ds;
    }
    
    public boolean checkuser(String username){
		boolean userExists = false;
		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
		int rowcount = jdbcTemplate.queryForInt("select count(*) from user " +
				" where username = ? ", username);
		if(rowcount == 1){
			userExists = true;
		}
		return userExists;       
    }
    
    public void suspend(String username){
    	int usersuspend = 1;
    	System.out.println("in suspend "+username);
		JdbcTemplate suspend= new JdbcTemplate(dataSource);
		usersuspend = suspend.queryForInt("select is_suspended from user where username= ?", username);
		if (usersuspend == 0) {
			suspend.update("UPDATE user SET is_suspended='1' WHERE username= ?", username);	
		}
    }
    
    public void revoke(String username){
    	int usersuspend = 0;
    	System.out.println("in revoke"+username);
		JdbcTemplate revoke= new JdbcTemplate(dataSource);
		usersuspend = revoke.queryForInt("select is_suspended from user where username= ?", username);
		if (usersuspend == 1) 
			 revoke.update("UPDATE user SET is_suspended='0' WHERE username= ?", username);			
    }
    
    public boolean delete(String username){
    	boolean userDeleted = false;
    	System.out.println("in delete"+username);
		JdbcTemplate select= new JdbcTemplate(dataSource);
		int rowcount = select.update("delete from user where username= ?", username);
		if (rowcount == 1) 
			userDeleted = true;
		return userDeleted;			
    }
    
    public List<CreateRem> userLogUser(String username){
    	CreateRem userExists = new CreateRem();
		JdbcTemplate select= new JdbcTemplate(dataSource);
		//return select.query("select owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,id,title from Reminder where owner='" + username + "'", new CreateRemRowMapper());		    
        return select.query("select owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,id,title from reminder where owner='"+username+"'", new CreateRemRowMapper());
    }
    
    
    public List<CreateRem> systemLogUser(){
		JdbcTemplate select= new JdbcTemplate(dataSource);
		//return select.query("select owner,name,category,frequency,notifmode,starttime,endtime,rewardpoints,iscompleted,id,title from Reminder where owner='" + username + "'", new CreateRemRowMapper());		    
        return select.query("select owner, sum(rewardpoints) from reminder where iscompleted='1' GROUP BY owner",
                new CreateSysMapper());
    }
}
