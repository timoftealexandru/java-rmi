package server.service;

import common.Client;
import common.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.repository.ClientDBRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by paul on 3/13/2017.
 */
@Service
public class ClientServiceImpl implements ClientService{
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
//    private ClientValidator clientValidator = new ClientValidator();

    @Autowired
    private ClientDBRepository repository;
=======
    private ClientValidator clientValidator = new ClientValidator();
    private ClientDBRepository repository = new ClientDBRepository(clientValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private ClientValidator clientValidator = new ClientValidator();
    private ClientDBRepository repository = new ClientDBRepository(clientValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private ClientValidator clientValidator = new ClientValidator();
    private ClientDBRepository repository = new ClientDBRepository(clientValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6

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
        filteredClients.removeIf(cl -> cl.getCnp()!=age);

        return filteredClients;
    }

    public void deleteClient(Client client) {
        repository.delete(client.getCnp());
    }

    public void updateClient(Client client) {
        repository.update(client);
    }
}

