import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*La clase {LispTest} es una clase diseñada para hacer purebas unitarias y comprobar mediante ejemplos el funcionamieto de 
cada una de las clases.*/
public class LispTest {

    //Test para la clase List
    //Verifica que la conversión a una lista de tokens sea correcta
    @Test
    void testListConversion() {
        List<String> list = new List<>();
        String exp = "( a b c )";
        
        java.util.List<String> result = list.listConversion(exp);
        
        assertNotNull(result);
        assertEquals(3, result.size());
        assertEquals("a", result.get(0));
        assertEquals("b", result.get(1));
        assertEquals("c", result.get(2));
    }

    //Test para clase Operation
    //Comprueba las diferentes operaciones aritméticas
    @Test
    void testArithmeticOperation() {
        Operation<Double> operation = new Operation<>();

        double resultAdd = operation.arithmeticOperation(3.0, 4.0, "+");
        assertEquals(7.0, resultAdd);

        double resultSubtract = operation.arithmeticOperation(3.0, 4.0, "-");
        assertEquals(-1.0, resultSubtract);

        double resultMultiply = operation.arithmeticOperation(3.0, 4.0, "*");
        assertEquals(12.0, resultMultiply);

        double resultDivide = operation.arithmeticOperation(12.0, 4.0, "/");
        assertEquals(3.0, resultDivide);
    }

    //Test para clase setQ
    //Verifica que no haya ninguna variable definida en el mapa de valores
    @Test
    void testExecuteWithInvalidExpressionSetQ() {
        SetQ<Integer> setQ = new SetQ<>();
        String exp = "( setq )";

        setQ.execute(exp);

        assertNull(setQ.variableValues.get("x"));
    }

    //Metodo para la clase Princ
    //Verifica que la ejecución del método ocurra sin excepciones
    @Test
    void testExecuteWithValidExpressionPrinc() {
        SetQ<Integer> setQ = new SetQ<>();
        Princ<Integer> princ = new Princ<>(setQ);
        setQ.execute("( setq x 5 )");
        princ.execute("( princ x )");

    }

    
    //Test para la clase Quote
    //Verifica que la ejecución del método ocurra sin excepciones
    @Test
    void testExecuteWithValidExpressionQuote() {
        Quote<Integer> quote = new Quote<>();

        String exp = "( quote (1 2 3))";
        quote.execute(exp);

    }

    //Test para la clase Atom
    //Verifica que la ejecución del método ocurra sin excepciones
    @Test
    void testExecuteWithAtomExpression() {
        SetQ<Integer> setQ = new SetQ<>();
        Atom<Integer> atom = new Atom<>(setQ);

        setQ.execute("( setq x 5 )");
        atom.execute("(atom x)");

    }

    //Test para la clase Comparator
    //Verifica que la ejecución del método ocurra sin excepciones
    @Test
    void testExecuteExpression() {
        Comparator<Integer> comparator = new Comparator<>();

        String exp = "(comparator < 2 5)";
        comparator.execute(exp);

    }

    //Test para la clase Defun
    //Verifica que la expresion sea valida para definir una funcion
    @Test
    void testExecuteWithValidExpressionDefun() {
        Defun<Integer> defun = new Defun<>();

        String exp = "(defun double x ( * x 2 ))";
        defun.execute(exp);

        assertTrue(defun.isDefine("double"));
    }

    //Test para la clase Equal
    //Verifica que la salida sea T
    @Test
    void testExecuteWithValidExpressionEqual() {
        Equal<String> equal = new Equal<>();

        String exp = "(equal 2 2)";
        equal.execute(exp);
    }

    //Test para la clase CallFunction
    //Verificar que se imprima el mensaje de error correspondiente
    @Test
    void testExecuteWithInvalidExpressionCallFunction() {
        Defun<Integer> defun = new Defun<>();
        defun.execute("(defun double x ( * x 2 ))");

        CallFunction<Integer> callFunction = new CallFunction<>(defun);
        String exp = "(double)";
        
        callFunction.execute(exp);

        
    }
   
} 