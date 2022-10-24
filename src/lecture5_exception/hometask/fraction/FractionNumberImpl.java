package lecture5_exception.hometask.fraction;

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

    @Override
    public FractionNumber div(FractionNumber secondArgument) {
        if (secondArgument.getDividend() == 0) {
            try {
                throw new InvalidFractionNumberArgumentException("secondArgument is 0. / by zero");
            } catch (InvalidFractionNumberArgumentException e) {
                e.printStackTrace();
            }
        } else {
            return new FractionNumberImpl(this.getDividend() * secondArgument.getDivisor(), this.getDivisor() * secondArgument.getDividend());
        }
        return null;
    }

}
