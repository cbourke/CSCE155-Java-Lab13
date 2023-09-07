package unl.soc;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Utilities class that contains custom methods for loading, sorting, and
 * searching for Teams
 *
 */
public class MLBTeamUtils {

	/**
	 * Utility method to read team data from a file
	 * 
	 * @param inputFileName
	 * @return
	 */
	public static List<Team> readFromFile(String inputFileName) {

		String name, city, state;
		int wins, losses;
		double totalPay, avgPay;

		List<Team> teams = new ArrayList<>();

		try (Scanner input = new Scanner(new File(inputFileName))) {

			// ignore the header line
			input.nextLine();

			while (input.hasNextLine()) {

				String data = input.nextLine();
				String tokens[] = data.split(",");

				name = tokens[0];
				wins = Integer.parseInt(tokens[1]);
				losses = Integer.parseInt(tokens[2]);
				city = tokens[3];
				state = tokens[4];
				totalPay = Double.parseDouble(tokens[5]);
				avgPay = Double.parseDouble(tokens[6]);

				Team t = new Team(name, wins, losses, city, state, totalPay, avgPay);
				teams.add(t);

			}
			input.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return teams;
	}

	/**
	 * A static method that will print the teams in the given array
	 * 
	 * @param teams
	 */
	public static void printAllTeams(List<Team> teams) {
		System.out.println(String.format("%-10s %-4s %-4s %-6s  %-15s %-2s %13s %11s", "Name", "Wins", "Loss", "Perc",
				"City", "State", "Payroll", "Average"));
		for (Team t : teams) {
			System.out.println(t);
		}
		System.out.println("\n");
	}

	/**
	 * Sorts the teamsData array using the selection sort algorithm.
	 */
	public static void selectionSortTeamsByPayroll(List<Team> teams) {

		// TODO: Implement this method using a selection sort algorithm

	}

	/**
	 * Sorts the teamsData array using rules specified by the given comparator
	 */
	public static void selectionSortTeams(List<Team> teams, Comparator<Team> comparator) {

		// TODO: Implement this method

	}

	/**
	 * Performs a linear search for a matching team based on the type of comparator
	 * passed in.
	 * 
	 * @param comp the Comparator type to base the search on.
	 * @param key  the 'dummy' key used to compare for a match in the array.
	 * @return integer the index of the matching team, or -1 for not found.
	 */
	public static int linearSearchMLB(List<Team> teams, Comparator<Team> comp, Team key) {

		for (int i = 0; i < teams.size(); i++) {
			if (comp.compare(teams.get(i), key) == 0)
				return i;
		}
		return -1;

	}

}
