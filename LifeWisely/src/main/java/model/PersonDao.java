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
                insert.update("INSERT INTO User (username, password) VALUES(?,?)",
                                new Object[] { firstName, lastName });
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
