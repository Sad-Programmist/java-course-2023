package edu.project2;

public class Cell {
    private boolean hasRightWall;
    private boolean hasBottomWall;

    public Cell() {
        this.hasRightWall = false;
        this.hasBottomWall = false;
    }

    public Cell(boolean hasRightWall, boolean hasBottomWall) {
        this.hasRightWall = hasRightWall;
        this.hasBottomWall = hasBottomWall;
    }

    public boolean isHasRightWall() {
        return hasRightWall;
    }

    public boolean isHasBottomWall() {
        return hasBottomWall;
    }

    public void setHasRightWall(boolean hasRightWall) {
        this.hasRightWall = hasRightWall;
    }

    public void setHasBottomWall(boolean hasBottomWall) {
        this.hasBottomWall = hasBottomWall;
    }
}
