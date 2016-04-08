package mastermind;

import java.io.PrintStream;

/**
* Implementation of the  GameOutputter interface.
* 
* An GameOutputter displays output to System.out
*
*@author Simon Baird & Johannes Neethling
*/

public class GameOutputterImpl implements GameOutputter {

	private final PrintStream out;

	public GameOutputterImpl() {
		this(System.out);
	}

	public GameOutputterImpl(PrintStream ps) {

		out = ps;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void output(String message) {

		out.print(message);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputLine(String message) {

		out.println(message);
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public void outputGameState(GameState state) {
		// TODO Auto-generated method stub
		for (GameAttempt attempt : state.getGameHistory()) {
			outputLine(attempt.toString());
		}
	}

}
