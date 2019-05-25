package pl.sda.spring.calculate.springcalculate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {

    private BiFunction<Double, Double, Double> add = (a, b) -> a + b;
    private BiFunction<Double, Double, Double> subtract = (a, b) -> a - b;
    private BiFunction<Double, Double, Double> divide = (a, b) -> a / b;
    private BiFunction<Double, Double, Double> multiply = (a, b) -> a * b;
    private Map<String, BiFunction<Double, Double, Double>> functionMap = mapBuilding();

    private Map<String, BiFunction<Double, Double, Double>> mapBuilding() {
        Map<String, BiFunction<Double, Double, Double>> result = new HashMap<>();
        result.put("+", add);
        result.put("-", subtract);
        result.put("/", divide);
        result.put("*", multiply);
        return result;
    }

    public Double add2(String input) {
        Pattern pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Double firstValue = Double.valueOf(matcher.group(1));
            String sign = matcher.group(2).trim();
            Double secondValue = Double.valueOf(matcher.group(3));
            return functionMap.get(sign).apply(firstValue, secondValue);
        }
        return null;
    }

    public Double add(String input) {
        Pattern pattern = Pattern.compile("(\\d+)(\\D+)(\\d+)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.matches()) {
            Double firstValue = Double.valueOf(matcher.group(1));
            String sign = matcher.group(2).trim();
            Double secondValue = Double.valueOf(matcher.group(3));

            switch (sign) {
                case "+":
                    return firstValue + secondValue;
                case "-":
                    return firstValue - secondValue;
                case "*":
                    return firstValue * secondValue;
                case "/":
                    return firstValue / secondValue;
            }
        }

        return null;
    }


}
