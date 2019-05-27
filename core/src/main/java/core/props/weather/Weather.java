package core.src.main.java.core.props.weather;

public class Weather {

    private enum Type {
        C("Celsius"), F("Fahreneit");

        private final String type;

        Type(String type1) {
            this.type = type1;
        }

        @Override
        public String toString() {
            return type;
        }
    }

    public static final Type CELSIUS = Type.C;
    public static final Type FAHRENEIT = Type.F;

    private String weather;
    private Type weatherType;

    public Weather(String weather, Type weatherType) {
        this.weather = weather;
        this.weatherType = weatherType;
    }

}
