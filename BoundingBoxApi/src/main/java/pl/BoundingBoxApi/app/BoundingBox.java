package pl.BoundingBoxApi.app;

import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BoundingBox {

    private Vector2 firstPoint;
    private Vector2 lastPoint;

    private float width;
    private float height;

    private String name;
    private final UUID id = UUID.randomUUID();

    public BoundingBox() {}

    public BoundingBox(BoundingBox boundingBox)
    {
        this.firstPoint = boundingBox.firstPoint;
        this.lastPoint = boundingBox.lastPoint;
        this.name = boundingBox.name;
    }
    public BoundingBox(Vector2 firstPoint, Vector2 lastPoint, String name) {
        this.firstPoint = firstPoint;
        this.lastPoint = lastPoint;
        this.name = name;
    }

    public float getWidth() {
        width = firstPoint.CalculateLengthBetweenPoints(lastPoint).getX();
        return width;
    }

    public float getHeight() {
        height = firstPoint.CalculateLengthBetweenPoints(lastPoint).getY();
        return height;
    }

    public UUID getId() {
        return id;
    }
    public Vector2 getFirstPoint() {
        return firstPoint;
    }

}
