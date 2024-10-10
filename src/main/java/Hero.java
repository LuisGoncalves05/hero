import com.googlecode.lanterna.input.KeyType;

public class Hero {
    private Position position;
    public Hero(int x, int y) {
        this.position = new Position(x, y);
    }
    public int getx() {
        return position.getx();
    }

    public int gety() {
        return position.gety();
    }

    public boolean canHeroMove(Position position) {
        return  0 <= position.getx() &&
                position.getx() <= width &&
                0 <= position.gety() &&
                position.gety() <= height;
    }    public void moveUp(){if (Ar)
        this.setPosition(new Position(position.getx() , position.gety() - 1));
    }
    public void moveRight() {
        this.setPosition(new Position(position.getx() + 1, position.gety()));
    }
    public void moveDown() {
        this.setPosition(new Position(position.getx(), position.gety() + 1));
    }
    public void moveLeft() {
        this.setPosition(new Position(position.getx() - 1, position.gety()));
    }

    public void setPosition(Position position) {
        this.position = position;
    }
}
