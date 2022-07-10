package ru.zhirkov.math;

public class Tests {

    // tests without junit or other external libraries

    public static void testToLongExact(double x) {
        try {
            System.out.println(MathLibraryExample.toLongExact(x));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void testToDoubleExact(long x) {
        try {
            System.out.println(MathLibraryExample.toDoubleExact(x));
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        testToLongExact(0.0);
        testToLongExact(-0.0);
        testToLongExact(Double.NaN);
        testToLongExact(Double.POSITIVE_INFINITY);
        testToLongExact(Double.NEGATIVE_INFINITY);
        testToLongExact(0x1p63);
        testToLongExact(-0x1p63);

        testToDoubleExact(0L);
        testToDoubleExact(Long.MAX_VALUE);
        testToDoubleExact(Long.MIN_VALUE);
        testToDoubleExact(1L << 53);
        testToDoubleExact((1L << 53) + 1);
        testToDoubleExact((1L << 53) + 2);

//        toLongExact(0.0) ---> ok
//        toLongExact(-0.0) ---> error
//        toLongExact(Double.NaN) ---> error
//        toLongExact(Double.POSITIVE_INFINITY) ---> error
//        toLongExact(Double.NEGATIVE_INFINITY) ---> error
//        toLongExact(0x1p63) ---> error
//        toLongExact(-0x1p63) ---> ok
//
//        toDoubleExact(0L) ---> ok
//        toDoubleExact() ---> error
//        toDoubleExact(Long.MIN_VALUE) ---> ok
//        toDoubleExact(1L << 53) ---> ok
//        toDoubleExact((1L << 53) + 1) ---> error
//        toDoubleExact((1L << 53) + 2) ---> ok
    }
}
