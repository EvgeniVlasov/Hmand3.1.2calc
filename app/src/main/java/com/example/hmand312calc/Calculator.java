package com.example.hmand312calc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Calculator {

    Deque<Character> viewResult = new ArrayDeque<>();
    Deque<Double> number = new ArrayDeque<>();

    Action actionNow = Action.EMPTY;

    String getDigit(char digit) {
        if (digit == '.') {
            if (viewResult.contains('.')) return dequeToString(viewResult);
            if (viewResult.isEmpty()) {
                viewResult.add('0');
                viewResult.add('.');
                return dequeToString(viewResult);
            }
        }
        if (viewResult.size() < 6) viewResult.add(digit);
        return dequeToString(viewResult);
    }

    public String dequeToString(Deque<Character> deque) {
        StringBuilder sb = new StringBuilder(deque.size());
        deque.forEach(sb::append);
        return sb.toString();
    }

    public void setNum(double num) {
        number.add(num);
        viewResult.clear();
        if (number.size() > 2) number.removeFirst();


    }


    public double getNum() {
        if (viewResult.isEmpty()) return 0;
        return Double.parseDouble(dequeToString(viewResult));
    }

    String getAction(Action action) {
        switch (action) {
            case C:
                viewResult.clear();
                actionNow = Action.EMPTY;
                return "0";
            case DIV:
                setNum(getNum());
                actionNow = Action.DIV;
                break;
            case PER:
                setNum(getNum());
                actionNow = Action.PER;
                break;
            case MUL:
                setNum(getNum());
                actionNow = Action.MUL;
                break;
            case MIN:
                setNum(getNum());
                actionNow = Action.MIN;
                break;
            case PLUS:
                setNum(getNum());
                actionNow = Action.PLUS;
                break;
            case SING:
                if (viewResult.isEmpty()) break;
                if (viewResult.getFirst().equals('-')) viewResult.removeFirst();
                else {
                    if (viewResult.size() >= 6) break;
                    viewResult.addFirst('-');
                }
            case EQUAL:
                if (actionNow == actionNow.EMPTY) break;
                setNum(getNum());
                getActionResult();
                actionNow = Action.EMPTY;
                break;

        }
        if (viewResult.isEmpty()) return "0";
        return dequeToString(viewResult);


    }


    public double getActionResult() {
        double result = 0;
        switch (actionNow) {
            case PLUS:
                result = number.getFirst() + number.getLast();
                break;
            case MIN:
                result = number.getFirst() - number.getLast();
                break;
            case MUL:
                result = number.getFirst() * number.getLast();
                break;
            case DIV:
                result = number.getFirst() / number.getLast();
                break;
            case PER:
                result = number.getFirst() / 100;
                break;
            case EMPTY:
                break;
        }
        String textResult = String.format("%.0f", result);
        viewResult.clear();
        for (int i = 0; i < textResult.toCharArray().length; i++) {
            viewResult.add(textResult.toCharArray()[i]);
        }
        return result;
    }

}

