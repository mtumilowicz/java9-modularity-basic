package moduleA;

/**
 * Created by mtumilowicz on 2018-05-11.
 * <p>
 * Error occurred during initialization of boot layer
 * java.lang.module.FindException: Error reading module: path\moduleA
 * Caused by: java.lang.module.InvalidModuleDescriptorException: TestA.class found in top-level directory
 * (unnamed package not allowed in module)
 */
public class TestA {
    public static void main(String[] args) {
        System.out.println("Hello from moduleA!");
    }
}
