package com.company;

import com.google.gson.Gson;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test Main methods
 * @author Danielle Plecki
 */
public class MainTest {
    private static MovieCollection testMovieList;

    @BeforeClass
    public static void setUp() throws Exception{
        Gson gson = new Gson();
        testMovieList = gson.fromJson(TESTMovieList.getTestMovieList(), MovieCollection.class);
    }

    @Test
    public void testValidID() throws Exception{
        int invalidIdA = 8;
        int invalidIdB = 1077;
        int validIdA = 12;
        int validIdB = 10770;
        assertFalse(Main.isIdValid(invalidIdA));
        assertFalse(Main.isIdValid(invalidIdB));
        assertTrue(Main.isIdValid(validIdA));
        assertTrue(Main.isIdValid(validIdB));
    }

    @Test
    public void testValidVoteAvg() throws Exception{
        double invalidVoteAvgA = 10.001;
        double invalidVoteAvgB = -3;
        double validVoteAvgA = 0;
        double validVoteAvgB = 10;
        double validVoteAvgC = 6.243;
        assertFalse(Main.isVoteAvgValid(invalidVoteAvgA));
        assertFalse(Main.isVoteAvgValid(invalidVoteAvgB));
        assertTrue(Main.isVoteAvgValid(validVoteAvgA));
        assertTrue(Main.isVoteAvgValid(validVoteAvgB));
        assertTrue(Main.isVoteAvgValid(validVoteAvgC));
    }

    @Test
    public void testValidPop() throws Exception{
        double invalidPopA = -82;
        double invalidPopB = 500;
        double validPopA = 0;
        double validPopB = 35.8748729;
        double validPopC = 150.7;
        assertFalse(Main.isPopValid(invalidPopA, testMovieList));
        assertFalse(Main.isPopValid(invalidPopB, testMovieList));
        assertTrue(Main.isPopValid(validPopA, testMovieList));
        assertTrue(Main.isPopValid(validPopB, testMovieList));
        assertTrue(Main.isPopValid(validPopC, testMovieList));
    }
}