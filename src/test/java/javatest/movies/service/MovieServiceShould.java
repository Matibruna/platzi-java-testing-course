package javatest.movies.service;

import javatest.movies.data.MovieRepository;
import javatest.movies.model.Genre;
import javatest.movies.model.Movie;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieServiceShould {

    private MovieRepository movieRepository;
    private MovieService movieService;

    @Before
    public void setup(){
        this.movieRepository = Mockito.mock(MovieRepository.class);

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

        this.movieService = new MovieService(movieRepository);
    }
    @Test
    public void return_movies_by_genre(){
        Collection<Movie> filteredMovies = movieService.findMoviesByGenre(Genre.COMEDY);

        for(Movie movie : filteredMovies){
            assertEquals(movie.getGenre(), Genre.COMEDY);
        }
    }

    @Test
    public void return_movies_by_duration() {
        int duration = 120;

        Collection<Movie> filteredMovies = movieService.findMoviesByDuration(duration);

        for(Movie movie : filteredMovies){
            assertTrue(movie.getMinutes() <= duration);
        }
    }

    @Test
    public void return_movies_by_genre_and_length() {
        String name = null; // no queremos buscar por nombre
        Integer minutes = 150; // 2h 30m
        Genre genre = Genre.ACTION;
        Movie template = new Movie(name, minutes, genre);
        Collection<Movie> movies =
                movieService.findMoviesByTemplate(template);
        assertThat(getMovieIds(movies), is(Arrays.asList(7)) );
    }

    @Test
    public void return_movies_by_length_and_name() {
        String name = "ME";
        Integer minutes = 115;
        Movie template = new Movie(name, minutes, null);
        Collection<Movie> movies =
                movieService.findMoviesByTemplate(template);
        assertThat(getMovieIds(movies), is(Arrays.asList(2, 6)) );
    }

    @Test
    public void return_just_the_id_movie() {
        Integer id = 3;
        String name = "ME";
        Integer minutes = 115;
        Movie template = new Movie(id, name, minutes, null);
        Collection<Movie> movies =
                movieService.findMoviesByTemplate(template);
        assertThat(getMovieIds(movies), is(Arrays.asList(3)) );
    }

    private List<Integer> getMovieIds(Collection<Movie> movies) {
        return movies.stream().map(Movie::getId).collect(Collectors.toList());
    }
}
