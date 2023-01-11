package javatest.movies.data;

import javatest.movies.model.Genre;
import javatest.movies.model.Movie;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.init.ScriptUtils;

import javax.sql.DataSource;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Collection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MovieRepositoryIntegrationTest {
    private MovieRepositoryJdbc movieRepository;
    private DataSource dataSource;

    @Before
    public void setUp() throws Exception {
        this.dataSource = new DriverManagerDataSource("jdbc:h2:mem:test;MODE=MYSQL", "sa", "sa");

        ScriptUtils.executeSqlScript(dataSource.getConnection(), new ClassPathResource("sql-scripts/test-data.sql"));

        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

        this.movieRepository = new MovieRepositoryJdbc(jdbcTemplate);
    }

    @Test
    public void load_all_movies() throws SQLException {
        Collection<Movie> movies = movieRepository.findAll();

        assertThat(movies, is(Arrays.asList(
                new Movie(1, "Dark Knight", 152, Genre.ACTION) ,
                new Movie(2, "Memento", 113, Genre.THRILLER) ,
                new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void load_movie_by_id() {
        Movie movie = movieRepository.findById(3);

        assertThat(movie, is(
                new Movie(3, "Matrix", 136, Genre.ACTION)
        ));
    }

    @Test
    public void search_movies_by_name() {
        Collection<Movie> movies = movieRepository.findByName("M");

        assertThat(movies, is(Arrays.asList(
            new Movie(2, "Memento", 113, Genre.THRILLER),
            new Movie(3, "Matrix", 136, Genre.ACTION)
        )));
    }

    @Test
    public void insert_movie_into_db() {
        Movie movie = new Movie(4,"Wednesday", 58, Genre.COMEDY);

        movieRepository.saveOrUpdate(movie);

        Movie load_movie = movieRepository.findById(4);

        assertThat(load_movie, is(
                movie
        ));
    }

    @After
    public void tearDown() throws Exception {
        final Statement s = dataSource.getConnection().createStatement();
        s.execute("drop all objects delete files");
    }
}