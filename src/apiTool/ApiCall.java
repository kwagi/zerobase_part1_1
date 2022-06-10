package apiTool;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class ApiCall {
    public StringBuilder sb;

    public ApiCall(int start, int end) {

        try {
            BufferedReader rd = null;
            StringBuilder urlBuilder = new StringBuilder("http://openapi.seoul.go.kr:8088");
            urlBuilder.append("/" + URLEncoder.encode("6d524e446672686b38314448726567", StandardCharsets.UTF_8));
            urlBuilder.append("/" + URLEncoder.encode("json", StandardCharsets.UTF_8));
            urlBuilder.append("/" + URLEncoder.encode("TbPublicWifiInfo", StandardCharsets.UTF_8));
            urlBuilder.append("/" + URLEncoder.encode(Integer.toString(start), StandardCharsets.UTF_8));
            urlBuilder.append("/" + URLEncoder.encode(Integer.toString(end), StandardCharsets.UTF_8));
            URL url = new URL(urlBuilder.toString());

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-type", "application/json");

            if (connection.getResponseCode() >= 200 && connection.getResponseCode() <= 300) {
                rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                rd = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            sb = new StringBuilder();

            String line;

            while ((line = rd.readLine()) != null) {
                sb.append(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

