import java.util.Scanner;
import java.util.Map;

public class Atom<T> implements InterfaceFactory<T> {

    private static Scanner scanner = new Scanner(System.in);
    private T value;
    
    @Override
    public void execute(String exp) {
        String expression = exp.trim();
        if (expression.matches("\\(atom\\s+.+\\)")) {
            String innerExpression = expression.substring(6, expression.length() - 1).trim();
            if (isAtom(innerExpression)) {
                System.out.println("T");
            } else {
                System.out.println("NIL");
            }
        }
    }

    private boolean isAtom(String expression) {
        return !expression.contains(" ") && !expression.contains("(") && !expression.contains(")");
    }

}
