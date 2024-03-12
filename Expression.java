import java.util.Stack;

public class Expression<T> {

    Stack<String> stack = new Stack<>();
    Factory<T> stackFactory = new Factory<>();

    /**Metodo para verificar que se inicie y finalize con parentecis la expresion
     * @param exp
     * @return
     */
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

    /**Metodo para identificar palabras reservadas, numeros y signos
     * @param exp
     */
    public void checkExpression(String exp) {
        String[] sign = {"+", "-", "*", "/"};
        boolean containsOperator = false; 
    
        // Verificar si la expresión empieza con algún operador
        for (String oper : sign) {
            if (exp.startsWith("(" + oper)) {
                containsOperator = true;
                break;
            }
        }
    
    
        // Si se encontró un operador, enviar la expresión al factory
        if (containsOperator) {
            InterfaceFactory<T> stackInterface = stackFactory.createStack("operation");
            stackInterface.execute(exp);
            return;
        }
    
        // Si no se encontró un operador, verificar palabras reservadas
        String[] expStr = {"setq", "defun", "list", "equal", "quote", "atom", "princ", "comparator","cond"};
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