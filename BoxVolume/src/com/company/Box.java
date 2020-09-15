package com.company;

public class Box {

    int width, height, depth;

    Box(){}
    Box(int height, int width, int depth)
    {
        this.height=height;
        this.width=width;
        this.depth=depth;

    }

    int createBox(){

        return height*width*depth;
    }
}
