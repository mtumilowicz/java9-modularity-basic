/**
 * Created by mtumilowicz on 2018-05-11.
 */
module moduleB {
    requires transitive moduleA; // it has to be also added to dependencies of moduleB (module path)

    exports moduleB.export;
}