import java.util.Stack;

/*
 * La clase {Expression} se encarga de analizar expresiones para verificar su correcta estructuración y 
 * clasificarlas según su tipo. Utiliza una pila para manejar la verificación de paréntesis y 
 * delega el procesamiento de la expresión a la clase {Factory}.*/
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
        // El patrón de comparación ajustado para detectar expresiones sin la palabra "comparator"
        String comparatorPattern = "^\\(\\s*(<|>)\\s+\\S+\\s+\\S+\\s*\\)$";
        boolean containsOperator = false;
    
        // Verificar si la expresión empieza con algún operador de signo
        for (String oper : sign) {
            if (exp.startsWith("(" + oper)) {
                containsOperator = true;
                break;
            }
        }
    
        // Si se encontró un operador, enviar la expresión al factory para operaciones
        if (containsOperator) {
            InterfaceFactory<T> stackInterface = stackFactory.createStack("operation");
            stackInterface.execute(exp);
            return;
        }
    
        // Verifica si la expresión concuerda con el patrón de un comparador
        if (exp.matches(comparatorPattern)) {
            InterfaceFactory<T> stackInterface = stackFactory.createStack("comparator");
            stackInterface.execute(exp);
            return;
        }
    
        // Lógica para manejar palabras reservadas o expresiones no reconocidas
        String[] reservedWords = {"setq", "defun", "list", "equal", "quote", "atom", "princ", "cond"};
        for (String word : reservedWords) {
            if (exp.indexOf(word + " ", 1) == 1) {
                InterfaceFactory<T> stackInterface = stackFactory.createStack(word);
                stackInterface.execute(exp);
                return;
            }
        }

        // Si no encontró una palabra reservada, que verifique si es el nombre de una funcion
        String functionName = exp.replaceAll("[()]", "").split(" ")[0];
        if (stackFactory.functionDefine(functionName)) {
            InterfaceFactory<T> stackInterface = stackFactory.createStack("callerFunction");
            stackInterface.execute(exp);
        } else {
            System.out.println("Comando no reconocido o función no definida.");
        }
    
    }    
}    