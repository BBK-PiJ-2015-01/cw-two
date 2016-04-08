package mastermind;

/**
* An implementation of the Colour and Tokeniser interfaces.
* 
* A Peg of a certain colour is an entity that is used for constructing a code
* to play the game with (The possibility exist to extend the game so that any
* other entity that can be modelled can be used such as shapes, playing cards etc.)
*
*@author Simon Baird & Johannes Neethling
*/

public class ColourPeg implements Colour, Tokeniser<Character> {

	private final String colour;

	/**
	 * Constructor
	 * 
	 * @param String: the name of the colour
	 * @throws IllegalArgumentException if the parameter is null or empty string
	 */
	public ColourPeg(String colour) {

		if (colour == null || colour.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.colour = colour;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public String getColour() {

		return colour;
	}

	/**
	* {@inheritDoc}
	*/
	@Override
	public Character getToken() {

		return colour.toUpperCase().charAt(0);
	}

	@Override
	public int hashCode() {

		final int prime = 31;
		int result = 1;
		result = prime * result + ((getToken() == null) ? 0 : getToken().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ColourPeg other = (ColourPeg) obj;
		if (getToken() == null) {
			if (other.getToken() != null)
				return false;
		} else if (!getToken().equals(other.getToken()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return getColour();
	}
}
