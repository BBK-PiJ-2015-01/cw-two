package mastermind;

public enum GameCommand implements Tokeniser<String> {

	NEW_GAME("N", "New game"), EXIT("X", "Exit"), RESTART("R", "Restart this game");

	private final String command;
	private final String description;

	GameCommand(String command, String description) {
		this.command = command;
		this.description = description;
	}

	@Override
	public String getToken() {

		return ":" + command;
	}
	
	@Override
	public String toString() {
		
		return description;
	}
}
