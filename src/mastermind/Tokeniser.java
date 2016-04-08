package mastermind;

/**
* A tokeniser for an entity that is used for constructing a code.
* 
* A tokeniser for an entity that is used for constructing a code.
* (The possibility exist to extend the game so that any entity that
*  can be modelled can be used such as shapes, playing cards etc.)
*
*/

public interface Tokeniser<T> {

	/**
	* Get the token for the entity
	*
	* @return <T>: the token
	*/
	T getToken();
}
