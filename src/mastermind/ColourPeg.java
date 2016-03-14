package mastermind;

public class ColourPeg implements Colour, Tokeniser<Character> {
	
	 private final String colour;
	
	 public ColourPeg(String colour){
		 
		 if (colour == null || colour.isEmpty()) {
			 throw new IllegalArgumentException();
		 }
		 this.colour = colour;
	 }
	

	@Override
	public String getColour() {

		return colour;
	}

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
}
