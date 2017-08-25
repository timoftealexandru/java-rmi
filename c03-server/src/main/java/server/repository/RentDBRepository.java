package server.repository;

import common.Client;
import common.Rent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import common.validators.RentalException;
import common.validators.Validator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import server.config.JdbcConfig;


import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import server.uti.RentalException;

/**
 * Created by nicu on 3/20/17.
 */
@Repository("rentDBRepository")
public class RentDBRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public RentDBRepository() {
public class RentDBRepository implements Repository<Long, Rent> {
    private Validator<Rent> validator;
   JdbcTemplate jdbcTemplate;

    public RentDBRepository(Validator<Rent> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();
    }

    public Optional<Rent> findOne(Long id) {
        String sql = "select * from rents where id=?";
        Rent r = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rent.class), id);
        return Optional.of(r);
    }

    public List<Rent> findAll() {
        try {
            String sql = "select * from rents";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rent.class));
        } catch (DataAccessException e) {
            throw new RentalException("Could not execute query to find rents ", e);
        }

    }
    public Optional<Rent> save(Rent r) {
        String sql = "insert into rents (clientcnp,movieid,nocopies) values (?,?,?)";
        jdbcTemplate.update(sql, r.getClientCnp(),r.getMovieId(),r.getNoCopies());
        return Optional.empty();
    }

    public Optional<Rent> update(Rent r ) {
        String sql = "update rents set clientcnp=?, nocopies=? where movieid=?";
        jdbcTemplate.update(sql, r.getClientCnp(),r.getNoCopies(),r.getMovieId());
        return Optional.empty();
    }

    public Optional<Rent> delete(int movieId) {
        String sql = "delete from rents where id=?";
        jdbcTemplate.update(sql, movieId);
        return Optional.empty();
    }
    }
    public List<Rent> findAll() {
        String sql = "select * from rents";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rent.class));
    }

    public Optional<Rent> save(Rent r) {
        String sql = "insert into rents (clientid,movieid,nocopies) values (?,?,?)";
        jdbcTemplate.update(sql, r.getClientId(),r.getMovieId(),r.getNoCopies());
        return Optional.empty();
    }

    public Optional<Rent> update(Rent r ) {
        String sql = "update rents set clientid=?, movieid=?, nocopies=? where id=?";
        jdbcTemplate.update(sql, r.getClientId(),r.getMovieId(),r.getNoCopies(),r.getId());
        return Optional.empty();
    }

    public Optional<Rent> delete(Long id) {
        String sql = "delete from rents where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }
    }
    public List<Rent> findAll() {
        String sql = "select * from rents";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Rent.class));
    }

    public Optional<Rent> save(Rent r) {
        String sql = "insert into rents (clientid,movieid,nocopies) values (?,?,?)";
        jdbcTemplate.update(sql, r.getClientId(),r.getMovieId(),r.getNoCopies());
        return Optional.empty();
    }

    public Optional<Rent> update(Rent r ) {
        String sql = "update rents set clientid=?, movieid=?, nocopies=? where id=?";
        jdbcTemplate.update(sql, r.getClientId(),r.getMovieId(),r.getNoCopies(),r.getId());
        return Optional.empty();
    }

    public Optional<Rent> delete(Long id) {
        String sql = "delete from rents where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }

    }

}
