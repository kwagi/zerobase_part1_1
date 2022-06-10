package apiTool;

import com.google.gson.*;

import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class ApiParsing {

    public JsonPrimitive list_total_count;
    public JsonPrimitive CODE;
    public JsonPrimitive MESSAGE;
    public JsonArray row;

    public JsonPrimitive LAT;
    public JsonPrimitive LNT;
    public JsonPrimitive X_SWIFI_MGR_NO;//key
    public JsonPrimitive X_SWIFI_WRDOFC;
    public JsonPrimitive X_SWIFI_MAIN_NM;
    public JsonPrimitive X_SWIFI_ADRES1;
    public JsonPrimitive X_SWIFI_ADRES2;
    public JsonPrimitive X_SWIFI_INSTL_FLOOR;
    public JsonPrimitive X_SWIFI_INSTL_TY;
    public JsonPrimitive X_SWIFI_INSTL_MBY;
    public JsonPrimitive X_SWIFI_SVC_SE;
    public JsonPrimitive X_SWIFI_CMCWR;
    public JsonPrimitive X_SWIFI_CNSTC_YEAR;
    public JsonPrimitive X_SWIFI_INOUT_DOOR;
    public JsonPrimitive X_SWIFI_REMARS3;
    public JsonPrimitive WORK_DTTM;

    public Map<String, String> Lat_Map = new HashMap<>(14497);
    public Map<String, String> Lnt_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_WRDOFC_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_MAIN_NM_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_ADRES1_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_ADRES2_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_INSTL_FLOOR_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_INSTL_TY_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_INSTL_MBY_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_SVC_SE_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_CMCWR_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_CNSTC_YEAR_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_INOUT_DOOR_Map = new HashMap<>(14497);
    public Map<String, String> X_SWIFI_REMARS3_Map = new HashMap<>(14497);
    public Map<String, String> WORK_DTTM_Map = new HashMap<>(14497);

    public Map<String, String> X_SWIFI_MGR_NO_Map = new HashMap<>(14497);

    public ApiParsing() {
        try {
            String projPath = System.getProperty("user.home") + "/Desktop/zerobase_part1_1/api/";
            Reader reader = new FileReader(projPath + "1api_call.json");
            JsonParser jsonParser = new JsonParser();
            Object object = jsonParser.parse(reader);
            JsonObject jsonObject = (JsonObject) object;
            JsonObject TbPublicWifiInfo = jsonObject.getAsJsonObject("TbPublicWifiInfo");
            list_total_count = TbPublicWifiInfo.getAsJsonPrimitive("list_total_count");
            JsonObject RESULT = TbPublicWifiInfo.getAsJsonObject("RESULT");
            CODE = RESULT.getAsJsonPrimitive("CODE");
            MESSAGE = RESULT.getAsJsonPrimitive("MESSAGE");
            row = TbPublicWifiInfo.getAsJsonArray("row");

            for (int i = 1; i <= 15; i++) {

                reader = new FileReader(projPath + i + "api_call.json");
                jsonParser = new JsonParser();
                object = jsonParser.parse(reader);
                jsonObject = (JsonObject) object;
                TbPublicWifiInfo = jsonObject.getAsJsonObject("TbPublicWifiInfo");
                row = TbPublicWifiInfo.getAsJsonArray("row");

                for (int j = 0; j < row.size(); j++) {

                    JsonObject rowObject = (JsonObject) jsonParser.parse(String.valueOf(row.get(j)));

                    X_SWIFI_MGR_NO = rowObject.getAsJsonPrimitive("X_SWIFI_MGR_NO");
                    LAT = rowObject.getAsJsonPrimitive("LAT");
                    LNT = rowObject.getAsJsonPrimitive("LNT");
                    X_SWIFI_WRDOFC = rowObject.getAsJsonPrimitive("X_SWIFI_WRDOFC");
                    X_SWIFI_MAIN_NM = rowObject.getAsJsonPrimitive("X_SWIFI_MAIN_NM");
                    X_SWIFI_ADRES1 = rowObject.getAsJsonPrimitive("X_SWIFI_ADRES1");
                    X_SWIFI_ADRES2 = rowObject.getAsJsonPrimitive("X_SWIFI_ADRES2");
                    X_SWIFI_INSTL_FLOOR = rowObject.getAsJsonPrimitive("X_SWIFI_INSTL_FLOOR");
                    X_SWIFI_INSTL_TY = rowObject.getAsJsonPrimitive("X_SWIFI_INSTL_TY");
                    X_SWIFI_INSTL_MBY = rowObject.getAsJsonPrimitive("X_SWIFI_INSTL_MBY");
                    X_SWIFI_SVC_SE = rowObject.getAsJsonPrimitive("X_SWIFI_SVC_SE");
                    X_SWIFI_CMCWR = rowObject.getAsJsonPrimitive("X_SWIFI_CMCWR");
                    X_SWIFI_CNSTC_YEAR = rowObject.getAsJsonPrimitive("X_SWIFI_CNSTC_YEAR");
                    X_SWIFI_INOUT_DOOR = rowObject.getAsJsonPrimitive("X_SWIFI_INOUT_DOOR");
                    X_SWIFI_REMARS3 = rowObject.getAsJsonPrimitive("X_SWIFI_REMARS3");
                    WORK_DTTM = rowObject.getAsJsonPrimitive("WORK_DTTM");

                    X_SWIFI_MGR_NO_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_MGR_NO.getAsString());
                    X_SWIFI_WRDOFC_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_WRDOFC.getAsString());
                    X_SWIFI_MAIN_NM_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_MAIN_NM.getAsString());
                    X_SWIFI_ADRES1_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_ADRES1.getAsString());
                    X_SWIFI_ADRES2_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_ADRES2.getAsString());
                    X_SWIFI_INSTL_FLOOR_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_INSTL_FLOOR.getAsString());
                    X_SWIFI_INSTL_TY_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_INSTL_TY.getAsString());
                    X_SWIFI_INSTL_MBY_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_INSTL_MBY.getAsString());
                    X_SWIFI_SVC_SE_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_SVC_SE.getAsString());
                    X_SWIFI_CMCWR_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_CMCWR.getAsString());
                    X_SWIFI_CNSTC_YEAR_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_CNSTC_YEAR.getAsString());
                    X_SWIFI_INOUT_DOOR_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_INOUT_DOOR.getAsString());
                    X_SWIFI_REMARS3_Map.put(X_SWIFI_MGR_NO.getAsString(), X_SWIFI_REMARS3.getAsString());
                    WORK_DTTM_Map.put(X_SWIFI_MGR_NO.getAsString(), WORK_DTTM.getAsString());
                    Lat_Map.put(X_SWIFI_MGR_NO.getAsString(), LAT.getAsString());
                    Lnt_Map.put(X_SWIFI_MGR_NO.getAsString(), LNT.getAsString());
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
