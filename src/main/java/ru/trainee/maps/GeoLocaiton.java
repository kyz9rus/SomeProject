package ru.trainee.maps;

import com.google.common.collect.Maps;
import com.oracle.javafx.jmx.json.JSONException;

import java.util.Map;

import static ru.trainee.maps.AbstractSample.encodeParams;

public class GeoLocaiton {

    public String getCity(double x, double y) throws java.io.IOException, JSONException {
        final String baseUrl = "http://maps.googleapis.com/maps/api/geocode/json"; // way to Geocoding API by HTTP
        final Map<String, String> params = Maps.newHashMap();

        params.put("sensor", "false");
        params.put("latlng", String.format("%.6f", x).replace(',', '.') + "," + String.format("%.6f", y).replace(',', '.'));
        params.put("language", "en");
        params.put("key", Property.getApi_key());

        final String url = baseUrl + '?' + encodeParams(params);

        System.out.println(url);

//        final JSONObject response = JsonReader.read(url);
//        final JSONObject location = response.getJSONArray("results").getJSONObject(0);
//        final String formattedAddress = location.getString("formatted_address");
//        String [] parameters = formattedAddress.split(",");

//        return parameters[2];       // it means that we take only result from json response

        return "Saint-Petersburg";
    }
}
