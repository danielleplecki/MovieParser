package com.company;

import java.io.IOException;
import java.util.Scanner;



public class Main {

    /**
     *This method takes user input to search through a list of the current most popular movies. The user can
     * choose whether to return titles by vote average, popularity, genre, or just all titles. The user can conduct
     * multiple searches until they choose to quit the program.
     */
    public static void main(String[] args) throws IOException {
        //Movie list set from the current information on the given web page
        MovieCollection movieList = UrlAndAPI_Key.getMovieCollection();
        boolean isRunning = true;

        while(isRunning){
            System.out.println("What would you like to search for?\nG to search by genre\nV to search by average votes" +
                    "\nP to search by popularity\nA to see all titles");

            //Prints results based on user input
            switch (getUserInput()) {
                case 'G':
                    int requestedID = getValidID();
                    System.out.println(movieList.printByGenre(requestedID));
                    break;
                case 'V':
                    double requestedVoteAvg = getValidVoteAvg();
                    System.out.println(movieList.printByVoteAverage(requestedVoteAvg));
                    break;
                case 'P':
                    double requestedPop = getValidPop(movieList);
                    System.out.println(movieList.printByPopularity(requestedPop));
                    break;
                case 'A':
                    System.out.println(movieList.printTitles());
                    break;
                default:
                    System.out.println("ERROR: invalid input. Please try again.");
                    continue; //User did not enter a valid search criteria so is asked to try again
            }

            //Asks user to start new search or exit program
            System.out.println("Would you like to start a new search?\nY for yes, N for no");
            Scanner newInput = new Scanner(System.in);
            String endInput = newInput.next();
            endInput = endInput.toUpperCase();
            if(endInput.equals("N")){
                System.out.println("Thank you for searching with us!");
                isRunning = false;
            }
        }
    }

    /**
     * Gets user input to call corresponding function in the switch statement.
     * @return the uppercase character that the user entered
     */
    static char getUserInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        input = input.toUpperCase();
        return input.charAt(0);
    }

    /**
     * Asks user to enter a genre ID and prints out an ERROR until a valid ID is entered.
     * @return a valid genre ID
     */
    static int getValidID() throws IOException{
        System.out.println("Enter genre ID.");
        Scanner newID = new Scanner(System.in);
        int requestedID = newID.nextInt();
        while(!isIdValid(requestedID)){
            System.out.println("ERROR: invalid ID. Please try again");
            requestedID = newID.nextInt();
        }
        return requestedID;
    }

    /**
     * Checks the GenreCollection to see if an entered ID is contained in the collection.
     * @param requestedID genre ID entered by the user
     * @return true if the ID is valid and false if it is not
     */
    static boolean isIdValid(int requestedID) throws IOException{
        boolean isIdValid = false;
        GenreCollection allGenres = UrlAndAPI_Key.getGenreList();
        for (int j=0; j<allGenres.getGenres().length; j++) {
            if (allGenres.getPossibleGenres()[j] == requestedID) {
                isIdValid = true;
            }
        }
        return isIdValid;
    }

    /**
     * Asks user to enter a minimum vote average to conduct the search with and prints out an
     * ERROR until a valid vote average is entered.
     * @return a valid vote average
     */
    static double getValidVoteAvg(){
        System.out.println("Enter minimum vote average.");
        Scanner newVoteAvg = new Scanner(System.in);
        double requestedVoteAvg = newVoteAvg.nextDouble();
        while(!isVoteAvgValid(requestedVoteAvg)){
            System.out.println("ERROR: invalid vote average. Please try again. Vote average must be" +
                    "between 0 and 10.");
            requestedVoteAvg = newVoteAvg.nextDouble();
        }
        return requestedVoteAvg;
    }

    /**
     * Checks if user's input is valid. All vote averages are between 0 and 10.
     * @param requestedVoteAvg vote average entered by user
     * @return true if it is valid and false if it is not
     */
    static boolean isVoteAvgValid(double requestedVoteAvg){
        return(requestedVoteAvg>=0 && requestedVoteAvg<=10);
    }

    /**
     * Asks user to enter a minimum popularity to conduct the search with and prints out an
     * ERROR until a valid popularity is entered.
     * @param movieList MovieCollection used to evaluate if popularity is valid
     * @return a valid popularity
     */
    static double getValidPop(MovieCollection movieList){
        System.out.println("Enter minimum popularity.");
        Scanner newPop = new Scanner(System.in);
        double requestedPop = newPop.nextDouble();
        while(!isPopValid(requestedPop, movieList)){
            System.out.println("ERROR: invalid popularity. Please try again. Popularity must be less than " +
                    movieList.getPopularityMax() + ".");
            requestedPop = newPop.nextDouble();
        }
        return requestedPop;
    }

    /**
     * Checks if user's input is valid. The highest popularity a user can search by can be no higher than
     * the highest popularity in the MovieCollection.
     * @param requestedPop popularity entered by the user
     * @param movieList MovieCollection used to find the current highest popularity
     * @return true if it is valid, false if it is not
     */
    static boolean isPopValid(double requestedPop,MovieCollection movieList){
        double mostPopular = movieList.getPopularityMax();
        return(requestedPop <= mostPopular && requestedPop >= 0);
    }
}
