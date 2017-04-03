package server.repository;

import common.Client;
import common.validators.RentalException;
import common.validators.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import server.config.JdbcConfig;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * Created by victo on 3/19/2017.
 */
public class ClientDBRepository implements Repository<Long, Client> {
    private Validator<Client> validator;
    @Autowired
    JdbcTemplate jdbcTemplate ;

    public ClientDBRepository(Validator<Client> validator) {
        this.validator = validator;
        this.jdbcTemplate = new JdbcConfig().jdbcTemplate();

    }

    @Override
    public Optional<Client> findOne(Long id) {
        String sql = "select * from clients where id=?";
        Client c = jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Client.class), id);
        return Optional.of(c);
    }
    public List<Client> findAll() {
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


//    @Override
//    public Optional<Client> save(Client entity) {
//        if (entity == null) {
//            throw new IllegalArgumentException("entity must not be null");
//        }
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "insert into clients (name, age) values (?,?)")) {
//            statement.setString(1, entity.getName());
//            statement.setInt(2, entity.getAge());
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
//    public Optional<Client> delete(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null.");
//        Optional<Client> client = findOne(id);
//        if(!client.isPresent()) {
//            return Optional.empty();
//        }
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("delete from clients where id=?")) {
//            statement.setLong(1, id);
//
//            statement.executeUpdate();
//
//            return client;
//        } catch(SQLException e) {
//            throw new RentalException(e);
//        }
//    }
//
//    @Override
//    public Optional<Client> update(Client entity) {
//        if (entity == null) {
//            throw new IllegalArgumentException("entity must not be null");
//        }
//        validator.validate(entity);
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement(
//                     "update client set (name=?,age=?) WHERE id=?")) {
//            statement.setString(1, entity.getName());
//            statement.setInt(2, entity.getAge());
//            statement.setLong(3, entity.getId());
//
//            statement.executeUpdate();
//
//            return Optional.empty();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            return Optional.of(entity);
//        }
//    }

//    @Override
//    public Optional<Client> findOne(Long id) {
//        if(id == null)
//            throw new IllegalArgumentException("id must not be null.");
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("select * from clients where id=?")) {
//            statement.setLong(1, id);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                if (resultSet.next()) {
//                    Long clientId = resultSet.getLong("id");
//                    String name = resultSet.getString("name");
//                    int age = resultSet.getInt("age");
//
//                    Client client = new Client(name, age);
//                    client.setId(clientId);
//                    return Optional.of(client);
//                }
//            }
//        } catch (SQLException e) {
//            throw new RentalException(e);
//        }
//        return Optional.empty();
//    }

//    @Override
//    public Iterable<Client> findAll() {
//        List<Client> clients = new ArrayList<>();
//        try (Connection connection = DriverManager.getConnection(url, username, password);
//             PreparedStatement statement = connection.prepareStatement("select * from clients")) {
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Long clientId = resultSet.getLong("id");
//                    String name = resultSet.getString("name");
//                    int age = resultSet.getInt("age");
//
//                    Client client = new Client(name, age);
//                    client.setId(clientId);
//
//                    clients.add(client);
//                }
//            }
//        } catch (SQLException e) {
//            throw new RentalException(e);
//        }
//
//        return clients;
//    }
