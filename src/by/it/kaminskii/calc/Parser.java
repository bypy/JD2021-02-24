package by.it.kaminskii.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {


    public static Map<String, Integer> getPriorityMap() {
        return priorityMap;
    }

    private static final Map<String, Integer> priorityMap = new HashMap<>() {
        {
            this.put("=", 0);
            this.put("+", 1);
            this.put("-", 1);
            this.put("*", 2);
            this.put("/", 2);
        }
    };

    public Var calc(String expression) throws CalcExeption {
        //a=2+2*2-9
        expression = expression.replaceAll("\\s", "");

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));

        Pattern patternCalc = Pattern.compile(Patterns.OPERATION);
        Matcher matcherCalc = patternCalc.matcher(expression);
        List<String> operations = new ArrayList<>();
        while (matcherCalc.find()) {
            operations.add(matcherCalc.group());
        }
        while (operations.size() > 0) {
            int index = getIndex(operations);
            String left = operands.remove(index);
            String right = operands.remove(index);
            String operation = operations.remove(index);
            Var result = calcOneOperation(left, operation, right);
            operands.add(index, result.toString());
        }
        return Var.creatVar(operands.get(0));
    }

    private int getIndex(List<String> operations) {
        int index = -1;
        int prior = -1;
        for (int i = 0, operationsSize = operations.size(); i < operationsSize; i++) {
            String operation = operations.get(i);
            if (prior < priorityMap.get(operation)) {
                index = i;
                prior = priorityMap.get(operation);
            }
        }
        return index;
    }

    private Var calcOneOperation(String leftStr, String operationStr, String rightStr) throws CalcExeption {
        Var right = Var.creatVar(rightStr);
        if (operationStr.equals("=")) {
            return Var.saveVar(leftStr, right);
        }
        Var left = Var.creatVar(leftStr);
        switch (operationStr) {
            case "+":
                return left.add(right);
            case "-":
                return left.sub(right);
            case "*":
                return left.mul(right);
            case "/":
                return left.div(right);
        }
        throw new CalcExeption("Неизвествное значение");
    }
}

