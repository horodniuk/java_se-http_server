package lecture4_interface_enum.hometask.fraction;

public class Runner {
    public static void main(String[] args) {

        FractionNumber f1 = new FractionNumberImpl();
        System.out.println(f1 + "->" + f1.getValue());
        FractionNumber f2 = new FractionNumberImpl(1, 2);
        System.out.println(f2 + "->" + f2.getValue());
        FractionNumber f3 = new FractionNumberImpl(3, 4);
        System.out.println(f3 + "->" + f3.getValue());
        f3.setDividend(1);
        f3.setDivisor(3);
        System.out.println(f3 + "->" + f3.getValue());
        System.out.println(f3 + "->" + f3.getDividend() + "/" + f3.getDivisor());
        System.out.println(f2 + "+" + f3 + "=" + f2.add(f3));
        System.out.println(f2 + "-" + f3 + "=" + f2.sub(f3));
        System.out.println(f2 + "*" + f3 + "=" + f2.mul(f3));
        System.out.println(f2 + "/" + f3 + "=" + f2.div(f3));
  /*      FractionNumber n1 = new FractionNumberImpl(1, 2);
        FractionNumber n2 = new FractionNumberImpl();
        FractionNumber n3 = n1.div(n2);
        System.out.println(n3.getValue());*/
    }
}
