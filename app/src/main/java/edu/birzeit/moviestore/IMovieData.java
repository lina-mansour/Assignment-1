package edu.birzeit.moviestore;

import java.util.List;

public interface IMovieData {
    List<Movie> searchMovie(Movie target);
    String[] getGenres();
    String[] getYears() ;

    }
