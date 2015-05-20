package unl.cse.sorting;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Utilities class that contains custom methods for loading, sorting, and searching
 * for Teams
 *
 */
public class MLBTeamUtils {

	private final static int NUM_TEAMS = 16;

	/**
	 * Utility method to read team data from a file
	 * @param inputFileName
	 * @return
	 */
	public static Team[] readFromFile(String inputFileName) {

		int index = 0;  // Input loop counter
		String name, city, state;   // String temp variables
		int wins, losses;                   // int temp variables
		double totalPay, avgPay;            // double temp variables

		Team team;      // Team reference variable

		Team[] teams = new Team[NUM_TEAMS];

		/* Prepare to obtain data for the teams */
		try {

			File inputFile = new File( inputFileName );
			Scanner input = new Scanner( inputFile );

			//throw away header line
			input.nextLine();

			/* Obtain teams data and assemble a list of Teams */
			while( input.hasNext() ){

				name = input.next();
				wins = Integer.parseInt( input.next() );
				losses = Integer.parseInt( input.next() );
				city = input.next();
				state = input.next();
				totalPay = Double.parseDouble( input.next() );
				avgPay = Double.parseDouble( input.next() );

				/* Instantiate the team from the collected input */
				team = new Team( name, wins, losses, city, state, totalPay, avgPay);

				teams[index] = team;
				index++;

			} // End input collection while loop
			input.close();
		}catch( FileNotFoundException notFound ){

			System.err.println( "File, "+inputFileName+" not found, exiting..." );
			System.exit( 1 );            

		} // End try-catch block
		return teams;
	}

	/**
	 * A static method that will print the teams in the given array
	 * @param teams
	 */
	public static void printAllTeams(Team[] teams) {
		System.out.println(String.format("%-10s %-4s %-4s %-6s  %-15s %-2s %13s %11s", "Name", "Wins", "Loss", "Perc", "City", "State", "Payroll", "Average"));
		for(Team t : teams) {
			System.out.println(t);
		}
		System.out.println("\n");
	}

	/**
	 * Sorts the teamsData array using the selection sort algorithm.
	 */
	public static void selectionSortTeamsByPayroll(Team[] teams){

		// TODO: Implement this method using a selection sort algorithm

	}


	/**
	 * Sorts the teamsData array using rules specified by the given comparator
	 */
	public static void selectionSortTeams(Team[] teams, Comparator<Team> comparator) {

		// TODO: Implement this method


	} // End selectionSortTeams() 


	/**
	 * Performs a linear search for a matching team based on the type of 
	 * comparator passed in.
	 * @param comp the Comparator type to base the search on.
	 * @param key the 'dummy' key used to compare for a match in the array.
	 * @return integer the index of the matching team, or -1 for not found.
	 */
	public static int linearSearchMLB(Team[] teams, Comparator<Team> comp, Team key) {

		for(int i=0; i<teams.length; i++) {
			if(comp.compare(teams[i], key) == 0)
				return i;
		} // End for loop
		return -1;  // Not found

	}

}
