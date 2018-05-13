/**
 * Created by mtumilowicz on 2018-05-11.
 */
module moduleA {
    exports moduleA.export;
    
    exports moduleA.exportOnlyToB to moduleB;
}