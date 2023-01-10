package lecture_patterns.creational.builder.v1.simple_builder_example;

import java.awt.*;

public class Room {
    private Dimension dimension;
    private int floorNumber;
    private Color wallColor;
    private int numberOfWindows;
    private int numberOfDoors;
    private boolean isDouble;
    private boolean hasEnsuite;

    public Room(Dimension dimension, int floorNumber, Color wallColor, int numberOfWindows, int numberOfDoors, boolean isDouble, boolean hasEnsuite) {
        this.dimension = dimension;
        this.floorNumber = floorNumber;
        this.wallColor = wallColor;
        this.numberOfWindows = numberOfWindows;
        this.numberOfDoors = numberOfDoors;
        this.isDouble = isDouble;
        this.hasEnsuite = hasEnsuite;
    }
}
