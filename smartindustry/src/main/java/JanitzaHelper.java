import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import com.google.gson.*;

public class JanitzaHelper {

    private String sURL;

    public JanitzaHelper(String sURL) {
        this.sURL = sURL;
    }

    public double getDatas(String param){
        try {
            //String url = "http://192.168.1.102/json.do?_PLN[0]";
            String url = sURL + param + "[0]";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            // optional default is GET
            con.setRequestMethod("GET");

            // create reader
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            // create string
            String inputLine;
            StringBuffer response = new StringBuffer();

            // build the string
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // print result

            JsonParser jp = new JsonParser();
            JsonElement root = jp.parse(response.toString());
            JsonObject rootObj = root.getAsJsonObject();
            JsonArray jsonArray1 = rootObj.get(param).getAsJsonArray();
            JsonArray jsonArray2 = jsonArray1.get(0).getAsJsonArray();
            double value = jsonArray2.get(0).getAsDouble();
            System.out.println(value);
            return value;

        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        return -1;
    }

}