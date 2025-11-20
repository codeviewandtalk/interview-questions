package Test;


import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class JavaCoding {


    public static void main(String[] args) {
        new B();

    }





}
class A {
    A() {
        System.out.println("A's constructor");
    }

}
class B extends A {
    B() {
        System.out.println("B's constructor");
    }

}