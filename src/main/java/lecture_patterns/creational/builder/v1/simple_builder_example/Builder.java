package lecture_patterns.creational.builder.v1.simple_builder_example;

import java.awt.*;

public interface Builder {
    Builder setDimension(Dimension dimension);

    Builder setFloorNumber(int floorNumber);

    Builder setWallColor(Color wallColor);

    Builder setNumberOfWindows(int numberOfWindows);

    Builder setNumberOfDoors(int numberOfDoors);
}
