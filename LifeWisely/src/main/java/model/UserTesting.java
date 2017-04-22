package model;
import java.util.List;

import org.springframework.jdbc.datasource.DriverManagerDataSource;


public final class UserTesting {
                public static void main(String[] args) {
                PersonDao dao = new PersonDao();
                // Initialize the datasource, could /should be done of Spring
                // configuration
                DriverManagerDataSource dataSource = new DriverManagerDataSource();
                dataSource.setDriverClassName("com.mysql.jdbc.Driver");
                dataSource.setUrl("jdbc:mysql://localhost/USER");
                dataSource.setUsername("root");
                dataSource.setPassword("root");
                // Inject the datasource into the dao
                dao.setDataSource(dataSource);

                dao.create("Lars", "Vogel");
                dao.create("Jim", "Knopf");
                dao.create("Lars", "Man");
                dao.create("Spider", "Man");
                System.out.println("Now select and list all persons");
        }
}