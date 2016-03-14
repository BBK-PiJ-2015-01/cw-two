package mastermind;

public interface GameInputter {
	
    GameAttempt readAttempt(); 
    
    GameCommand getCommand();
 
    String getMessage(); 
}
