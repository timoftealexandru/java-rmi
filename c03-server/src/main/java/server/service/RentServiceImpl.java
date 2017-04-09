package server.service;

import common.Rent;
import common.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import server.repository.RentDBRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by paul on 3/13/2017.
 */

public class RentServiceImpl implements RentService {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    @Autowired
    private RentDBRepository repository;
=======
    private RentValidator rentValidator = new RentValidator();
    private RentDBRepository repository = new RentDBRepository(rentValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private RentValidator rentValidator = new RentValidator();
    private RentDBRepository repository = new RentDBRepository(rentValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private RentValidator rentValidator = new RentValidator();
    private RentDBRepository repository = new RentDBRepository(rentValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6

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
        repository.delete(rent.getMovieId());
    }

    public void updateRent(Rent rent) {
        repository.update(rent);
    }
}
