package moduleC;

import moduleA.export.ExportA;
import moduleB.export.ExportB;

/**
 * Created by mtumilowicz on 2018-05-11.
 * <p>
 * note that if we put it directly under src/ - on the same layer as module-info.java we got:
 * Error occurred during initialization of boot layer
 * java.lang.module.FindException: Error reading module: path\moduleC
 * Caused by: java.lang.module.InvalidModuleDescriptorException: TestC.class found in top-level directory
 * (unnamed package not allowed in module)
 */
public class TestC {
    public static void main(String[] args) {
        System.out.println("Hello from moduleC!");

        ExportB.export();
//        InternalB internalB; // no access
        
        /*
        because:
        moduleB is required by moduleC,
        moduleA.export is exported by moduleA,
        moduleA is required transitive by module B
        we have access to classes from moduleA.export
        remember to add dependency moduleA to moduleC
         */
        ExportA.export();
//        InternalA internalA; // no access
//        ExportAOnlyToB exportAOnlyToB; // no access
    }
}
