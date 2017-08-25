package server.repository;

import common.Client;
import common.Movie;
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


public class MovieDBRepository implements Repository<Long, Movie> {
    private Validator<Movie> validator;
    JdbcTemplate jdbcTemplate;

    public MovieDBRepository(Validator<Movie> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        String sql = "select * from movies where id=?";
        Movie m = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
        return Optional.of(m);
    }

    public List<Movie> findAll() {
        try {
            String sql = "select * from movies";
            return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));

        } catch (DataAccessException e) {
            throw new RentalException("Could not execute query to find movies ", e);
        }
    }

    public Optional<Movie> save(Movie m) {
        try{
        String sql = "insert into movies (id,name,director,genre,availablecopies) values (?,?,?,?,?)";
        jdbcTemplate.update(sql,m.getId(), m.getName(), m.getDirector(),m.getGenre(),m.getAvailableCopies());
        return Optional.empty();

        } catch (DataAccessException e) {
            throw new RentalException("Could not execute query to add client ", e);
        }
    }

    public Optional<Movie> update(Movie m) {
        String sql = "update movies set name=?, director=?, genre = ?,availablecopies = ? where id=?";
        jdbcTemplate.update(sql, m.getName(),m.getDirector(),m.getGenre(),m.getAvailableCopies(),m.getId());
        return Optional.empty();
    }

    public Optional<Movie> delete(int id) {
        String sql = "delete from movies where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }
 public class MovieDBRepository implements Repository<Long, Movie> {
    private Validator<Movie> validator;
    JdbcTemplate jdbcTemplate;

    public MovieDBRepository(Validator<Movie> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();
    }

    @Override
    public Optional<Movie> findOne(Long id) {
        String sql = "select * from movies where id=?";
        Movie m = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
        return Optional.of(m);
    }
    public List<Movie> findAll() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Optional<Movie> save(Movie m) {
        String sql = "insert into movies (name,director,type,availablecopies) values (?,?,?,?)";
        jdbcTemplate.update(sql, m.getName(), m.getDirector(),m.getGenre(),m.getAvailableCopies());
        return Optional.empty();
    }

    public Optional<Movie> update(Movie m) {
        String sql = "update movies set name=?, director=?, type = ?,availablecopies = ? where id=?";
        jdbcTemplate.update(sql, m.getName(),m.getDirector(),m.getGenre(),m.getAvailableCopies(),m.getId());
        return Optional.empty();
    }

    public List<Movie> findAll() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Optional<Movie> save(Movie m) {
        String sql = "insert into movies (name,director,type,availablecopies) values (?,?,?,?)";
        jdbcTemplate.update(sql, m.getName(), m.getDirector(),m.getGenre(),m.getAvailableCopies());
        return Optional.empty();
    }

    public Optional<Movie> update(Movie m) {
        String sql = "update movies set name=?, director=?, type = ?,availablecopies = ? where id=?";
        jdbcTemplate.update(sql, m.getName(),m.getDirector(),m.getGenre(),m.getAvailableCopies(),m.getId());
        return Optional.empty();
    }

    public Optional<Movie> delete(Long id) {
        String sql = "delete from movies where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }

    public int countAll() {
        String sql = "select count(*) from movies";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
    public List<Movie> findAll() {
        String sql = "select * from movies";
        return jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Movie.class));
    }

    public Optional<Movie> save(Movie m) {
        String sql = "insert into movies (name,director,type,availablecopies) values (?,?,?,?)";
        jdbcTemplate.update(sql, m.getName(), m.getDirector(),m.getGenre(),m.getAvailableCopies());
        return Optional.empty();
    }

    public Optional<Movie> update(Movie m) {
        String sql = "update movies set name=?, director=?, type = ?,availablecopies = ? where id=?";
        jdbcTemplate.update(sql, m.getName(),m.getDirector(),m.getGenre(),m.getAvailableCopies(),m.getId());
        return Optional.empty();
    }

    public Optional<Movie> delete(Long id) {
        String sql = "delete from movies where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }

    public int countAll() {
        String sql = "select count(*) from movies";
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }
