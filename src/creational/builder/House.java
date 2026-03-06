package creational.builder;

public class House {
    private int walls;
    public void setWalls(int walls) { this.walls = walls; }
}

class HouseBuilder {
    private House house = new House();
    public HouseBuilder buildWalls(int walls) {
        house.setWalls(walls);
        return this;
    }
    public House build() { return house; }
}