package unl.soc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * A JUnit test suite for seaching, sorting and comparator code.
 * 
 */
public class SortTests {
	
	public static final List<Team> TEAM_DATA = new ArrayList<>();
	static {
		TEAM_DATA.add(new Team("a", 1, 2, "a", "b", 20.1, 0.0));
		TEAM_DATA.add(new Team("e", 8, 5, "c", "a", 10.2, 0.0));
		TEAM_DATA.add(new Team("d", 3, 3, "b", "a", 30.0, 0.0));
		TEAM_DATA.add(new Team("j", 9, 4, "i", "c", 20.0, 0.0));
		TEAM_DATA.add(new Team("f", 2, 1, "j", "d", 20.1, 0.0));
		TEAM_DATA.add(new Team("b", 7, 6, "e", "d", 18.0, 0.0));
		TEAM_DATA.add(new Team("i", 4, 9, "g", "b", 14.0, 0.0));
		TEAM_DATA.add(new Team("h", 6, 8, "h", "b", 90.0, 0.0));
		TEAM_DATA.add(new Team("c", 5, 7, "f", "b",  1.0, 0.0));
	}
	
	public static <T> boolean equal(List<T> a, List<T> b, Comparator<T> cmp) {
		if(a.size() != b.size()) {
			return false;
		}
		for(int i=0; i<a.size(); i++) {
			if( cmp.compare(a.get(i), b.get(i)) != 0) {
				return false;
			}
		}
		return true;
	}

	@Test
	public void testSelectionSortTeamsByPayroll() {

		List<Team> actual   = new ArrayList<>(TEAM_DATA);
		MLBTeamUtils.selectionSortTeamsByPayroll(actual);
		for(int i=0; i<actual.size()-1; i++) {
			assertTrue(actual.get(i).getPayroll() <= actual.get(i+1).getPayroll());
		}
	}

	@Test
	public void testSelectionSortTeams() {
		List<Team> expected = new ArrayList<>(TEAM_DATA);
		List<Team> actual   = new ArrayList<>(TEAM_DATA);
		Collections.sort(expected, MLBTeamUtils.BY_WIN_PERC);
		MLBTeamUtils.selectionSortTeams(actual, MLBTeamUtils.BY_WIN_PERC);
		assertTrue(equal(expected, actual, MLBTeamUtils.BY_WIN_PERC));
	}
	
	
	//name and win percentage are given
	//TEST: payroll desc, state, state-city
	@Test
	public void testPayrollDescComparator() {
		assertTrue( MLBTeamUtils.BY_PAYROLL_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(1)) < 0 );
		assertTrue( MLBTeamUtils.BY_PAYROLL_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(0)) > 0 );
		assertTrue( MLBTeamUtils.BY_PAYROLL_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(0)) == 0 );
		assertTrue( MLBTeamUtils.BY_PAYROLL_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(1)) == 0 );
	}
	
	@Test
	public void testStateDescComparator() {
		assertTrue( MLBTeamUtils.BY_STATE_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(1)) < 0 );
		assertTrue( MLBTeamUtils.BY_STATE_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(0)) > 0 );
		assertTrue( MLBTeamUtils.BY_STATE_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(0)) == 0 );
		assertTrue( MLBTeamUtils.BY_STATE_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(1)) == 0 );
	}

	@Test
	public void testStateCityDescComparator() {
		assertTrue( MLBTeamUtils.BY_STATE_CITY_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(1)) < 0 );
		assertTrue( MLBTeamUtils.BY_STATE_CITY_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(0)) > 0 );
		assertTrue( MLBTeamUtils.BY_STATE_CITY_DESC.compare(TEAM_DATA.get(0), TEAM_DATA.get(0)) == 0 );
		assertTrue( MLBTeamUtils.BY_STATE_CITY_DESC.compare(TEAM_DATA.get(1), TEAM_DATA.get(1)) == 0 );
	}
	
	

}
