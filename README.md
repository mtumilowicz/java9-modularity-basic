# java9-modularity-basic
The main goal of this project is to explore basic features of 
`modularity` introduced in `Java 9`:  

* **exports**
* **exports** `X` **to** `Y`
* **requires**
* **requires transitive**
* **open module**

_Reference_: [Java 9 Modularity](https://www.amazon.com/Java-Modularity-Developing-Maintainable-Applications/dp/1491954167)  

## project structure
* **moduleA**, **moduleB**, **moduleC** - exploring `exports`, 
`exports X to Y`, `requires`, `requires transitive`.

* **openModule**, **ordinaryModule**, **reflection** - exporing 
`open module` and correlate `modularity` with `reflection`.

## project description
Assume that we analyze `module-info.java` under module `X`
* **exports** `Y` - exporting package `Y`.
* **exports** `Y` **to** `Z` (`Qualified Export`) - export package `Y` 
to module `Z`.  
In general, we should avoid using `qualified exports` between modules in 
an application.
* **requires** `Y` - indicates a dependency on the module `Y`.  
Remember that the module `Y` has to be also added to dependencies of `X`
(directly to `module-path` or to `pom.xml`).
* **requires transitive** `Y` - requiring automatically all modules 
required by `Y`.
* **open module** - all its types are available for `deep reflection` 
(break into private parts of types at `run-time`) by other modules, 
while strong encapsulation is still upheld at compile-time. 
This property holds regardless of whether any packages are exported.  
`Deep reflection` is used by many libraries. For example, `Spring` or 
`Hibernate` inject values into nonpublic fields of classes.

## project content
### moduleA
```
module moduleA {
    exports moduleA.export;
    
    exports moduleA.exportOnlyToB to moduleB;
}
```
so package:
* `moduleA.export` will be exported to other modules
* `moduleA.exportOnlyToB` will be exported only to `moduleB`
* `moduleA.internal` is encapsulated & other modules don't have access 
to it. For example if you uncomment the line in `moduleB.TestB`:
```
//        InternalA internalA; // no access
```
project will not compile.  
### moduleB
```
module moduleB {
    requires transitive moduleA;

    exports moduleB.export;
}
```
```
<dependency>
    <groupId>basic</groupId>
    <artifactId>moduleA</artifactId>
    <version>1.0-SNAPSHOT</version>
</dependency>
```
so (we don't repeat keyword defined in previous step):
* `moduleB` is reporting dependency on `moduleA`, what is more - every
further module that will be requiring `moduleB` will get access to 
`moduleA` also.  
Note that we have to put `moduleA` also in `pom.xml` (without `pom.xml` 
we should add `moduleA` to `module-path` of `moduleB` otherwise project 
will not compile).

### moduleC
```
module moduleC {
    requires moduleB;
}
```
```
<dependency>
    <groupId>basic</groupId>
    <artifactId>moduleA</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
<dependency>
    <groupId>basic</groupId>
    <artifactId>moduleB</artifactId>
    <version>1.0-SNAPSHOT</version>
    <scope>compile</scope>
</dependency>
```
so:
* if we want to use transitive dependency on `moduleA` (through 
`moduleB`) we have to also add it to `pom.xml` - if not, nothing more 
should be done.
* note that if you uncomment the line in `moduleC.TestC`:
```
//        ExportAOnlyToB exportAOnlyToB; // no access
```
project will not compile, so package `ExportAOnlyToB` was correctly 
exported only to `moduleB` (`moduleB.TestB`)
* in `moduleC.TestC` we use transitive dependency on `moduleA`:
```
ExportA.export();
```
____
### reflection
Module with only one simple class `Invoker` to invoker static methods:
```
public static void invokeStatic(Object obj, String methodName) throws IllegalAccessException {
    try {
        obj.getClass().getMethod(methodName).invoke(null);
    } catch (InvocationTargetException | NoSuchMethodException e) {
        throw new RuntimeException(e);
    }
}
```

### openModule
```
open module openModule {
    requires reflection;
}
```
Running `openModule.Test` class will cause printing to console: "Hello 
from openModule!" - because of that the modul is marked as `open` in the
`module-info.java` file.

### ordinaryModule
```
module ordinaryModule {
    requires reflection;
}
```
Running `ordinaryModule.Test` class will cause printing to console:
```
java.lang.IllegalAccessException: class Invoker (in module reflection) cannot access class 
Test (in module ordinaryModule) because module ordinaryModule does not export ordinaryModule 
to module reflection
```

## remarks
* If we are using `maven` the file `module-info.java` should be added to
* asd 