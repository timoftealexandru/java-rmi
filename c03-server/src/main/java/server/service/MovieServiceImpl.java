package server.service;


import common.Movie;
import common.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import server.repository.MovieDBRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
/**
 * Created by Nicu on 3/5/2017.
 */
@Service
public class MovieServiceImpl implements MovieService {
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD

    @Autowired
    private MovieDBRepository repository;
=======
    private MovieValidator movieValidator = new MovieValidator();
    private MovieDBRepository repository = new MovieDBRepository(movieValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private MovieValidator movieValidator = new MovieValidator();
    private MovieDBRepository repository = new MovieDBRepository(movieValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6
=======
    private MovieValidator movieValidator = new MovieValidator();
    private MovieDBRepository repository = new MovieDBRepository(movieValidator);
>>>>>>> 8e7da753f0004969eed9d95df6cfae6eaa2f91e6

    public MovieServiceImpl() {

    }


    public void addMovie(Movie movie) {
        repository.save(movie);
    }

    public Set<Movie> getAllMovies() {
        Iterable<Movie> movies = repository.findAll();
        return StreamSupport.stream(movies.spliterator(), false).collect(Collectors.toSet());
    }

    public Set<Movie> filterMovieByType(String m) {
        Iterable<Movie> movies = repository.findAll();
        Set<Movie> filteredMovies= new HashSet<>();
        movies.forEach(filteredMovies::add);
        filteredMovies.removeIf(movie -> !movie.getGenre().contains(m));

        return filteredMovies;
    }

    public void deleteMovie(Movie movie) {
//        Iterable<Movie> movies = server.repository.findAll();
//        movies.removeIf(m -> m.getName() == movie.getName())
        repository.delete(movie.getId());
    }

    public void updateMovie(Movie movie) {
        repository.update(movie);
   }
}
