/**
 * Created by mtumilowicz on 2018-05-11.
 */
module moduleA {
    exports moduleA.export;

    /*
    In general, avoid using qualified exports between modules in an application.
     */
    exports moduleA.exportOnlyToB to moduleB; // Qualified Export
}