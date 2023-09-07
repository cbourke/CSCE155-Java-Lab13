package unl.soc;

import java.util.Comparator;

/**
 * A Comparator class that orders {@link Team}s by team name, in ascending
 * order.  This has been implemented for you.
 */
public class NameComparator implements Comparator<Team> {

	@Override
	public int compare(Team o1, Team o2) {
		return o1.getName().compareTo(o2.getName());
	}
}
