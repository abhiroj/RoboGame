package core.elements;

/**
 * Properties supported by the game
 */
//TODO:Add copyright
public enum PropertyType {
    WEATHER("Weather"), HUMIDITY("Humidity"), UVRAD("UV Index");

    private final String type;

    PropertyType(String s) {
        this.type = s;
    }
}
