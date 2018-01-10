package reversi_code;

/**
 * the class Cell defines Cell object.
 */
public class Cell {

    //will hold the sign of the cell
    private Sign cell;

    /**
     * constructor of Cell object.
     */
    public Cell() {
        this.cell = Sign.EMPTY;
    }

    /**
     * constructor of Cell object.
     * @param cell = EMPTY by default.
     */
    public Cell(Sign cell) {
        this.cell = cell;
    }

    /**
     * returns the sign of the cell.
     * @return sign of the cell.
     */
    public Sign getCell() {
        return this.cell;
    }

    /**
     * sets the cell's sign.
     * param cell.
     */
    public void setCell(Sign cell) {
        this.cell = cell;
    }

    /**
     * making the cell's enum value printable.
     * @return the cell's enum value as a string.
     */
    public String cellToPrint() {
        return String.valueOf(this.cell.asChar());
    }

}
