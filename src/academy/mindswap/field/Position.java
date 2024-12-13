package academy.mindswap.field;

public class Position {
    private int col;
    private int row;

    public Position (int col, int row) {
        this.col = col;
        this.row = row;
    }

    public int getCol() {
        return col; //defined the position
    }

    public int getRow() {
        return row; //defined the position
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Position obj) {
            return this.getRow() == obj.getRow() && this.getCol() == obj.getCol();
        }
        return false;
    }
}
