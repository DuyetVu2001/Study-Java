package ex2;

import java.math.BigInteger;

public class B14 {
    public static void main(String[] args) {
        BigInteger number1, number2;
        number1 = new BigInteger("99999999999999999999");
        number2 = new BigInteger("99999999999999999999");

        System.out.println("Tong: " + number1.add(number2));
        System.out.println("Hieu: " + number1.subtract(number2));
        System.out.println("Tich: " + number1.multiply(number2));
        System.out.println("Tich: " + number1.divide(number2));
    }
}
