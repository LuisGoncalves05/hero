import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;
    private final List<Wall> walls;


    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = Wall.createWalls(width, height);
    }

    public boolean canHeroMove(Position position) {
        boolean can = true;
        for (Wall wall : walls) {
            can &= !wall.getPosition().equals(position);
        }
        return can;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width , height), ' ');
        graphics.putString(new TerminalPosition(hero.getX(), hero.getY()), "X");
        for (Wall wall : walls)
            wall.draw(graphics);
    }

    public Hero getHero() {
        return hero;
    }
}
