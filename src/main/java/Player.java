import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

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

    public void draw(TextGraphics screen){
        screen.setForegroundColor(TextColor.Factory.fromString("#333366"));
        screen.enableModifiers(SGR.BOLD);
        screen.putString(new TerminalPosition(getPosition().getX(), getPosition().getY()), "æ");
    }
}
