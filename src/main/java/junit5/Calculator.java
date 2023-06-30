package junit5;

public class Calculator {
    private int result;

    public int add(int n1, int n2) {
        result = n1 + n2;
        return  result;
    }
    public int substract (int n1, int n2 ) {
        result = n1 - n2;
        return result;
    }

    public int divideByZero(int n1, int n2) {
        if(n2==0){
            throw new ArithmeticException("No se puede dividir entre cero");
        }
        result = n1 / n2;
        return  result;
    }
    /*public void LongTaskOperation(){
        try{
            Thread.sleep(1000);
        }catch ((Exception e)){

        }
    }*/

}
