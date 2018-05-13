package ordinaryModule;

import reflection.Invoker;

public class Test {
    public static void main(String[] args) throws IllegalAccessException {
            Invoker.invokeStatic(new Test(), "hello");
    }

    public static void hello() {
        System.out.println("Hello from ordinaryModule!");
    }
}