package sboot.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import sboot.dto.Person;

/**
 * An implementation of the PersonDAO interface.
 *
 *
 *
 */
@Service
public class PersonDAOImpl implements PersonDAO {

//    @Autowired
//    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public PersonDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void saveOrUpdate(Person person) {
        if (person.getId() > 0) {
            // update
            String sql = "UPDATE person SET, name=?, email=?, telephone=?, "
                    + "username=?,password=? WHERE username=?";
            jdbcTemplate.update(sql, person.getName(), person.getEmail(),
                    person.getTelephone(), person.getUsername(), person.getPassword(), person.getId());
        } else {
            // insert
            String sql = "INSERT INTO person (name, email, telephone, username,password)"
                    + " VALUES ( ?, ?, ?, ?, ?)";
            jdbcTemplate.update(sql, person.getName(), person.getEmail(),
                    person.getTelephone(), person.getUsername(), person.getPassword());
        }

    }

    @Override
    public void addUserRole(Person person,String role) {
        String sql="INSERT INTO user_roles (user_role_Id,username,ROLE)"
                +" VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, this.generateRandomUserRole_Id(0, 1000000000),person.getName(),
                    role);
    }

    
    public long generateRandomUserRole_Id(int min,int max){
        Random rnd=new Random();
         return (long)(rnd.nextDouble()*(max - min));
    }

    @Override
    public void delete(int personId) {
        String sql = "DELETE FROM person WHERE username=?";
        jdbcTemplate.update(sql, personId);
    }

    @Override
    public List<Person> list() {
        String sql = "SELECT * FROM person";
        List<Person> listPerson = jdbcTemplate.query(sql, new RowMapper<Person>() {

            @Override
            public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
                Person aPerson = new Person();

//                aPerson.setId(rs.getInt("id"));
                aPerson.setName(rs.getString("name"));
                aPerson.setEmail(rs.getString("email"));
                aPerson.setTelephone(rs.getString("telephone"));
                aPerson.setUsername(rs.getString("username"));
                aPerson.setPassword(rs.getString("password"));

                return aPerson;
            }

        });

        return listPerson;
    }

    @Override
    public Person get(int personId) {
        String sql = "SELECT * FROM person WHERE username=" + personId;
        return jdbcTemplate.query(sql, new ResultSetExtractor<Person>() {

            @Override
            public Person extractData(ResultSet rs) throws SQLException,
                    DataAccessException {
                if (rs.next()) {
                    Person person = new Person();
                    person.setId(rs.getInt("username"));
                    person.setName(rs.getString("name"));
                    person.setEmail(rs.getString("email"));
                    person.setTelephone(rs.getString("telephone"));
                    person.setUsername(rs.getString("username"));
                    person.setPassword(rs.getString("password"));
                    return person;
                }

                return null;
            }

        });
    }

//    public DataSource getDataSource() {
//        return dataSource;
//    }
//
//    public void setDataSource(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

}
