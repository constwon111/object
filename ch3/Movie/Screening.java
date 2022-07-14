package ch3.Movie;
public class Screening{
    public Reservation reserve(Customer customer, int audienceCount){
        return new Reservation(customer, this, calculateFee(audienceCount),audienceCount);
    }


    private Money calculateFee(int audienceCount){
        return movie.calculateMovieFee(this).times(audienceCount);
    }

}