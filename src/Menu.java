import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {

	private Scanner sc = new Scanner(System.in);
	private List<Voter> voters;
	private List<Candidate> candidats;
	private Admin admin;

	private void printMenu() {
		System.out
				.print("========================= \nMenu: \n1.Voter \n2.Admin \n3.Exit \n4.Count \n========================\n");
	}

	private void printCandidates() {
		int c = 0;
		for (Candidate candidat : candidats) {

			System.out.println(c + " : " + candidat.getName());
			c++;
		}

	} // my comment

	private String validateVoter() {
		String name;

		while (true) {
			System.out.println("Enter your login");
			name = sc.next();
			boolean alreadyRegistered = false;
			for (Voter voter : voters) {
				if (voter.getLogin().equalsIgnoreCase(name)) {
					System.out.println("This name exist already");
					alreadyRegistered = true;
					break;
				}
			}

			if (!alreadyRegistered) {
				break;
			}
		}

		return name;
	}

	/**
	 * Method return valid int in range [0,max);
	 * 
	 * @param max
	 * @return
	 */
	private int getValidCandidates() {
		int max = candidats.size();
		while (true) {
			printCandidates();
			System.out.println("Enter candidate number");
			try {

				int num = sc.nextInt();
				if (num < max && num >= 0) {
					return num;
				} else {
					System.out.println("Enter correct number");
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter number");
				sc.next();
				continue;
			}

		}
	}

	//oxyienno pridumano!
	private void run() {
		candidats = new ArrayList<Candidate>();
		voters = new ArrayList<Voter>();
		admin = new Admin(candidats);

		String check = "1";
		while (check != "3") {
			printMenu();
			if (sc.hasNextInt()) {
				int c = sc.nextInt();
				switch (c) {
				case 1:
					String name = validateVoter();

					System.out.println("You successfully registered");
					Voter voter = new Voter(name);
					voters.add(voter);

					int num = getValidCandidates();
					candidats.get(num).add(voter);
					break;
				case 2:
					System.out.println("Enter a candidate");
					String nameCa = sc.next();
					admin.add(nameCa);
					break;
				case 3:
					System.out.println("You have successfully exit");
					System.exit(0);
					break;

				case 4:
					float total = 0;
					for (Candidate candidat : candidats) {
						total += candidat.getAmount();
					}

					for (Candidate candidat : candidats) {
						System.out.println(candidat.getName() + " : "
								+ candidat.getAmount() + " - "
								+ ((float)candidat.getAmount() / total * 100) + " %" + "\n for you vote:" + candidat.getNameVoter());
					}

					break;

				default:
					System.out.println("please enter only correct numbers");
					break;
				}

			} else {
				System.out.println("please enter only numbers");
				check = sc.next();
			}
		}
	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.run();
	}

}
