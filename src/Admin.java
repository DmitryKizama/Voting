import java.util.List;
import java.util.Scanner;

public class Admin {
	private List<Candidate> candidateList;

	public Admin(List<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public void add(String name) {
		candidateList.add(new Candidate(name));
	}
}
