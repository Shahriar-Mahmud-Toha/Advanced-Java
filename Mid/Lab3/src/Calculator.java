public class Calculator<T extends Number, R extends Number> {
    T num1;
    R num2;
    Calculator(T num1, R num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public void sum(){
        System.out.println((num1.doubleValue()+num2.doubleValue()));
    }
    public void sub(){
        System.out.println((num1.doubleValue()-num2.doubleValue()));
    }
    public void mul(){
        System.out.println((num1.doubleValue()*num2.doubleValue()));
    }
    public void div(){
        System.out.println((num1.doubleValue()/num2.doubleValue()));
    }
}
