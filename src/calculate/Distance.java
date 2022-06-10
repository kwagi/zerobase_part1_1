package calculate;

import apiTool.ApiParsing;

import java.util.*;
import java.util.stream.Collectors;

public class Distance {

    public Map<String, Double> distanceMap;
    public String[] resultKey;
    public List<Map.Entry<String, Double>> entries;

    public static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    public static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }


    public Distance(String inputLat, String inputLnt) {
        ApiParsing apiParsing = new ApiParsing();
        distanceMap = new HashMap<>(14497);

        for (Map.Entry<String, String> MGR : apiParsing.X_SWIFI_MGR_NO_Map.entrySet()) {
            Double theta = Double.parseDouble(inputLnt) - Double.parseDouble(apiParsing.Lnt_Map.get((MGR.getValue())));
            Double dist = Math.sin(deg2rad(Double.parseDouble(inputLat))) * Math.sin(deg2rad(Double.parseDouble(apiParsing.Lat_Map.get(MGR.getValue()))))
                    + Math.cos(deg2rad(Double.parseDouble(inputLat))) * Math.cos(deg2rad(Double.parseDouble(apiParsing.Lat_Map.get(MGR.getValue())))) * Math.cos(deg2rad(theta));
            dist = Math.acos(dist);
            dist = rad2deg(dist);
            dist = dist * 60 * 1.1515;
            dist = dist * 1.609344;

            distanceMap.put(MGR.getValue(), dist);
        }
        entries = distanceMap.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        resultKey = new String[20];

        for (int i = 0; i < resultKey.length; i++) {
            resultKey[i] = entries.get(i).getKey();
        }
    }
}
