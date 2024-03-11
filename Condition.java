public class Condition<T> implements InterfaceFactory<T>{

    @Override
    public void execute(String exp) {
        System.out.println(exp);
    }
}
