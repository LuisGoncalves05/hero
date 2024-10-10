import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width;

    private int height;
    Hero hero = new Hero(10, 10);

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public void processKey(KeyStroke key) {
        System.out.println(key);
        if (key.getKeyType() == KeyType.ArrowUp) {
            hero.moveUp();
        } else if (key.getKeyType() == KeyType.ArrowDown) {
            hero.moveDown();
        } else if (key.getKeyType() == KeyType.ArrowRight) {
            hero.moveRight();
        } else if (key.getKeyType() == KeyType.ArrowLeft) {
            hero.moveLeft();
        }
    }

    public void moveHero(Position position) {
        if (hero.canHeroMove(position))
            hero.setPosition(position);
    }

    public void draw(Screen screen) throws IOException {
        screen.clear();
        screen.setCharacter(hero.getx(), hero.gety(), TextCharacter.fromCharacter('X')[0]);
        screen.refresh();
    }
}
