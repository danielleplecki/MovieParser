package com.company;

/**
 * This class contains a collections of all of the possible movie genres.
 * @author Danielle Plecki
 */
public class GenreCollection {
    private Genres[] genres;
    private int[] possibleGenres;

    Genres[] getGenres(){
        return genres;
    }

    //collects all genre IDs in one array for use in main function
    int[] getPossibleGenres(){
        possibleGenres = new int[getGenres().length];
        for(int i=0; i<getGenres().length; i++){
            possibleGenres[i]= getGenres()[i].getID();
        }
        return possibleGenres;
    }
}
