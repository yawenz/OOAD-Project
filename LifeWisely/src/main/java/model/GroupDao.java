package model;

import org.omg.PortableServer.ID_ASSIGNMENT_POLICY_ID;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.KeyHolder;
import java.sql.DriverManager;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.core.PreparedStatementCreator;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class GroupDao {
	private DataSource dataSource;
	
	public void setDataSource(DataSource ds) {
		dataSource = ds;
	}

	// return the auto-generated key(id)
	public int createGroup(final String groupName, final String groupDescription) {
    	final String sql="INSERT INTO groups (groupname, groupdescription) VALUE(?,?)";
    	KeyHolder keyHolder = new GeneratedKeyHolder();
    	JdbcTemplate jdbc=new JdbcTemplate(dataSource);
    	
    	jdbc.update(
    		 new PreparedStatementCreator(){   
                 public PreparedStatement createPreparedStatement(Connection conn) throws SQLException{   
                     int i = 0;   
                     java.sql.PreparedStatement ps = conn.prepareStatement(sql);    
                     ps = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);   
                     ps.setString(++i, groupName);   
                     ps.setString(++i,groupDescription);   
                     return ps;   
                 }  
    	 }, keyHolder);
    	return keyHolder.getKey().intValue();   
    }
	
	public void createUserGroup(int group_id, List<String> userNames){
		final String sql="INSERT INTO usergroup (group_id, user_name) VALUE(?,?)";
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		for(String username : userNames){
			jdbc.update(sql, new Object[] {group_id, username});
		}
	}
	
	public void bindGroupReminder(int group_id, int reminder_id){
		final String sql="UPDATE groups SET reminder_id="+Integer.toString(reminder_id)+" where id="+Integer.toString(group_id);
		System.out.println(sql);
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		jdbc.update(sql);
	}
	
	public List<UserGroup> selectAll(String username){
		final String sql="SELECT reminder.id, reminder.name, reminder.category, " + 
	                "reminder.frequency, reminder.starttime, reminder.endtime, " + 
				    "reminder.notifmode, groups.groupname, groups.groupdescription, groups.id "+
	                "FROM (( usergroup INNER JOIN groups ON usergroup.group_id = groups.id) " +
				    "INNER JOIN reminder ON groups.reminder_id = reminder.id)" + 
	                "WHERE usergroup.user_name=\""+username+"\"";
		System.out.println(sql);
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		return (jdbc.query(sql, new UserGroupRowMapper()));
		
	}
	
	public void userLeaveGroup(String username, int group_id){
		final String sql="DELETE FROM usergroup where user_name=? AND group_id=?";
		JdbcTemplate jdbc=new JdbcTemplate(dataSource);
		jdbc.update(sql, new Object[] {username, group_id});
	}
}
