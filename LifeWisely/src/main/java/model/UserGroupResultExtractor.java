package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import spring.controllers.CreateRem;

public class UserGroupResultExtractor  implements ResultSetExtractor {
	public Object extractData(ResultSet rs) throws SQLException {
		UserGroup group = new UserGroup();
		System.out.println("in extractor");
		System.out.println(rs.getInt(1));
		CreateRem rem=new CreateRem();
		rem.setID(rs.getInt(1));
		rem.setTitle(rs.getString(2));
		rem.setCategory(rs.getString(3));
		rem.setFrequency(rs.getString(4));
		rem.setStartTime(rs.getString(5));
		rem.setEndTime(rs.getString(6));
		rem.setNotifMode(rs.getString(7));
		group.setRem(rem);
/*		group.getRem().setID(rs.getInt(1));
		group.getRem().setTitle(rs.getString(2));
		group.getRem().setCategory(rs.getString(3));
		group.getRem().setFrequency(rs.getString(4));
		group.getRem().setStartTime(rs.getString(5));
		group.getRem().setEndTime(rs.getString(6));
		group.getRem().setNotifMode(rs.getString(7)); */
		group.setGroupName(rs.getString(8));
		group.setGroupDescription(rs.getString(9));
		group.setId(rs.getInt(10));
		return group;
	}
	

}
