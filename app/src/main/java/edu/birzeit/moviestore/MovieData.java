package edu.birzeit.moviestore;

import java.util.ArrayList;
import java.util.List;

 class MovieData implements IMovieData {

    private ArrayList<Movie> movies = new ArrayList<>();
    public MovieData(){
        movies.add(new Movie("The Incrediables", "2019",
                "Action"));
        movies.add(new Movie("Zootopia", "2016",
                "Action"));
        movies.add(new Movie("Cinderella", "2015",
                "Drama"));
        movies.add(new Movie("Moana", "2016",
                "Adventure"));
        movies.add(new Movie("Million Dollar Arm", "2014",
                "Sports"));
        movies.add(new Movie("Glory Road", "2016",
                "History"));
        movies.add(new Movie("Beauty and the Beast", "2017",
                "Fantasy"));
        movies.add(new Movie("Frozen 2", "2020",
                "Musical"));
        movies.add(new Movie("Frozen 3", "2020",
                "Drama"));
    }
     @Override
     public String[] getGenres() {
         String[] genres = new String[]{"Select Genre","Action", "Drama", "Adventure", "Sports", "History", "Fantasy", "Musical"};

         return genres;
     }
     @Override
     public String[] getYears() {
         String[] years = new String[]{"Select Year","2014","2015", "2016", "2017", "2018", "2019", "2020"};

         return years;
     }
    @Override
    public List<Movie> searchMovie(Movie target) {
        ArrayList<Movie> data = new ArrayList<>();

        int existInAll=0;
        for(Movie m : movies) {
            int exist = 0;
            if (m.getTitle().toLowerCase().contains(target.getTitle().toLowerCase()) || (target.getTitle().equalsIgnoreCase(""))) {

                if (m.getTitle().toLowerCase().contains(target.getTitle().toLowerCase())&&! (target.getTitle().equalsIgnoreCase(""))) {
                    exist = 1;

                }
                if (m.getYear().equals(target.getYear()) || (target.getYear().equalsIgnoreCase("Select Year"))) {

                    if (m.getYear().equals(target.getYear())) {
                        exist = 1;

                    }

                    if (m.getGenre().equals(target.getGenre()) || target.getGenre().equals("Select Genre")) {
                        if (m.getGenre().equals(target.getGenre())) {
                            exist = 1;

                        }

                        if (exist == 1) {
                            data.add(m);
                            existInAll=1;
                        }

                    }
                }


            }

        }
        if(existInAll==0)
            data.add(new Movie("No match", "0", "0"));
        return data;
    }

}
