package javatest.movies.data;

import javatest.movies.model.Movie;

import java.util.Collection;

public interface MovieRepository {
    Movie findById(long id);
    Collection<Movie> findAll();
    void saveOrUpdate(Movie movie);
    Collection<Movie> findByName(String searchStr);
}
