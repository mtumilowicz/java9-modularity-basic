package moduleB;

import moduleA.export.ExportA;
import moduleA.exportOnlyToB.ExportAOnlyToB;

/**
 * Created by mtumilowicz on 2018-05-11.
 */
public class TestB {
    public static void main(String[] args) {
        System.out.println("Hello from moduleB!");

        ExportA.export();
//        InternalA internalA; // no access
        ExportAOnlyToB.export();
    }
}
