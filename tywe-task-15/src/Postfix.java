import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * The Postfix class implements an evaluator for integer postfix expressions.
 * <p>
 * Postfix notation is a simple way to define and write arithmetic expressions
 * without the need for parentheses or priority rules. For example, the postfix
 * expression "1 2 - 3 4 + *" corresponds to the ordinary infix expression
 * "(1 - 2) * (3 + 4)". The expressions may contain decimal 32-bit integer
 * operands and the four operators +, -, *, and /. Operators and operands must
 * be separated by whitespace .
 *
 * @author Tomas
 * @version 2021-02-04
 */
public class Postfix {
    public static class ExpressionException extends Exception {
        public ExpressionException(String message) {
            super(message);
        }
    }

    /**
     * Evaluates the given postfix expression.
     *
     * @param expr Arithmetic expression in postfix notation
     * @return The value of the evaluated expression
     * @throws ExpressionException if the expression is wrong
     */
    public static int evaluate(String expr) throws ExpressionException {
        // TODO
        if (expr.equals("")) {
            throw new ExpressionException("Is empty");
        }

        String[] newExpr = expr.split("\\s+");
        Stack<Integer> operandStack = new LinkedList<>();

        for (String expressions : newExpr) {
            if (expressions.matches("-?0+\\d+")) {
                throw new ExpressionException("wrong expression");
            }
            if (isInteger(expressions)) {
                operandStack.push(Integer.parseInt(expressions));
            } else if (isOperator(expressions)) {
                try {
                    int oldTop = operandStack.pop();
                    int newTop = operandStack.pop();
                    if (expressions.equals("+")) {
                        operandStack.push(oldTop + newTop);
                    } else if (expressions.equals("-")) {
                        operandStack.push(newTop - oldTop);
                    } else if (expressions.equals("*")) {
                        operandStack.push(oldTop * newTop);
                    } else if (expressions.equals("/")) {
                        operandStack.push(newTop / oldTop);
                    }
                } catch (Exception e) {
                    throw new ExpressionException("operator fel!");
                }
            } else if (expressions.equals("")) {

            } else {
                throw new ExpressionException("wrong character!");
            }

        }
        if (operandStack.size() == 1) {
            return operandStack.pop();
        } else {
            throw new ExpressionException("the whole method");
        }
    }

    /**
     * Returns true if s is an operator.
     * <p>
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     * <p>
     * An operator is one of '+', '-', '*', '/'.
     */
    private static boolean isOperator(String s) {
        // TODO
        Pattern p = Pattern.compile("[-*+/]");
        Matcher m = p.matcher(s);
        return m.matches();
//        String operatorRegex = "[-+*/]";
//        if (s.matches(operatorRegex)) {
//            return true;
//        }
//        return false;
    }

    /**
     * Returns true if s is an integer.
     * <p>
     * A word of caution on using the String.matches method: it returns true
     * if and only if the whole given string matches the regex. Therefore
     * using the regex "[0-9]" is equivalent to "^[0-9]$".
     * <p>
     * We accept two types of integers:
     * <p>
     * - the first type consists of an optional '-'
     * followed by a non-zero digit
     * followed by zero or more digits,
     * <p>
     * - the second type consists of an optional '-'
     * followed by a single '0'.
     */
    private static boolean isInteger(String s) {
        // TODO
        Pattern p = Pattern.compile("-?\\d+");
        Matcher m = p.matcher(s);
        return m.matches();
//        String integerRegex = "-?\\d+";
//        if (s.matches(integerRegex)) {
//            return true;
//        }
//        return false;
    }

    public static void main(String[] args) {
        String s = "5 0  + - *";
        try {
            System.out.println(evaluate(s));
        } catch (ExpressionException e) {
            e.printStackTrace();
        }

    }
}
