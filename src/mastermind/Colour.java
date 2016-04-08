package mastermind;

/**
* A Peg of a certain colour is an entity that is used for constructing a code.
* 
* A Peg of a certain colour is an entity that is used for constructing a code
* to play the game with (The possibility exist to extend the game so that any
* other entity that can be modelled can be used such as shapes, playing cards etc.)
*
*/

public interface Colour {
	
	/**
	* Get the name of the colour
	*
	* @return String: the colour
	*/
	String getColour();
}
