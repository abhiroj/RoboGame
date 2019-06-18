package core.elements;

/**
 * Properties supported by the game
 */
public enum PropertyType {
    WEATHER("Weather"), HUMIDITY("Humidity"), UVRAD("UV Index");

    private final String prop;

    PropertyType(String s) {
        this.prop = s;
    }

    public String getProp() {
        return prop;
    }
}
