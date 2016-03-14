package mastermind;

import java.io.PrintStream;

public class GameOutputterImpl implements GameOutputter {

	private final PrintStream out;

	public GameOutputterImpl() {
		this(System.out);
	}

	public GameOutputterImpl(PrintStream ps) {

		out = ps;
	}

	@Override
	public void output(String message) {

		out.print(message);
	}

	@Override
	public void outputLine(String message) {

		out.println(message);
	}

	@Override
	public void outputGameState(GameState state) {
		// TODO Auto-generated method stub
		for (GameAttempt attempt : state.getGameHistory()) {
			outputLine(attempt.toString());
		}
	}

}
