package unl.soc;

import java.util.Comparator;

/**
 * A Comparator class that orders {@link Team}s by win percentage in descending
 * order.
 */
public class WinPercentComparator implements Comparator<Team> {

	public int compare(Team firstTeam, Team secondTeam) {

		return (int) Math.signum(secondTeam.getWinPercentage() - firstTeam.getWinPercentage());

	}

}
