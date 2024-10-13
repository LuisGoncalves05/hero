import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;

public class Wall {
    private final int x;
    private final int y;

    private Wall(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public static List<Wall> createWalls(int width, int height) {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height - 1));
        }
        for (int r = 1; r < height - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width - 1, r));
        }
        return walls;
    }

    public void draw(TextGraphics graphics) {
        graphics.putString(new TerminalPosition(x, y), "/");
    }

    public Position getPosition(){
        return new Position(x, y);
    }
}
