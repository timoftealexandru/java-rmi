package server.repository;

import common.Client;
import common.Rent;
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
 * Created by nicu on 3/20/17.
 */
@Repository("rentDBRepository")
public class RentDBRepository {

<<<<<<< HEAD
    @Autowired
    JdbcTemplate jdbcTemplate;

    public RentDBRepository() {
=======
public class RentDBRepository implements Repository<Long, Rent> {
    private Validator<Rent> validator;
   JdbcTemplate jdbcTemplate;

    public RentDBRepository(Validator<Rent> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
    }

    public Optional<Rent> findOne(Long id) {
        String sql = "select * from rents where id=?";
        Rent r = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Rent.class), id);
        return Optional.of(r);
<<<<<<< HEAD
<<<<<<< HEAD
    }
<<<<<<< HEAD

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

=======
=======
    }
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
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
<<<<<<< HEAD
    }

>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
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

>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    }

>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
//    public int countAll() {
//        String sql = "select count(*) from rents";
//        return jdbcTemplate.queryForObject(sql, Integer.class);
//    }
}

//    @Override
//    public Optional<Rent> findOne(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null");
//        try(Connection connection = DriverManager.getConnection(url, username, password);
//            PreparedStatement statement = connection.prepareStatement("select * from rents where id=?")) {
//            statement.setLong(1,id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if(resultSet.next()) {
//                    Long rentid = resultSet.getLong("id");
//                    Long movieId = resultSet.getLong("movieid");
//                    Long clientId = resultSet.getLong("clientid");
//                    int noCopies = resultSet.getInt("nocopies");
//                    LocalDateTime rentalData = resultSet.getDate("rentaldate").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//                    LocalDateTime returnData = resultSet.getDate("returnData").toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
//
//                    Rent rent = new Rent(clientId,movieId,noCopies,rentalData,returnData);
//                    rent.setId(rentid);
//                    return Optional.of(rent);
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
//    public Iterable<Rent> findAll() {
//        List<Rent> rents = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("select * from rents")) {
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while(resultSet.next()) {
//                    Long rentId = resultSet.getLong("id");
//                    Long clientId = resultSet.getLong("clientid");
//                    Long movieId = resultSet.getLong("movieid");
//                    int noCopies = resultSet.getInt("nocopies");
//
//                    Rent rent = new Rent(clientId,movieId,noCopies);
//                    rent.setId(rentId);
//                    rents.add(rent);
//                }
//            }
//        } catch (SQLException e) {
//            throw new RentalException(e);
//        }
//
//        return rents;
//    }
//
//    @Override
//    public Optional<Rent> save(Rent entity) {
//        if(entity == null)
//            throw new IllegalArgumentException("entity must not be null");
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "insert into rents (clientid, movieid,nocopies) values (?,?,?)")) {
//            statement.setLong(1, entity.getClientId());
//            statement.setLong(2, entity.getMovieId());
//            statement.setInt(3, entity.getNoCopies());
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
//    public Optional<Rent> delete(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null.");
//        Optional<Rent> rent = findOne(id);
//        if(!rent.isPresent()) {
//            return Optional.empty();
//        }
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("delete from rent where id=?")) {
//            statement.setLong(1, id);
//
//            statement.executeUpdate();
//
//            return rent;
//        } catch(SQLException e) {
//            throw new RentalException(e);
//        }
//    }
//
//    @Override
//    public Optional<Rent> update(Rent entity) {
//        if (entity == null) {
//            throw new IllegalArgumentException("entity must not be null");
//        }
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "update rents set (name=?,director=?, genre=?, availableCopies=?) WHERE id=?")) {
//            statement.setLong(1, entity.getClientId());
//            statement.setLong(2, entity.getMovieId());
//            statement.setInt(3, entity.getNoCopies());
//            statement.setDate(4, java.sql.Date.valueOf(entity.getRentalDate().toLocalDate()));
//            statement.setDate(5, java.sql.Date.valueOf(entity.getReturnDate().toLocalDate()));
//            statement.setLong(6, entity.getId());
//
//            statement.executeUpdate();
//
//            return Optional.empty();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Optional.of(entity);
//        }
//    }