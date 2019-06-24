package core.elements.shape;

import java.util.Properties;

/**
 * Sandbox provides implementations with functionality to simulate terrestial elements like weather,humidity,
 * precipitation, UV Radiation etc. For more info on properties, See PropertyType {@link core.elements.PropertyType}
 * which provides supported properties
 */
public interface Sandbox {

    Properties getProperties();

    void setProperties(Properties properties);

}