package core.src.main.java.core.structure;

import core.src.main.java.core.collection.Collectable;
import core.src.main.java.core.props.weather.Weather;

import java.util.Map;

public class MarsSquare implements Collectable {

    private Weather weather;

    public void setWeather(Weather weather){
        this.weather=weather;
    }

    public Map<String, Object> collect() {
        return null;
    }
}

