package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;


import spring.controllers.CreateRem;

public class CreateRemResultExtractor implements ResultSetExtractor {
	    public Object extractData(ResultSet rs) throws SQLException {
                CreateRem rem = new CreateRem();
        		rem.setOwner(rs.getString(1));
        		rem.setName(rs.getString(2));
        		rem.setCategory(rs.getString(3));
        		rem.setFrequency(rs.getString(4));
        		rem.setNotifMode(rs.getString(5));
        		rem.setStartTime(rs.getString(6));
        		rem.setEndTime(rs.getString(7));
        		rem.setRewardPoints(Integer.parseInt(rs.getString(8)));
        		rem.setisCompleted(Integer.parseInt(rs.getString(9)));
        		rem.setID(Integer.parseInt(rs.getString(10)));
        		rem.setTitle(rs.getString(11));
                return rem;
                
                
        }

}