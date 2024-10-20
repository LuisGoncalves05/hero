import com.googlecode.lanterna.*;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Arena {
    private final int width;
    private final int height;
    private final Hero hero;
    private final List<Wall> walls;
    private final List<Coin> coins;
    private final List<Monster> monsters;


    public Arena(int width, int height, Hero hero) {
        this.width = width;
        this.height = height;
        this.hero = hero;
        this.walls = createWalls();
        this.coins = createCoins();
        this.monsters = createMonsters();
    }

    private List<Wall> createWalls() {
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

    private List<Coin> createCoins() {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Coin coin;
            do {
                coin = new Coin(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            } while (coins.contains(coin));
            coins.add(coin);
        }
        return coins;
    }

    private List<Monster> createMonsters() {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Monster monster;
            do {
                monster = new Monster(random.nextInt(width - 2) + 1, random.nextInt(height - 2) + 1);
            } while (monsters.contains(monster));
            monsters.add(monster);
        }
        return monsters;
    }

    public boolean canHeroMove(Position position) {
        boolean can = true;
        for (Wall wall : walls) {
            can &= !wall.getPosition().equals(position);
        }
        return can;
    }

    public boolean canMonsterMove(Position position) {
        boolean can = true;
        for (Wall wall : walls) {
            can &= !(wall.getPosition().equals(position) || hero.getPosition().equals(position));
        }
        return can;
    }

    public void moveMonsters() {
        for (Monster monster: monsters) {
            Position position = monster.getPosition();
            ArrayList<Position> possible = new ArrayList<Position>();
            possible.add(new Position(position.getX() + 1, position.getY()));
            possible.add(new Position(position.getX() - 1, position.getY()));
            possible.add(new Position(position.getX(), position.getY() + 1));
            possible.add(new Position(position.getX(), position.getY() - 1));
            Random random = new Random();
            Position chosen;
            do {
                chosen = possible.get(random.nextInt(4));
            } while (!canMonsterMove(chosen));
            monster.setPosition(chosen);
        }
    }

    public void draw(TextGraphics graphics) {
        graphics.setForegroundColor(TextColor.Factory.fromString("#FFFF33"));
        graphics.enableModifiers(SGR.BOLD);
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width , height), ' ');
        graphics.putString(new TerminalPosition(hero.getX(), hero.getY()), "X");
        retrieveCoins();
        moveMonsters();
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin: coins)
            coin.draw(graphics);
        for (Monster monster: monsters)
            monster.draw(graphics);
    }


    public void retrieveCoins() {
        for (Coin coin :coins) {
            if (hero.getPosition().equals(coin.getPosition())) {
                coins.remove(coin);
                break;
            }
        }
    }

}
