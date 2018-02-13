package com.company;

/**
 * This class contains all of the information for each movie in a MovieCollection.
 * @author Danielle Plecki
 */
public class Movies {
    private String title;
    private double popularity;
    private double vote_average;
    private int[] genre_ids;

    String getTitle() {
        return title;
    }

    double getPopularity() {
        return popularity;
    }

    double getVote_average() {
        return vote_average;
    }

    int[] getGenre_ids() {
        return genre_ids;
    }

    boolean genreSearch(int x){
        boolean isGenre = false;
        for(int i=0; i<getGenre_ids().length; i++){
            if(getGenre_ids()[i] == x){
                isGenre = true;
            }
        }
        return isGenre;
    }
}