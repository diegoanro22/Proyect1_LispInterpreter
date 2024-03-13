public class Equal<T> implements InterfaceFactory<T> {

    @Override
    public void execute(String exp) {
        Expression<T> expressionChecker = new Expression<>();
        try {
            if (expressionChecker.checkParen(exp)) {
                exp = exp.substring(0, exp.length() - 1);

                String[] parts = exp.split(" ");
                if (parts.length < 3) {
                    System.out.println("Faltan argumentos para 'equal'");
                    return;
                }

                String entrada1 = parts[1];
                String entrada2 =  parts[2];

                System.out.println(equal(entrada1, entrada2));
            }
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.getMessage());
        }
    }

    public String equal(String entrada1, String entrada2) {
        try {
            if (entrada1.equals(entrada2)) {
                return "T";
            }
            else{
                return "Nil";
            }
        } catch (NumberFormatException e) {
            System.out.println("Error al procesar los valores");
        }
        return "Error";
    }
    
    
}
