
import java.lang.*;
import java.util.*;

class Customer {
	private String _name;
	private Vector _rentals = new Vector();
	public Customer (String newname){
		_name = newname;
	};
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	};
	public String getName (){
		return _name;
	};

	/*
	 * Extract Method
    public String statement() {
        double totalAmount = 0;
        int frequentRenterPoints = 0;
        Enumeration enum_rentals = _rentals.elements();	    
        String result = "Rental Record for " + this.getName() + "\n";
        result += "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (enum_rentals.hasMoreElements()) {
            double thisAmount = 0;
            Rental each = (Rental) enum_rentals.nextElement();
            //determine amounts for each line
            switch (each.getMovie().getPriceCode()) {
                case Movie.REGULAR:
                	thisAmount += 2;
                	if (each.getDaysRented() > 2)
                    	thisAmount += (each.getDaysRented() - 2) * 1.5;
                	break;
                case Movie.NEW_RELEASE:
                	thisAmount += each.getDaysRented() * 3;
                	break;
                case Movie.CHILDRENS:
                	thisAmount += 1.5;
                	if (each.getDaysRented() > 3)
                    	thisAmount += (each.getDaysRented() - 3) * 1.5;
                	break;
            }
            // add frequent renter points
            frequentRenterPoints ++;
            // add bonus for a two day new release rental
            if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1) 
                frequentRenterPoints ++;
            //show figures for this rental
            result += "\t" + each.getMovie().getTitle()+ "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(thisAmount) + "\n";
            totalAmount += thisAmount;
        }
        //add footer lines
        result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
        result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points";
        return result;
    }
	 */


	/*
	 * Move Method
    public String statement() { 
    	 double totalAmount = 0; 
    	 int frequentRenterPoints = 0; 
    	 Enumeration rentals = _rentals.elements(); 
    	 String result = "Rental Record for " + getName() + "\n"; 
    	 while (rentals.hasMoreElements()) { 
	    	 double thisAmount = 0; 
	    	 Rental each = (Rental) rentals.nextElement(); 

	    	 thisAmount = amountFor(each); 

	    	 // add frequent renter points 
	    	 frequentRenterPoints ++; 
	    	 // add bonus for a two day new release rental 
	    	 if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && 
	    	 each.getDaysRented() > 1) frequentRenterPoints ++; 

	    	 //show figures for this rental 
	    	 result += "\t" + each.getMovie().getTitle()+ "\t" + 
	    			 String.valueOf(thisAmount) + "\n"; 
	    			 totalAmount += thisAmount; 

    	 } 
    	 //add footer lines 
    	 result += "Amount owed is " + String.valueOf(totalAmount) + "\n"; 
    	 result += "You earned " + String.valueOf(frequentRenterPoints) + " frequent renter points"; 
    	 return result; 
    }

	private double amountFor(Rental aRental) { 
		double result = 0; 
		switch (aRental.getMovie().getPriceCode()) { 
		case Movie.REGULAR: 
			result += 2; 
			if (aRental.getDaysRented() > 2) 
				result += (aRental.getDaysRented() - 2) * 1.5; 
			break; 
		case Movie.NEW_RELEASE: 
			result += aRental.getDaysRented() * 3; 
			break; 
		case Movie.CHILDRENS: 
			result += 1.5; 
			if (aRental.getDaysRented() > 3) 
				result += (aRental.getDaysRented() - 3) * 1.5; 
			break; 
		} 
		return result; 
	} 
	 */

	/*
	 * Extract Method 
	public String statement() { 
		double totalAmount = 0; 
		int frequentRenterPoints = 0; 
		Enumeration rentals = _rentals.elements(); 
		String result = "Rental Record for " + getName() + "\n"; 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement(); 

			// add frequent renter points 
			frequentRenterPoints ++; 
			// add bonus for a two day new release rental 
			if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) 
					&& 
					each.getDaysRented() > 1) frequentRenterPoints ++; 
			//show figures for this rental 
			result += "\t" + each.getMovie().getTitle()+ "\t" + 
					String.valueOf 
					(each.getCharge()) + "\n"; 
			totalAmount += each.getCharge(); 

		} 
		//add footer lines 
		result += "Amount owed is " + String.valueOf(totalAmount) + 
				"\n"; 
		result += "You earned " + String.valueOf(frequentRenterPoints) 
				+ " frequent renter points"; 
		return result; 

	}
	 */

	/*
	 * Replace Temp with Query
	public String statement() { 
		double totalAmount = 0; 
		int frequentRenterPoints = 0; 
		Enumeration rentals = _rentals.elements(); 
		String result = "Rental Record for " + getName() + "\n"; 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement(); 
			frequentRenterPoints += each.getFrequentRenterPoints(); 

			//show figures for this rental 
			result += "\t" + each.getMovie().getTitle()+ "\t" + 
					String.valueOf(each.getCharge()) + "\n"; 
			totalAmount += each.getCharge(); 
		} 

		//add footer lines 
		result += "Amount owed is " + String.valueOf(totalAmount) + 
				"\n"; 
		result += "You earned " + String.valueOf(frequentRenterPoints) 
				+ 
				" frequent renter points"; 
		return result; 
	} 
	 */

	public String statement() { 
		Enumeration rentals = _rentals.elements(); 
		String result = "Rental Record for " + getName() + "\n"; 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement(); 

			//show figures for this rental 
			result += "\t" + each.getMovie().getTitle()+ "\t" + 
					String.valueOf(each.getCharge()) + "\n"; 
		} 

		//add footer lines 
		result += "Amount owed is " + 
				String.valueOf(getTotalCharge()) + "\n"; 
		result += "You earned " + 
				String.valueOf(getTotalFrequentRenterPoints()) + 
				" frequent renter points"; 
		return result; 
	} 

	private int getTotalFrequentRenterPoints(){ 
		int result = 0; 
		Enumeration rentals = _rentals.elements(); 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement(); 
			result += each.getFrequentRenterPoints(); 
		} 
		return result; 
	}

	private double getTotalCharge() { 
		double result = 0; 
		Enumeration rentals = _rentals.elements(); 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement(); 
			result += each.getCharge(); 
		} 
		return result; 
	} 

	public String htmlStatement() { 
		Enumeration rentals = _rentals.elements(); 
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n"; 
		while (rentals.hasMoreElements()) { 
			Rental each = (Rental) rentals.nextElement();
			//show figures for each rental 
			result += each.getMovie().getTitle()+ ": " + 
					String.valueOf(each.getCharge()) + "<BR>\n"; 
		} 
		//add footer lines 
		result += "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + 
				"</EM><P>\n"; 
		result += "On this rental you earned <EM>" + 
				String.valueOf(getTotalFrequentRenterPoints()) + 
				"</EM> frequent renter points<P>"; 
		return result; 
	}

}
