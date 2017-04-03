package server.service;

import common.Rent;
import common.RentService;
import common.validators.ClientValidator;
import common.validators.RentValidator;
import server.repository.RentDBRepository;
import server.repository.Repository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by paul on 3/13/2017.
 */
public class RentServiceImpl implements RentService {
    private RentValidator rentValidator = new RentValidator();
    private RentDBRepository repository = new RentDBRepository(rentValidator);

    public RentServiceImpl(){

    }

    public void addRent(Rent rent){
        repository.save(rent);
    }

    public Set<Rent> getAllRents() {
        Iterable<Rent> rents = repository.findAll();
        return StreamSupport.stream(rents.spliterator(), false).collect(Collectors.toSet());
    }

    public Set<Rent> filterRentsByNOC(int noc) {
        Iterable<Rent> rents = repository.findAll();
        Set<Rent> filteredRents= new HashSet<>();
        rents.forEach(filteredRents::add);
        filteredRents.removeIf(rn -> rn.getNoCopies()!=noc);
        return filteredRents;
    }

    public void deleteRent(Rent rent) {
        repository.delete(rent.getId());
    }

    public void updateRent(Rent rent) {
        repository.update(rent);
    }
}
