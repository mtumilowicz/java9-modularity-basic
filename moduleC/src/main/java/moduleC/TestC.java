package moduleC;

import moduleA.export.ExportA;
import moduleB.export.ExportB;

/**
 * Created by mtumilowicz on 2018-05-11.
 */
public class TestC {
    public static void main(String[] args) {
        System.out.println("Hello from moduleC!");

        ExportB.export();
        ExportA.export();
//        ExportAOnlyToB exportAOnlyToB; // no access
    }
}
