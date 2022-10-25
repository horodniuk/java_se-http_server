package lecture5_exception.lecture.fraction;

import lecture4_interface_enum.hometask.fraction.InvalidFractionNumberArgumentException;

public class FractionNumberImpl implements FractionNumber {
    private int dividend;
    private int divisor;

    public FractionNumberImpl(int divident, int divisor) {
        this.dividend = divident;
        this.divisor = divisor;
    }

    public FractionNumberImpl() {
        divisor  = DEFAULT_DIVISOR;
    }

    @Override
    public int getDividend() {
        return dividend;
    }
    @Override
    public void setDividend(int dividend) {
        this.dividend = dividend;
    }

    @Override
    public int getDivisor() {
        return divisor;
    }


    @Override
    public void setDivisor(int divisor) {
        if (divisor != 0) {
            this.divisor = divisor;
        } else {
            System.out.println("Invalid divisor");
        }
    }

    @Override
    public double getValue() {
        return ((double) dividend / divisor);
    }

    @Override
    public String toString() {
        return dividend == 0 ? "0" : dividend + "/" + divisor;
    }

    @Override
    public FractionNumber add(FractionNumber secondArgument) {
        int divident = this.getDividend() * secondArgument.getDivisor() + secondArgument.getDividend() * this.getDivisor();
        int divisor = this.getDivisor() * secondArgument.getDivisor();
        return new FractionNumberImpl(divident, divisor);
    }

    @Override
    public FractionNumber sub(FractionNumber secondArgument) {
        int divident = this.getDividend() * secondArgument.getDivisor() - secondArgument.getDividend() * this.getDivisor();
        int divisor = this.getDivisor() * secondArgument.getDivisor();
        return new FractionNumberImpl(divident, divisor);
    }

    @Override
    public FractionNumber mul(FractionNumber secondArgument) {
        return new FractionNumberImpl(this.getDividend() * secondArgument.getDividend(),
                this.getDivisor() * secondArgument.getDivisor());
    }

    public FractionNumber div(FractionNumber secondArgument) {
        if (secondArgument.getDividend() == 0) {
            throw new InvalidFractionNumberArgumentException("secondArgument is 0. / by zero");
        } else {
            return new FractionNumberImpl(this.getDividend() * secondArgument.getDivisor(),
                    this.getDivisor() * secondArgument.getDividend());
        }
    }

}
