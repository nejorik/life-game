package life.main;
import java.util.ArrayList;

public class Cell {
    Status status;
    ArrayList<Cell> near;

    public Cell () {
        status = Status.NONE;
        near = new ArrayList<>();
    }

    void addNear (Cell cell) {
        near.add(cell);
    }

    void step1 () {
        int around = countCellAround ();
        status = status.step1(around);
    }
    void step2 () {
        status = status.step2();
    }

    int countCellAround () {
        int cellsNumber = 0;
            for (Cell cell : near)
                if (cell.status.isCell())
                    cellsNumber++;
        return cellsNumber;
    }

    void turn () {
        for (Cell cell : near) {
            cell.status = cell.status.isCell() ? Status.NONE : Status.LIVE;
        }
    }
}
