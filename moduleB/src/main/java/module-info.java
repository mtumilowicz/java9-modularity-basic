/**
 * Created by mtumilowicz on 2018-05-11.
 */
module moduleB {
    requires transitive moduleA;

    exports moduleB.export;
}