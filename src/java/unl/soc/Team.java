package unl.soc;

/**
 * Class that holds and computes data associated with Major League Baseball teams
 *
 */
public class Team {

	private final String name;
	private final Integer wins;
	private final Integer loss;
	private final String city;
	private final String state;
	private final Double payroll;
	private final Double averageSalary;
	
	public Team(String name, Integer wins, Integer loss, String city, String state, Double payroll, Double averageSalary) {
		this.name = name;
		this.wins = wins;
		this.loss = loss;
		this.city = city;
		this.state = state;
		this.payroll = payroll;
		this.averageSalary = averageSalary;
	}

	public String getName() {
		return name;
	}
	public Integer getWins() {
		return wins;
	}
	public Integer getLoss() {
		return loss;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public Double getPayroll() {
		return payroll;
	}

	public Double getAverageSalary() {
		return averageSalary;
	}
	
	public Double getWinPercentage() {
		if(wins == null || loss == null) {
			return null;
		} else {
			return wins / (double) (wins + loss);
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("%-10s %4d %4d (%4.3f) %-15s %-5s $%12.2f $%9.2f", this.name, this.wins, this.loss, this.getWinPercentage(), this.city, this.state, this.payroll, this.averageSalary));
		return sb.toString();
	}
}
