package core.src.main.java.core.game.square;

public interface Square {

    enum PropType {
        WEATHER("Weather"), HUMIDITY("Humidity"), UVRAD("UV Index");

        private final String prop;

        PropType(String s) {
            this.prop = s;
        }

        public String getProp() {
            return prop;
        }
    }

}
