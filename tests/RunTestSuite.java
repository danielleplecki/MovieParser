package com.company;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/**
 * Class to run test suite to test all classes of the program
 * @author Danielle Plecki
 */
@RunWith(Suite.class)
@SuiteClasses({MainTest.class, MovieTest.class, GenreTest.class})

public class RunTestSuite {
}
