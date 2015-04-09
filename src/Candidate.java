import java.util.ArrayList;
import java.util.List;

public class Candidate {
	private String name;
	private List<Voter> list = new ArrayList<Voter>();
	private int amount = 0;

	public Candidate(String name) {
		this.name = name;
	}

	public void add(Voter voter) {
		++this.amount;
		list.add(voter);
	}

	public int getAmount() {
		return amount;
	}
	
	public String getNameVoter(){
		StringBuilder str = new StringBuilder();
		for (Voter voter : list) {
			str.append(voter.getLogin() + ", ");
		}
		return str.toString();
	}
	
	public String getName(){
		return name;
	}

}
