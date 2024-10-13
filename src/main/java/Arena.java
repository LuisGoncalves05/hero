import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;


    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
    }

    public boolean canHeroMove(Position position) {
        return  0 <= position.getX() &&
                position.getX() < width &&
                0 <= position.getY() &&
                position.getY() < height;
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width , height), ' ');
        graphics.putString(new TerminalPosition(hero.getX(), hero.getY()), "X");
    }

    public Hero getHero() {
        return hero;
    }
}
