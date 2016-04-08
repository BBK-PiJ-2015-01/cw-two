package mastermind;

import java.util.HashSet;
import java.util.Set;

/**
* Implementation for the GameDetailsFactory & GameInputterFactory interfaces.
* 
* A MastermindGameFactory produces an instance of the game with a certain configuration,
* sets the type of entities to be used (default is some colours in this impl, but this can be
* extended) and also produces a inputter object.
*
*@author Simon Baird & Johannes Neethling
*/

public class MastermindGameFactory implements GameDetailsFactory, GameInputterFactory {

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameInstanceImpl getGameInstance(String gameType) {
		// TODO Auto-generated method stub

		GameDetails details;
		switch (gameType) {
		case "hardColours":
			details = new GameDetailsImpl(12L, 6L, getStandardColours());
			return new GameInstanceImpl(details);
		case "simpleColours":
		default:
			details = new GameDetailsImpl(12L, 4L, getStandardColours());
			return new GameInstanceImpl(details);
		}

	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public GameInputter getGameInputter(String gameType) {

		switch (gameType) {
		case "hardColours":
		case "simpleColours":
		default:
			GameInputterImpl inputter = new GameInputterImpl();
			inputter.setGameValues(getStandardColours());
			return inputter;
		}
	}

	private Set<Tokeniser<Character>> getStandardColours() {

		Set<Tokeniser<Character>> returnMap = new HashSet<>();
		returnMap.add(new ColourPeg("Green"));
		returnMap.add(new ColourPeg("Blue"));
		returnMap.add(new ColourPeg("Red"));
		returnMap.add(new ColourPeg("Yellow"));
		returnMap.add(new ColourPeg("Purple"));
		returnMap.add(new ColourPeg("Orange"));
		return returnMap;
	}

}
