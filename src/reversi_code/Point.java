package reversi_code;

/**
 * the class Point defines Point object.
 * a point represents a cell in the board.
 */
public class Point {

    //row
    private int x;
    //column
    private int y;

    /**
     * constructor of Point object.
     * @param x row.
     * @param y column.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * get the value of row x.
     * @return row.
     */
    public int getX() {
        return this.x;
    }

    /**
     * get the value of column y.
     * @return column.
     */
    public int getY() {
        return this.y;
    }

    /**
     * set the value of row x.
     * @param x row.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * set the value of column y.
     * @param y column.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * check if two points are equal.
     * @param other point.
     * @return boolean.
     */
    public boolean isEqual(Point other){
        if(this.x == other.getX() && this.y == other.getY()){
            return true;
        }
        return false;
    }

    /**
     * printing the point to the screen.
     */
    public void pointToPrint() {
        System.out.print("(" + this.x + "," + this.y + ")");
    }
}
