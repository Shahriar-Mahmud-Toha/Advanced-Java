public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Calculator<Integer, Double> c = new Calculator<Integer, Double>(10,20.0);
        c.sum();
        c.sub();
        c.mul();
        c.div();

    }

}