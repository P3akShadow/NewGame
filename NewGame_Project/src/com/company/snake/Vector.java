package com.company.snake;

public class Vector {
    private int x;
    private int y;

    public Vector(int x, int y){
        this.x = x;
        this.y = y;
    }

    public boolean equals(Vector other){
        return x == other.x && y == other.y;
    }

    @Override
    public Vector clone(){
        return new Vector(x, y);
    }

    public boolean isNullVector(){
        return x == 0 && y == 0;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    /**
     * Returns if the value is in or out of the rectangle that is created by the two given vectors, interpreted as points.
     * The ends are inclusive.
     * @param vector1
     * @param vector2
     * @return vector that points in the direction to the rectangle; if inside returns the 0 vector
     */
    public Vector dirToRectangle(Vector vector1, Vector vector2){
        Vector direction = new Vector(0, 0);

        if(x > vector1.x && x > vector2.x){
                direction.x = -1;
        }else if(x < vector1.x && x < vector2.x){
            direction.x = 1;
        }

        if(y >= vector1.y && y >= vector2.y){
            direction.y = -1;
        }else if(y < vector1.y && y < vector2.y){
            direction.y = 1;
        }

        return direction;
    }

    /**
     * dirToRectangle((0,0), Vector bound)
     */
    public Vector dirToRectangle(Vector bound) {
        return dirToRectangle(new Vector(0, 0), bound);
    }

    /**
     * Returns if the Vector is inside the rectangle 0,0 bound
     */
    public boolean inside(Vector bound) {
        Vector check = dirToRectangle(new Vector(0, 0), bound);
        return(check.x == 0 && check.y == 0);
    }

    public void add(Vector otherVector){
        x += otherVector.x;
        y += otherVector.y;
    }

    public void multiply(int scalar){
        x *= scalar;
        y *= scalar;
    }
}