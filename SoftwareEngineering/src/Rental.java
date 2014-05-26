class Rental {
	private Movie _movie;
	private int _daysRented;
	public Rental(Movie newmovie, int newdaysRented) {
		_movie = newmovie;
		_daysRented = newdaysRented;
	}
	public int getDaysRented() {
		return _daysRented;
	}
	public Movie getMovie() {
		return _movie;
	}

	/*
	 * Move Method
	double getCharge() { 
		double result = 0; 
		switch (getMovie().getPriceCode()) { 
		case Movie.REGULAR: 
			result += 2; 
			if (getDaysRented() > 2) 
				result += (getDaysRented() - 2) * 1.5; 
			break; 
		case Movie.NEW_RELEASE: 
			result += getDaysRented() * 3; 
			break; 
		case Movie.CHILDRENS: 
			result += 1.5; 
			if (getDaysRented() > 3) 
				result += (getDaysRented() - 3) * 1.5; 
			break; 
		} 
		return result; 
	}
	 */

	double getCharge() { 
		return _movie.getCharge(_daysRented); 
	} 

	/*
	 * Move Method
	int getFrequentRenterPoints() { 
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
				getDaysRented() > 1) 
			return 2; 
		else 
			return 1; 
	} 
	 */

	int getFrequentRenterPoints() { 
		return _movie.getFrequentRenterPoints(_daysRented); 
	} 
}