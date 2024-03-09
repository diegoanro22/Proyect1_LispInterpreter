import java.util.Map;
import java.util.Stack;

public class Expression<T> {

    Stack<String> stack = new Stack<>();
    Factory<T> stackFactory = new Factory<>();

    public boolean checkParen(String exp) {
        stack.clear();
        String[] expStr = exp.split("");

        if (!expStr[0].equals("(")) {
            throw new IllegalArgumentException("Error, debe empezar con un '('");
        }
        if (!expStr[expStr.length - 1].equals(")")) {
            throw new IllegalArgumentException("Error, debe terminar con un ')'");
        }

        for (String character : expStr) {
            if (character.equals("(")) {
                stack.push(character);
            }
            if (character.equals(")")) {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException("Error de paréntesis, se cierra de más");
                } else {
                    stack.pop();
                }
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException("Error de paréntesis, no se cerró signo");
        } else {
            return true;
        }
    }

    public void checkExpression(String exp) {
        String[] expStr = {"setq", "defun", "list", "equal", "quote", "atom", "princ"};

        for (String reservedWord : expStr) {
            if (exp.indexOf(reservedWord + " ", 1) == 1) {
                InterfaceFactory<T> stackInterface = stackFactory.createStack(reservedWord);
                stackInterface.execute(exp);
                return;
            }
        }
        System.out.println("Comando no reconocido.");
    }
}
