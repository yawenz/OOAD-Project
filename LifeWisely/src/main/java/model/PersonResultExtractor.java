package model;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.ResultSetExtractor;

import model.User;

public class PersonResultExtractor implements ResultSetExtractor {

        public Object extractData(ResultSet rs) throws SQLException {
                User person = new User();
                person.setUsername(rs.getString(1));
                person.setPassword(rs.getString(2));
                return person;
        }

}