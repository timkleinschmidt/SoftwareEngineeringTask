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
}