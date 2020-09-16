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

    @Override
    public String toString() {
        return "Volume of the box with values: \n" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                " is " + this.volumeBox();
    }

    int volumeBox(){

        return height*width*depth;
    }
}
