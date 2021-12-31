import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import javax.swing.*;
import java.io.IOException;

public class Menu {
    public void introMenu() {
        TerminalSize terminalSize = new TerminalSize(100, 50);
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = null;
        try{
            terminal = defaultTerminalFactory.createTerminal();
            terminal.setForegroundColor(TextColor.Factory.fromString("#50"));
            terminal.enableSGR(SGR.BOLD);
            terminal.setCursorPosition(10, 5);
            terminal.putString("1 → Start New Game");
            terminal.setCursorPosition(10, 6);
            terminal.putString("2 → Select Maze");
            terminal.setCursorPosition(10, 7);
            terminal.putString("3 → Quit");
            terminal.setCursorVisible(false);
            terminal.putCharacter(' ');
            Boolean game = true;
            while (game){
                KeyStroke key = terminal.readInput();
                switch (key.getCharacter()){
                    case ('1'): Game run = new Game(); run.newGame();
                    case ('2'): break;
                    case ('3'): game = false;
                }
            }
            terminal.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
}
