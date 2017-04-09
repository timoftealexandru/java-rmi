package server.repository;

import common.Client;
import common.Movie;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
=======
import common.validators.RentalException;
import common.validators.Validator;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import server.config.JdbcConfig;
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import server.uti.RentalException;

/**
 * Created by victo on 3/19/2017.
 */
<<<<<<< HEAD
<<<<<<< HEAD

@Repository("movieDBRepository")
public class MovieDBRepository  {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public MovieDBRepository() {
    }


    public Optional<Movie> findOne(int id) {
=======
public class MovieDBRepository implements Repository<Long, Movie> {
    private Validator<Movie> validator;
    JdbcTemplate jdbcTemplate;

    public MovieDBRepository(Validator<Movie> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();
    }

    @Override
    public Optional<Movie> findOne(Long id) {
<<<<<<< HEAD
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
        String sql = "select * from movies where id=?";
        Movie m = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Movie.class), id);
        return Optional.of(m);
    }
<<<<<<< HEAD
<<<<<<< HEAD

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
=======
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

=======
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

>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
    public Optional<Movie> delete(Long id) {
        String sql = "delete from movies where id=?";
        jdbcTemplate.update(sql, id);
        return Optional.empty();
    }

    public int countAll() {
        String sql = "select count(*) from movies";
        return jdbcTemplate.queryForObject(sql, Integer.class);
<<<<<<< HEAD
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
    }

=======
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

>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
}
//    @Override
//    public Optional<Movie> findOne(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null");
//        try(Connection connection = DriverManager.getConnection(url, username, password);
//            PreparedStatement statement = connection.prepareStatement("select * from movies where id=?")) {
//            statement.setLong(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if(resultSet.next()) {
//                    Long movieId = resultSet.getLong("id");
//                    String name = resultSet.getString("name");
//                    String director = resultSet.getString("director");
//                    String genre = resultSet.getString("genre");
//                    int availableCopies = resultSet.getInt("availableCopies");
//
//                    Movie movie = new Movie(name, director, genre, availableCopies);
//                    movie.setId(movieId);
//                    return Optional.of(movie);
//                }
//            }
//
//        } catch(SQLException e) {
//            throw new RentalException(e);
//        }
//
//        return Optional.empty();
//    }
//
//    @Override
//    public Iterable<Movie> findAll() {
//        List<Movie> movies = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("select * from movies")) {
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while(resultSet.next()) {
//                    Long movieId = resultSet.getLong("id");
//                    String name = resultSet.getString("name");
//                    String director = resultSet.getString("director");
//                    String genre = resultSet.getString("genre");
//                    int availableCopies = resultSet.getInt("availableCopies");
//
//                    Movie movie = new Movie(name, director, genre, availableCopies);
//                    movie.setId(movieId);
//
//                    movies.add(movie);
//                }
//            }
//        } catch (SQLException e) {
//            throw new RentalException(e);
//        }
//
//        return movies;
//    }
//
//    @Override
//    public Optional<Movie> save(Movie entity) {
//        if(entity == null)
//            throw new IllegalArgumentException("entity must not be null");
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "insert into movies (name, director, genre, availableCopies) values (?,?,?,?)")) {
//            statement.setString(1, entity.getName());
//            statement.setString(2, entity.getDirector());
//            statement.setString(3, entity.getGenre());
//            statement.setInt(4, entity.getAvailableCopies());
//
//            statement.executeUpdate();
//
//            return Optional.empty();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Optional.of(entity);
//        }
//    }
//
//    @Override
//    public Optional<Movie> delete(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null.");
//        Optional<Movie> client = findOne(id);
//        if(!client.isPresent()) {
//            return Optional.empty();
//        }
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("delete from movies where id=?")) {
//            statement.setLong(1, id);
//
//            statement.executeUpdate();
//
//            return client;
//        } catch(SQLException e) {
//            throw new RentalException("DB movie error: ", e);
//        }
//    }
//
//    @Override
//    public Optional<Movie> update(Movie entity) {
//        if (entity == null) {
//            throw new IllegalArgumentException("entity must not be null");
//        }
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "update movies set (name=?,director=?, genre=?, availableCopies=?) WHERE id=?")) {
//            statement.setString(1, entity.getName());
//            statement.setString(2, entity.getDirector());
//            statement.setString(3, entity.getGenre());
//            statement.setInt(4, entity.getAvailableCopies());
//            statement.setLong(5, entity.getId());
//
//            statement.executeUpdate();
//
//            return Optional.empty();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Optional.of(entity);
//        }
//    }