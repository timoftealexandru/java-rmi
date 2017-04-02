package client.service;


import common.Movie;
import common.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Set;

/**
 * Created by Nicu on 4/1/17.
 */

public class MovieServiceClient implements MovieService {
    @Autowired
    private MovieService movieService;

    @Override
    public void addMovie(Movie movie){
        movieService.addMovie(movie);
    }

    @Override
    public Set<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @Override
    public Set<Movie> filterMovieByType(String m){
        return movieService.filterMovieByType(m);
    }

    @Override
    public void deleteMovie(Movie movie){
        movieService.deleteMovie(movie);
    }

    @Override
    public void updateMovie(Movie movie){
        movieService.updateMovie(movie);
    }

}