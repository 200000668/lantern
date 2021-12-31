import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.List;

public class Maze{
    private Position start = new Position(0,0);
    private Position exit = new Position(0,0);
    private List<Obstacle> wall;
    private Boolean inside = true;
    private int width, height;

    public Maze(int x, int y){
        width = x;
        height = y;
    }

    public void start (int x, int y){
        start.setX(x);
        start.setY(y);
    }

    public void exit (int x, int y){
        exit.setX(x);
        exit.setY(y);
    }

    public Boolean isInside(){
        return inside;
    }

    public int getWidth(){
        return width;
    }

    public int getHeight() {
        return height;
    }
}

