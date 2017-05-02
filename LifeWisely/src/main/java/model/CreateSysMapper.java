package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CreateSysMapper implements RowMapper {

       // @Override
        public Object mapRow(ResultSet rs, int line) throws SQLException {
        	CreateSysResultExtractor extractor = new CreateSysResultExtractor();
                return extractor.extractData(rs);
        }

}