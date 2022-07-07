package 泛型.example;

import java.util.Scanner;

public class TestAdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(add01.add(1,2));
        System.out.println(add01.add(1.1,2.2));
        System.out.println(add02.add(sc.nextDouble(),sc.nextDouble()));
    }
}
