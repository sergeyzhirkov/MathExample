package ru.zhirkov.math;

public class MathLibraryExample {

    public static long toLongExact(double x) {
        if (Double.isNaN(x) || Double.isInfinite(x)) {
            throw new ArithmeticException("error: cannot correct cast double to long");
        }
        String binaryString = Long.toBinaryString(Double.doubleToLongBits(x));
        if ("0".equals(binaryString)) {
            return 0;
        }
        if (binaryString.length() <= 52) {
            throw new ArithmeticException("error: exp <= -1023");
        }
        String exponentBinaryString = binaryString.substring(x < 0 ? 1 : 0, binaryString.length() - 52);
        String mantissaBinaryString = binaryString.substring(binaryString.length() - 52);
        int exponent = Integer.parseInt(exponentBinaryString, 2) - Double.MAX_EXPONENT;
        if (exponent < 0) {
            throw new ArithmeticException("error: |x| < 1");
        }
        if (exponent < 52 && mantissaBinaryString.substring(exponent).contains("1")) {
            throw new ArithmeticException("error: |x| > 1, but  x - fractional number");
        }
        if (!(exponent == 63 && x < 0 && !mantissaBinaryString.contains("1")) && (exponent > 62)) {
            throw new ArithmeticException("error: x >> max (or  x << min) value of long");
        }
        return (long) x;
    }

    public static double toDoubleExact(long x) {
        String binaryString = Long.toBinaryString(Math.abs(x));
        if (binaryString.lastIndexOf("1") > 52) {
            throw new ArithmeticException("error: cannot correct cast long to double");
        }
        return (double) x;
    }


}
