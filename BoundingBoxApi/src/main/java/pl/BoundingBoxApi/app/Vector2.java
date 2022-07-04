package pl.BoundingBoxApi.app;

public class Vector2 {

    private float x;
    private float y;

    public Vector2() {}

    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Vector2 CalculateLengthBetweenPoints(Vector2 secondPoint) {
        float lengthOnXAxis = Math.abs(secondPoint.getX() - x);
        float lengthOnYAxis = Math.abs(secondPoint.getY() - y);
        Vector2 returnVector = new Vector2(lengthOnXAxis, lengthOnYAxis);
        return returnVector;
    }
}
