package com.company;


/**
 * This class contains a collection of the most popular movies and methods to print these movies
 * by a specified parameter.
 * @author Danielle Plecki
 */
public class MovieCollection {
    private int total_resluts;
    private int total_pages;
    private  Movies[] results;

    public int getTotal_resluts() {
        return total_resluts;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public  Movies[] getMovies() {
        return results;
    }

    /**
     * This method returns the popularity of the first movie on the list, which is the most popular.
     * @return highest popularity
     */
    double getPopularityMax(){
        return results[0].getPopularity();
    }

    String printTitles() {
        String allTitles = "";
        for (int j = 0; j < getMovies().length; j++) {
            allTitles += (getMovies()[j].getTitle() + "\n");
        }
        return allTitles;
    }

    String printByGenre(int x){
        String genreTitles = "";
        for (int k = 0; k < getMovies().length; k++) {
            if(getMovies()[k].genreSearch(x)){
                genreTitles += (getMovies()[k].getTitle() + "\n");
            }
        }
        return genreTitles;
    }
    String printByVoteAverage(double y) {
        String averageVoteTitles = "";
        for (int r = 0; r < getMovies().length; r++) {
            if (getMovies()[r].getVote_average() >= y) {
                averageVoteTitles += (getMovies()[r].getTitle() + "\n");
            }
        }
        return averageVoteTitles;
    }
    String printByPopularity(double z){
        String popularTitles = "";
        for (int s = 0; s < getMovies().length; s++) {
            if (getMovies()[s].getPopularity() >= z) {
                popularTitles += (getMovies()[s].getTitle() + "\n");
            }

        }
        return popularTitles;
    }
}
