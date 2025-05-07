package io.github.poisonsheep.coralinesdelight.resources.bbmodel;

import com.google.gson.JsonObject;
import io.github.poisonsheep.coralinesdelight.utils.Utils;
import org.joml.Vector3f;

public class BBObject {
    public final String uuid;
    public final String name;

    public final Vector3f origin;
    public final Vector3f rotation;

    public final int color;

    public final boolean export;
    public final boolean visibility;

    public BBObject(JsonObject element) {
        this.uuid = element.getAsJsonPrimitive("uuid").getAsString();
        this.name = element.getAsJsonPrimitive("name").getAsString();

        this.origin = Utils.parseVector(element, "origin");
        this.origin.mul(1.0f / 16.0f);
        this.rotation = Utils.parseVector(element, "rotation");
        this.rotation.mul((float) (Math.PI / 180.0));

        this.color = Utils.getIntElement(element, "color");

        this.export = Utils.getBooleanElement(element, "export");
        this.visibility = Utils.getBooleanElement(element, "visibility");
    }

    public String getName() {
        return name;
    }

    public int getColor() {
        return color;
    }
}
