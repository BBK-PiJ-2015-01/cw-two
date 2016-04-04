package mastermind;

public interface GameDetailsFactory {

	GameInstanceImpl getGameInstance(String gameType);
}
