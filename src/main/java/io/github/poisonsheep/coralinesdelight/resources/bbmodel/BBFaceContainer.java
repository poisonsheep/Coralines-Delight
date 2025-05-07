package io.github.poisonsheep.coralinesdelight.resources.bbmodel;

public interface BBFaceContainer {
    String getName();

    int getColor();

    Iterable<BBFace> getFaces();

    default boolean enableCulling() {
        return false;
    }
}
