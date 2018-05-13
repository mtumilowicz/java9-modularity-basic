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
(directly to module path or to `pom.xml`).
* **requires transitive** `Y` - requiring automatically all modules 
required by `Y`.
* **open module** - all its types are available for `deep reflection` 
(break into private parts of types at `run-time`) by other modules, 
while strong encapsulation is still upheld at compile-time. 
This property holds regardless of whether any packages are exported.  
`Deep reflection` is used by many libraries. For example, `Spring` or 
`Hibernate` inject values into nonpublic fields of classes.