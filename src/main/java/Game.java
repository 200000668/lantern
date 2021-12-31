import com.googlecode.lanterna.SGR;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;

public class Game {
    private Player player = new Player(0,0);
    private Maze maze = new Maze(120, 60);
    private Screen screen;

    public void newGame(){
        TerminalSize terminalSize = new TerminalSize(maze.getWidth(), maze.getHeight());
        DefaultTerminalFactory defaultTerminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        Terminal terminal = null;
        try{
            terminal = defaultTerminalFactory.createTerminal();
            terminal.setForegroundColor(TextColor.Factory.fromString("#50"));
            terminal.enableSGR(SGR.BOLD);
            terminal.setCursorPosition(player.getPosition().getX(), player.getPosition().getY());
            terminal.putCharacter('X');
            terminal.setCursorVisible(false);
            screen = new TerminalScreen(terminal);
            Boolean game = true;
            while (game){
                KeyStroke key = terminal.readInput();
                player.move(key);
                terminal.setCursorPosition(player.getPosition().getX(), player.getPosition().getY());
                terminal.putCharacter('X');
                screen = new TerminalScreen(terminal);
                screen.refresh();
                }

            terminal.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
