package model;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.JdbcTemplate;
public class PersonDao  {
        private DataSource dataSource;

        public void setDataSource(DataSource ds) {
                dataSource = ds;
        }

        public void create(String firstName, String lastName) {
                JdbcTemplate insert = new JdbcTemplate(dataSource);
                insert.update("INSERT INTO user (username, password) VALUES(?,?)",
                                new Object[] { firstName, lastName });
        }
        public boolean checkuser(String username, String password){
    		boolean userExists = false;
    		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
    		int rowcount = jdbcTemplate.queryForInt("select count(*) from user " +
    				" where username = ? and password = ? and is_suspended = '0'",
    				username,password);
    		if(rowcount==1){
    			userExists = true;
    		}
    		return userExists;      
        }
        
        public boolean check_userexist(String username){
        	boolean userExists = false;
    		JdbcTemplate jdbcTemplate= new JdbcTemplate(dataSource);
    		int rowcount = jdbcTemplate.queryForInt("select count(*) from User " +
    				" where username = ? and is_suspended = '0'",
    				username);
    		if(rowcount==1){
    			userExists = true;
    		}
    		return userExists;
        }
            
}
