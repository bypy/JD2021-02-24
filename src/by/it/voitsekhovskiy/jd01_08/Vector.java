package by.it.voitsekhovskiy.jd01_08;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Vector extends Var {
    private final double[] value;

    Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    Vector(Vector otherVector) {
        this(otherVector.value); // вызов конструктора Vector(double[])
    }

    Vector(String strVector) {
        StringBuilder newStr = new StringBuilder(strVector);
        Pattern pattern = Pattern.compile("[{}]");
        Matcher matcher = pattern.matcher(newStr);
        while(matcher.find()) {
            int start = matcher.start();
            newStr.deleteCharAt(start);
            matcher.reset();
        }

        String[] arrayFromString = newStr.toString().split(",");
        double[] doubleArray = new double[arrayFromString.length];
        for (int i = 0; i < arrayFromString.length; i++) {
            doubleArray[i] = Double.parseDouble(arrayFromString[i]);
        }
        this.value = doubleArray;
    }

    @Override
    public String toString() {
        StringBuilder resultString = new StringBuilder();
        resultString.append("{");
        for (int i = 0; i < value.length; i++) {
            resultString.append(value[i]);
            if (i != value.length - 1) {
                resultString.append(", ");
            }
        }
        resultString.append("}");
        return resultString.toString();
    }
}
