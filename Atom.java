public class Atom<T> implements InterfaceFactory<T> {

    private final SetQ<T> setQInstance;

    public Atom(SetQ<T> setQInstance) {
        this.setQInstance = setQInstance;
    }

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

    private boolean isAtom(String expression) {
        boolean isString = expression.matches("\".*\"");
        boolean isInteger = expression.matches("-?\\d+");
        return isString || isInteger;
    }
}
