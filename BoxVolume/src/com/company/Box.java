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
        return "Box{" +
                "width=" + width +
                ", height=" + height +
                ", depth=" + depth +
                '}';
    }

    int getBoxVolume(){
        return height*width*depth;
    }
}
