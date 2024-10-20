abstract class Element {
    protected Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public int getX() {
        return position.getX();
    }

    public int getY() {
        return position.getY();
    }

    public Position getPosition(){
        return new Position(position.getX(), position.getY());
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp() {
        return new Position(position.getX() , position.getY() - 1);
    }
    public Position moveRight() {
        return new Position(position.getX() + 1, position.getY());
    }
    public Position moveDown() {
        return new Position(position.getX(), position.getY() + 1);
    }
    public Position moveLeft() {
        return new Position(position.getX() - 1, position.getY());
    }
}
