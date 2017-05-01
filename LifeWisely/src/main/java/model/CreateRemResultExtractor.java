package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import model.User;
import spring.controllers.CreateRem;

public class CreateRemResultExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException {
                CreateRem rem = new CreateRem();
        		rem.setTitle(rs.getString(1));
        		rem.setCategory(rs.getString(2));
        		rem.setFrequency(rs.getString(3));
        		rem.setStartTime(rs.getString(4));
        		rem.setEndTime(rs.getString(5));
        		rem.setID(Integer.parseInt(rs.getString(6)));
        		rem.setNotifMode(rs.getString(7));
                return rem;
                
                
        }

}