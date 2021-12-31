import javax.swing.*;

import static com.googlecode.lanterna.input.KeyType.ArrowDown;
import static com.googlecode.lanterna.input.KeyType.ArrowUp;

public class Player extends Element {

    public Player(int x, int y){
        super(x, y);
    }

    private Boolean Alive = true;

    public void kill(){
        Alive = false;
    }

    public Boolean isAlive(){
        return Alive;
    }

    public void move(com.googlecode.lanterna.input.KeyStroke key){
        Position pos = getPosition();
        switch (key.getKeyType()){
            case ArrowUp: pos.setY(pos.getY()-1);
            case ArrowDown: pos.setY(pos.getY()+1);
            case ArrowLeft: pos.setX(pos.getX()-1);
            case ArrowRight: pos.setX(pos.getX()+1);


        }
    }
}
