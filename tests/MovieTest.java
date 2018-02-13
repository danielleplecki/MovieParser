package com.company;

import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Class to test MovieCollection and Movies class
 * @author Danielle Plecki
 */
public class MovieTest {
   private static MovieCollection testMovieList;

   @BeforeClass
    public static void setUp()throws Exception{
       Gson gson = new Gson();
       testMovieList = gson.fromJson(TESTMovieList.getTestMovieList(), MovieCollection.class);
   }

   @Test
    public void testListLength() throws Exception{
       int testLength = testMovieList.getMovies().length;
       assertTrue(testLength == 20);//always 20 results in one page
   }

   @Test
    public void testGenreSearch() throws Exception{
       int invalidIdA = 17; //not in genre list
       int invalidIdB = 80; //in genre list but not in movie
       int validIdA = 12;
       int validIdB = 28;
       Movies testMovie = testMovieList.getMovies()[3];
       assertFalse(testMovie.genreSearch(invalidIdA));
       assertFalse(testMovie.genreSearch(invalidIdB));
       assertTrue(testMovie.genreSearch(validIdA));
       assertTrue(testMovie.genreSearch(validIdB));
   }

   @Test
    public void testGenrePrint() throws Exception{
       int genreWar = 10752;
       int genreWestern = 37;
       int genreMusic = 10402;
       assertTrue(testMovieList.printByGenre(genreWar).equals("Hacksaw Ridge\n"));
       assertTrue(testMovieList.printByGenre(genreWestern).equals(""));
       assertTrue(testMovieList.printByGenre(genreMusic).equals("La La Land\n"));
   }

   @Test
    public void testPopPrint() throws Exception{
       double highPop = 200;
       double overMaxPop = 300;
       assertTrue(testMovieList.printByPopularity(highPop).equals("Fifty Shades Darker\n"));
       assertTrue(testMovieList.printByPopularity(overMaxPop).equals(""));
   }

   @Test
    public void testVoteAvgPrint() throws Exception{
       double highestAvg = 8;
       double overMaxAvg = 11;
       assertTrue(testMovieList.printByVoteAverage(highestAvg).equals("Interstellar\n"));
       assertTrue(testMovieList.printByVoteAverage(overMaxAvg).equals(""));
   }
}