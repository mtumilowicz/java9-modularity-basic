package ordinaryModule;

import reflection.Invoker;

public class Test {
    public static void main(String[] args) {
        try {
            Invoker.invokeStatic(new Test(), "hello");
        } catch (IllegalAccessException e) {
            /*
            java.lang.IllegalAccessException: class Invoker (in module reflection) cannot access class 
            Test (in module ordinaryModule) because module ordinaryModule does not export ordinaryModule 
            to module reflection
             */
            System.out.println(e);
        }
    }

    public static void hello() {
        System.out.println("Hello from ordinaryModule!");
    }
}