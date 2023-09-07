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
		List<Team> teams = MLBTeamUtils.readFromFile("data/mlb_nl_2011.txt");

		// print out the teams
		System.out.println("Team data original order: ");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 1: sort the teams using the naive selection sort
		// TODO: implement the selectionSortTeamsByPayroll method
		MLBTeamUtils.selectionSortTeamsByPayroll(teams);
		System.out.println("Team data, by payroll (ascending, using selection sort):");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 2: slightly better selection sort using a comparator
		// TODO: (2.1) implement this comparator:
		PayrollDescendingComparator payrollDesc = new PayrollDescendingComparator();
		// TODO: (2.3) implement the MLBTEamUtils.selectionSortTeams method
		// TODO: (2.4) call selectionSortTeams with your comparator to sort the Teams
		// array:
		System.out.println("Team data, by payroll (descending using a comparator with selection sort): ");
		MLBTeamUtils.printAllTeams(teams);

		// Activity 3: sorting the right way
		NameComparator nameComp = new NameComparator();
		WinPercentComparator winPercentComp = new WinPercentComparator();

		System.out.println("Team data, sorted by name: ");
		Collections.sort(teams, nameComp);
		MLBTeamUtils.printAllTeams(teams);

		System.out.println("Team data, sorted by win percentage: ");
		Collections.sort(teams, winPercentComp);
		MLBTeamUtils.printAllTeams(teams);

		// TODO: (3.2): implement the comparators StateComparator and
		// StateCityComparator
		StateComparator stateComp = new StateComparator();
		StateCityComparator stateCityComp = new StateCityComparator();
		// TODO: (3.3): use your comparators to sort and print using the Arrays.sort
		// method:

		// Activity 4: searching
		// Activity (4.2): observations about binary/linear search
		Team team;
		int index;
		Team caStateKey = new Team(null, 0, 0, null, "CA", 0.0, 0.0);

		Collections.sort(teams, stateComp);
		System.out.println("\nSearch result #1 for CA team (via state): ");
		index = Collections.binarySearch(teams, caStateKey, stateComp);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, stateCityComp);
		System.out.println("\nSearch result #2 for CA team (via state/city): ");
		index = Collections.binarySearch(teams, caStateKey, stateComp);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, winPercentComp);
		System.out.println("\nSearch #3 result for CA team (via state/city): ");
		index = Collections.binarySearch(teams, caStateKey, stateComp);
		team = (index == -1) ? null : teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		Collections.sort(teams, winPercentComp);
		System.out.println("\nSearch result #1B for CA team (via state/city): ");
		index = MLBTeamUtils.linearSearchMLB(teams, stateComp, caStateKey);
		team = teams.get(index);
		System.out.println("Team found at index " + index + " was: " + team);

		// Activity 4.3
		// TODO: Activity 4.3a: create a dummy key for "Cubs":
		// TODO: Activity 4.3b: sort the Teams array using the appropriate comparator
		// TODO: Activity 4.3c: call binary search with the appropriate arguments
		// TODO: Activity 4.3d: print the team to the standard output

	}

}
