package openModule;

import reflection.Invoker;

/**
 * Created by mtumilowicz on 2018-05-11.
 */
public class Test {
    public static void main(String[] args) {
        try {
            Invoker.invokeStatic(new Test(), "hello");
        } catch (IllegalAccessException e) {
            System.out.println(e);
        }
    }

    public static void hello() {
        System.out.println("Hello from openModule!");
    }
}
