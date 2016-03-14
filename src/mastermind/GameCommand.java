package mastermind;

public enum GameCommand implements Tokeniser<String> {

	NEW_GAME("N"), EXIT("X"), RESTART("R");

	private final String command;

	GameCommand(String command) {
		this.command = command;
	}

	@Override
	public String getToken() {

		return ":" + command;
	}
}
