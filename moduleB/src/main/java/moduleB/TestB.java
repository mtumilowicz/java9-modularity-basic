package moduleB;

import moduleA.export.ExportA;
import moduleA.exportOnlyToB.ExportAOnlyToB;

/**
 * Created by mtumilowicz on 2018-05-11.
 * <p>
 * Error occurred during initialization of boot layer
 * java.lang.module.FindException: Error reading module: path\moduleB
 * Caused by: java.lang.module.InvalidModuleDescriptorException: TestB.class found in top-level directory
 * (unnamed package not allowed in module)
 */
public class TestB {
    public static void main(String[] args) {
        System.out.println("Hello from moduleB!");

        ExportA.export();
//        InternalA internalA; // no access
        ExportAOnlyToB.export();
    }
}
