import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.input.KeyStroke;


import java.io.IOException;

public class Game {
    private final Screen screen;

    private final int x = 50;
    private final int y = 50;
    private final Arena arena = new Arena(x, y);

    public Game() throws IOException {
        TerminalSize terminalSize = new TerminalSize(x, y);
        DefaultTerminalFactory terminalFactory = new
                DefaultTerminalFactory()
                .setInitialTerminalSize(terminalSize);
        Terminal terminal = terminalFactory.createTerminal();

        screen = new TerminalScreen(terminal);
        screen.setCursorPosition(null); // we don't need a cursor
        screen.startScreen(); // screens must be started
        screen.doResizeIfNecessary(); // resize screen if necessary
    }
    public void run() throws IOException {
        KeyStroke key;
        do {
            arena.draw(screen);
            key = screen.readInput();
            arena.processKey(key);
        } while (key.getKeyType() != KeyType.EOF);
    }

}
