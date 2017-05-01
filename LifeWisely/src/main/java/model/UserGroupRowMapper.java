package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class UserGroupRowMapper implements RowMapper {
	
	public Object mapRow(ResultSet rs, int line) throws SQLException {
    	UserGroupResultExtractor extractor = new UserGroupResultExtractor();
            return extractor.extractData(rs);
    }
}
