package edu.birzeit.moviestore;


public class MovieFactory {
    public IMovieData getModel(){

        return new MovieData();
    }
}
