package by.it.runcov.jd01_13;

import java.util.Scanner;

import static java.lang.Math.sqrt;

public class TaskB {
    public static void main(String[] args) {
        double sum = 0.0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String word = scanner.next();
            if (word.equals("END")) {
                break;
            }
            try {
                double words = Double.parseDouble(word);
                System.out.println(words);
                sum += words;
                if (sum < 0) {
                    throw new ArithmeticException();
                }
                double afterSqrt = sqrt(sum);
                System.out.println(afterSqrt);
            } catch (NumberFormatException | ArithmeticException e) {
                Class<? extends RuntimeException> exceptionStructure = e.getClass();
                String nameExceptionClass = exceptionStructure.getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                Class<TaskB> runnerStructure = TaskB.class;
                String nameRunnerClass = runnerStructure.getName();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    String classNameInStackTrace = stackTraceElement.getClassName();
                    if (classNameInStackTrace.equals(nameRunnerClass)) {
                        int lineNumber = stackTraceElement.getLineNumber();
                        System.out.printf("" +
                                        "name: %s\n" +
                                        "class: %s\n" +
                                        "line: %s\n",
                                nameExceptionClass, classNameInStackTrace, lineNumber);
                    }
                }
                break;
            }
        }
    }
}
