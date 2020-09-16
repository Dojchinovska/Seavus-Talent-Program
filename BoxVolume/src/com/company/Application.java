package com.company;
import java.util.*;
public class Application {

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        int width= sn.nextInt();
        int height=sn.nextInt();
        int depth=sn.nextInt();

        Box b = new Box(height,width,depth);
        System.out.println(b + " has volume of " + b.getBoxVolume());
    }
}