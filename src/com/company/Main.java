package com.company;
import java.util.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sn = new Scanner(System.in);
        int width= sn.nextInt();
        int height=sn.nextInt();
        int depth=sn.nextInt();

        Box b = new Box(height,width,depth);
        System.out.println("Volume of the box: "+ b.createBox());


    }
}
