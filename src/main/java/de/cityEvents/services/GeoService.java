package de.cityEvents.services;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class GeoService {

    public List<String> findPostalCodesNear(final String postalCode, final String area) {
        ArrayList<String> resultList = new ArrayList<>();
        String uri =
                "http://api.geonames.org/findNearbyPostalCodesJSON?postalcode=" + postalCode + "&country=DE&radius=" + area + "&username=testAccount";
        try {
            URL url = new URL(uri);
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Accept", "application/json");

            InputStream jsonResponse = connection.getInputStream();
            String jsonResponseString = IOUtils.toString(jsonResponse);
            JSONParser parser = new JSONParser();
            JSONArray allPostalCodes = (JSONArray) ((JSONObject) parser.parse(jsonResponseString)).get("postalCodes");
            for (JSONObject postalCodeEntry : (Iterable<JSONObject>) allPostalCodes) {
                final String onePostalCode = (String) postalCodeEntry.get("postalCode");
                resultList.add(onePostalCode);
            }


            connection.disconnect();

        } catch (Exception e) {
            // handle it
        }

        return resultList;
    }
}
