package model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CreateRemRowMapper implements RowMapper {

       // @Override
        public Object mapRow(ResultSet rs, int line) throws SQLException {
        	CreateRemResultExtractor extractor = new CreateRemResultExtractor();
                return extractor.extractData(rs);
        }

}