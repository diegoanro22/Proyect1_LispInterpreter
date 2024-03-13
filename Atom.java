/*La clase {Atom} es una implementación diseñada para evaluar expresiones y determinar
si son "átomos" según una definición específica.*/
public class Atom<T> implements InterfaceFactory<T> {

    // Instancia de {SetQ} que almacena el conjunto de variables y sus valores asociados.
    private final SetQ<T> setQInstance;

    /*Construye una nueva instancia de {Atom} con una instancia específica de {SetQ} 
    que se utilizará para la evaluación de expresiones. */
    public Atom(SetQ<T> setQInstance) {
        this.setQInstance = setQInstance;
    }

    /* Evalúa una expresión dada para determinar si es un átomo. Imprime "T" si la expresión es un átomo,
    o "NIL" en caso contrario. La evaluación considera variables definidas en {setQInstance}.*/
    @Override
    public void execute(String exp) {
        String expression = exp.trim();
        if (expression.matches("\\(atom\\s+.+\\)")) {
            String innerExpression = expression.substring(6, expression.length() - 1).trim(); 
            if (setQInstance.variableValues.containsKey(innerExpression)) {
                System.out.println("T");
            } else {
                if (isAtom(innerExpression)) {
                    System.out.println("T");
                } else {
                    System.out.println("NIL");
                }
            }
        }
    }

    //Determina si una expresión dada es un átomo basándose en si es una cadena de texto o un número entero.
    private boolean isAtom(String expression) {
        boolean isString = expression.matches("\".*\"");
        boolean isInteger = expression.matches("-?\\d+");
        return isString || isInteger;
    }
}