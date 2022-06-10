package apiTool;

import com.google.gson.*;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class WriteApi {
    public JsonArray row;

    public WriteApi() {
        try {
            String projPath = System.getProperty("user.home") + "/Desktop/zerobase_part1_1/api/";//플젝 경로


            for (int i = 1, j = 1; i + 999 <= 15000; i += 999, j++) {//14497개여서 딱 15000까지만 호출
                FileWriter fileWriter = new FileWriter(projPath + j + "api_call.json", false);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                ApiCall apiCall = new ApiCall(i, i + 999);
                bufferedWriter.write(String.valueOf(apiCall.sb));
                bufferedWriter.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
