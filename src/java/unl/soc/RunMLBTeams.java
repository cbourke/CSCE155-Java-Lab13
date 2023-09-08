package unl.soc;

import java.util.Collections;
import java.util.List;

/**
 * Driver file for MLB Teams application
 * 
 */
public class RunMLBTeams {

	public static void main(String[] args) {

		// load the teams from the data file
		List<Team> teams = MLBTeamUtils.readFromFile("data/mlb_nl_2011.csv");

		// print out the teams
		System.out.println("Team data original order: ");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 1: sort the teams using the naive selection sort
		// TODO: implement the selectionSortTeamsByPayroll method
		MLBTeamUtils.selectionSortTeamsByPayroll(teams);
		System.out.println("Team data, by payroll (ascending, using selection sort):");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 2: slightly better selection sort using a comparator
		// TODO: (2.1) implement this comparator in MLBTeamUtils
		// TODO: (2.3) implement the MLBTEamUtils.selectionSortTeams method
		// TODO: (2.4) call selectionSortTeams with your comparator to sort the teams
		System.out.println("Team data, by payroll (descending using a comparator with selection sort): ");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 3: sorting the right way

		System.out.println("Team data, sorted by name: ");
		Collections.sort(teams, MLBTeamUtils.BY_NAME);
		MLBTeamUtils.printAllTeams(teams);

		System.out.println("Team data, sorted by win percentage: ");
		Collections.sort(teams, MLBTeamUtils.BY_WIN_PERC);
		MLBTeamUtils.printAllTeams(teams);

		// TODO: (3.2): implement the comparators
		// TODO: (3.3): use your comparators to sort and print using
		// Collections.sort():
		System.out.println("Team data, sorted by state: ");
		MLBTeamUtils.printAllTeams(teams);

		Collections.sort(teams, MLBTeamUtils.BY_STATE_CITY_DESC);
		System.out.println("Team data, sorted by state/city: ");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 4: searching
		// Activity (4.2): observations about binary/linear search
		Team team;
		int index;
		Team caStateKey = new Team(null, 0, 0, null, "CA", 0.0, 0.0);

		Collections.sort(teams, MLBTeamUtils.BY_STATE_DESC);
		System.out.println("\nSearch result #1 for CA team (via state): ");
		index = Collections.binarySearch(teams, caStateKey, MLBTeamUtils.BY_STATE_DESC);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, MLBTeamUtils.BY_STATE_CITY_DESC);
		System.out.println("\nSearch result #2 for CA team (via state/city): ");
		index = Collections.binarySearch(teams, caStateKey, MLBTeamUtils.BY_STATE_DESC);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, MLBTeamUtils.BY_WIN_PERC);
		System.out.println("\nSearch #3 result for CA team (via state/city): ");
		index = Collections.binarySearch(teams, caStateKey, MLBTeamUtils.BY_STATE_DESC);
		team = (index == -1) ? null : teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, MLBTeamUtils.BY_WIN_PERC);
		System.out.println("\nSearch result #1B for CA team (via state/city): ");
		index = MLBTeamUtils.linearSearchMLB(teams, MLBTeamUtils.BY_STATE_DESC, caStateKey);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		// Activity 4.3
		// TODO: Activity 4.3a: create a dummy key for "Cubs":
		// TODO: Activity 4.3b: sort the Teams array using the appropriate comparator
		// TODO: Activity 4.3c: call binary search with the appropriate arguments
		// TODO: Activity 4.3d: print the team to the standard output
		System.out.println("\nSearch result Cubs: ");
		System.out.println("Team found at index " + index + " was: " + team);

	}

}
