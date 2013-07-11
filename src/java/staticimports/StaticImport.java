package java.staticimports;

import static java.lang.Math.*;
import static java.lang.System.out;

public class StaticImport {
    public static void main(String[] args) {
        out.println("Hello World!");
        out.println("Considering a circle with a diameter of 5 cm, it has:");
        out.println("A circumference of " + (PI * 5) + " cm");
        out.println("And an area of " + (PI * pow(2.5,2)) + " sq. cm");
    }
}
