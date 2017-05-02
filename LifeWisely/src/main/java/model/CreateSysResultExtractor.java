package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import spring.controllers.CreateRem;


public class CreateSysResultExtractor implements ResultSetExtractor {
    public Object extractData(ResultSet rs) throws SQLException {
        CreateRem rem = new CreateRem();
		rem.setOwner(rs.getString(1));
		rem.setSumRewards(Integer.parseInt(rs.getString(2)));
        return rem;   
    }
}

