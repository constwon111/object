package ch3.Movie;
public class NoneDiscountPolicy extends DiscountPolicy {
    @Override
    protected Money getDiscountAmount(Screening screening){
        return Money.ZERO;
    }
    
}
