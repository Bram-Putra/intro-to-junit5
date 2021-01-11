package customerintake;

public enum PersonalTrainer {
	wei("Edy Yi Wei"),
	tyson("Mike Tyson"),
	grover("Tim S. Grover");
	
	private String name;
	
	private PersonalTrainer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
