public class Condition<T> implements InterfaceFactory<T> {
    Comparator<T> verificar = new Comparator<T>();

    @Override
    public void execute(String exp) {
        exp = exp.trim();
        if (!exp.startsWith("(cond") || !exp.endsWith(")")) {
            System.out.println("Expresión mal formada.");
            return;
        }

        // Eliminamos el "(cond " y el último ")" para obtener solo la expresión de la condición.
        String conditionExp = exp.substring(6, exp.length() - 1).trim();

        if (!conditionExp.startsWith("(") || !conditionExp.endsWith(")")) {
            System.out.println("Expresión mal formada.");
            return;
        }

        // Eliminamos los paréntesis que envuelven la condición.
        conditionExp = conditionExp.substring(1, conditionExp.length() - 1).trim();

        // Dividimos la condición en sus partes.
        String[] parts = conditionExp.split("\\s+");

        if (parts.length != 3) {
            System.out.println("Expresión mal formada.");
            return;
        }

        String operator = parts[0];
        String leftOperand = parts[1];
        String rightOperand = parts[2];

        // Llamamos al método evaluateComparison de Comparator.
        try {
            boolean result = verificar.evaluateComparison(operator, leftOperand, rightOperand);
            String output = result ? "Es Verdadero" : "Es Falso";
            System.out.println(output);
        } catch (Exception e) {
            System.out.println("Error al procesar la expresión: " + e.toString());
        }
    }
}
