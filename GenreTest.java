package com.company;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Class to test GenreCollection and Genres classes
 * @author Danielle Plecki
 */
public class GenreTest {
    private static GenreCollection testGenreList;

    @BeforeClass
    public static void setUp() throws Exception{
        testGenreList = UrlAndAPI_Key.getGenreList();
    }

    @Test
    public void testGenreListLength() throws Exception{
        assertTrue(testGenreList.getPossibleGenres().length == 19);
    }

    @Test
    public void testGetID() throws Exception{
        Genres documentary = testGenreList.getGenres()[5];
        assertTrue(documentary.getID() == 99);
    }

}