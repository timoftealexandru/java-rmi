package server.service;

import common.Client;
import common.ClientService;
import common.validators.ClientValidator;
import server.repository.ClientDBRepository;
import server.repository.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by paul on 3/13/2017.
 */
public class ClientServiceImpl implements ClientService{

    String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String password = "123456";
    private ClientValidator clientValidator = new ClientValidator();
    private ClientDBRepository repository = new ClientDBRepository(clientValidator,url,username,password);

    public ClientServiceImpl() {

    }

    public void addClient(Client cl) {
        repository.save(cl);
    }

    public Set<Client> getAllClients() {
        Iterable<Client> clients = repository.findAll();
        return StreamSupport.stream(clients.spliterator(), false).collect(Collectors.toSet());
    }

    public Set<Client> filterClientsByAge(int age) {
        Iterable<Client> clients = repository.findAll();
        Set<Client> filteredClients= new HashSet<>();
        clients.forEach(filteredClients::add);
        filteredClients.removeIf(cl -> cl.getAge()!=age);

        return filteredClients;
    }

    public void deleteClient(Client client) {
        repository.delete(client.getId());
    }

    public void updateClient(Client client) {
        repository.update(client);
    }
}

