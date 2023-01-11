package javatest.movies.service;

import javatest.movies.data.MovieRepository;
import javatest.movies.model.Genre;
import javatest.movies.model.Movie;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public Collection<Movie> findMoviesByGenre(Genre genre) {
        Collection<Movie> allMovies = movieRepository.findAll();
        Collection<Movie> filteredMovies = new ArrayList<>();

        for(Movie movie : allMovies){
            if(movie.getGenre() == genre){
                filteredMovies.add(movie);
            }
        }

        return filteredMovies;
    }


    public Collection<Movie> findMoviesByDuration(int duration) {
        return movieRepository.findAll().stream().filter(movie -> movie.getMinutes() <= duration).collect(Collectors.toList());
    }
}
