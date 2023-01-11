package javatest.movies.service;

import javatest.movies.data.MovieRepository;
import javatest.movies.model.Genre;
import javatest.movies.model.Movie;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

public class MovieServiceShould {

    @Test
    public void return_movies_by_genre(){

        MovieRepository movieRepository = Mockito.mock(MovieRepository.class);

        Mockito.when(movieRepository.findAll()).thenReturn(
            Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION),
                new Movie(2, "Memento", 113, Genre.THRILLER),
                new Movie(3, "There's Something About Marty", 119, Genre.COMEDY),
                new Movie(4, "Super 8", 112, Genre.THRILLER),
                new Movie(5, "Scream", 111, Genre.HORROR),
                new Movie(6, "Home Alone", 103, Genre.COMEDY),
                new Movie(7, "Matrix", 136, Genre.ACTION)
        ));

        MovieService movieService = new MovieService(movieRepository);

        Collection<Movie> filteredMovies = movieService.findMoviesByGenre(Genre.COMEDY);

        for(Movie movie : filteredMovies){
            assertEquals(movie.getGenre(), Genre.COMEDY);
        }
    }

    @Test
    public void return_() {

    }

}