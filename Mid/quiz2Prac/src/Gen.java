public class Gen <T extends Number> {

    T[] ob1;

    Gen(T[] o1) {
        ob1 = o1;
    }

    double avg() {
        double sum = 0.0;
        int size = ob1.length;
        for (T t : ob1) {
            sum += t.doubleValue();
        }
        return sum/size;
    }

    boolean isSame(Gen<?> ob3) {
        return avg() == ob3.avg();
    }
}