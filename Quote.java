public class Quote<T> implements InterfaceFactory<T> {

    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.trim();
                if (exp.charAt(exp.length() - 1) == ')') {
                    exp = exp.substring(6, exp.length() - 1); // Elimina "(QUOTE" y el último ")"
                } else {
                    exp = exp.substring(6); // Elimina "(QUOTE" sin el último ")"
                }

                System.out.println(exp);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
