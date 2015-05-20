package unl.cse.sorting;

import java.util.Comparator;

/**
 * A Comparator class that orders Teams by win percentage, descending
 * CSCE 155H
 */
public class WinPercentComparator implements Comparator<Team>{

	public int compare(Team firstTeam, Team secondTeam) {

		return (int) Math.signum(secondTeam.getWinPercentage() - firstTeam.getWinPercentage());

	}

}

