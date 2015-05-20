package unl.cse.sorting;

import java.util.Comparator;

/**
 * A Comparator class that orders Teams by team name, ascending
 * CSCE 155H
 */
public class NameComparator implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		return o1.getName().compareTo(o2.getName());
	}
}

