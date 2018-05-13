/**
 * Created by mtumilowicz on 2018-05-11.
 */
module moduleC {
    requires moduleB; // it has to be also added to dependencies of moduleC (module path)
    /*
     note that moduleB 'requires transitive' moduleA, but if we want to use moduleA exported packages we have to add
     first to dependencies
    */

}