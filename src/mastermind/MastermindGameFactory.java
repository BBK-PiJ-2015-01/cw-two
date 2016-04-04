package mastermind;

import java.util.HashSet;
import java.util.Set;

public class MastermindGameFactory implements GameDetailsFactory, GameInputterFactory {

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
