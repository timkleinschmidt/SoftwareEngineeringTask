class Rental {
    private Movie _movie;
    private int daysRented;
    public Rental(Movie newmovie, int newdaysRented) {
        _movie = newmovie;
        daysRented = newdaysRented;
    }
    public int getDaysRented() {
        return daysRented;
    }
    public Movie getMovie() {
        return _movie;
    }

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
}