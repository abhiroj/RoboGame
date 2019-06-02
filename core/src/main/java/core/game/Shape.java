package core.src.main.java.core.game;

import java.util.Map;

interface Shape {

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

    boolean canVisit();

    void markVisited();

    Map<PropType, Object> collect();

}
