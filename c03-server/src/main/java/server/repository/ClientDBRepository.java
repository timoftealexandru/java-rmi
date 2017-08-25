package server.repository;

import common.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Repository;
import server.uti.RentalException;
import server.config.JdbcConfig;
import server.config.JdbcConfig;
import server.config.JdbcConfig;

import java.util.List;
import java.util.Optional;


@Repository("clientDBRepository")
public class ClientDBRepository {

    @Autowired
    JdbcTemplate jdbcTemplate ;


    public ClientDBRepository() {
public class ClientDBRepository implements Repository<Long, Client> {
    private Validator<Client> validator;
    @Autowired
    JdbcTemplate jdbcTemplate ;

    public ClientDBRepository(Validator<Client> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();

    }


    public Optional<Client> findOne(int cnp) {
        try{
            String sql = "select * from clients where cnp=?";
            Client c = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Client.class), cnp);
            return Optional.of(c);
        } catch (DataAccessException e) {
            throw new RentalException("Could not execute query to find clients ", e);
        }

    }

    public List<Client> findAll() {
        try {
            String sql = "select * from clients";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));

        } catch (DataAccessException e) {
            throw new RentalException("Could not execute query to find clients ", e);
        }
    }

    public Optional<Client> save(Client c) {
        String sql = "insert into clients (name,cnp) values (?,?)";
        jdbcTemplate.update(sql, c.getName(), c.getCnp());
        return Optional.empty();
    }

    public Optional<Client> update(Client c) {
        String sql = "update clients set name=? where cnp=?";
        jdbcTemplate.update(sql, c.getName(), c.getCnp());
        return Optional.empty();
    }


    public Optional<Client> delete(int cnp) {
        String sql = "delete from clients where cnp=?";
        jdbcTemplate.update(sql, cnp);
        return Optional.empty();

        String sql = "select * from clients";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Client.class));
    }

    public Optional<Client> save(Client c) {
        String sql = "insert into clients (name,age) values (?,?)";
        jdbcTemplate.update(sql, c.getName(), c.getAge());
        return Optional.empty();
    }

    public Optional<Client> update(Client c) {
        String sql = "update clients set name=?, age=? where id=?";
        jdbcTemplate.update(sql, c.getName(), c.getAge(),c.getId());
        return Optional.empty();
    }

    public Optional<Client> delete(Long id) {
        String sql = "delete from clients where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }

    public int countAll() {
        String sql = "select count(*) from clients";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
}
