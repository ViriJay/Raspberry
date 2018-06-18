// import java.io.BufferedReader;
// import java.io.DataOutputStream;
// import java.io.InputStreamReader;
// import java.net.HttpURLConnection;
// import java.net.URL;
//
// import javax.net.ssl.HttpsURLConnection;
// // import javax.json.JsonNumber;
// // import javax.json.JsonReader;
// // import javax.json.JsonOject;
// // import javax.json.JsonArray;
// import com.google.gson.*;
//
// public class JSONShit {
//
//   public static void main(String... args){
//     try {
//       String url = "http://192.168.1.102/json.do?_PLN[0]";
//
//       URL obj = new URL(url);
//       HttpURLConnection con = (HttpURLConnection) obj.openConnection();
//
//       // optional default is GET
//       con.setRequestMethod("GET");
//
//       // create reader
//       BufferedReader in = new BufferedReader(
//       new InputStreamReader(con.getInputStream()));
//
//       // create string
//       String inputLine;
//       StringBuffer response = new StringBuffer();
//
//       // build the string
//       while ((inputLine = in.readLine()) != null) {
//         response.append(inputLine);
//       }
//       in.close();
//
//       // print result
//       System.out.println(response.toString());
//
//       // // create JsonObject
//       // JsonReader jsonReader = Json.createReader(response.toString());
//       // JsonObject jsonObj = JsonReader.readObject();
//       // jsonReader.close();
//       //
//       // JsonArray jsonArray = jsonObj.getJsonArray("_PLN");
//       // JsonArray jsonArray2 = jsonArray.getJsonArray(0);
//       // JsonNumber jsonNr = jsonArray2.getJsonNumber(0);
//       // double value = jsonNr.doubleValue();
//       //
//       // System.out.println("Nice: " + value);
//
//       JsonParser jp = new JsonParser();
//       JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
//       JsonObject rootObj = root.getAsJsonObject();
//
//
//       // {
//       //   "_PLN": [
//       //     [
//       //       0.0000
//       //     ],
//       //     "W"
//       //   ]
//       // }
//
//     } catch (Exception e){
//       System.out.println(e.getMessage());
//     }
//
//   }
//
// }
