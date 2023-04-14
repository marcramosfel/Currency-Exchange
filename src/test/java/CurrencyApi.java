import java.io.IOException;
import java.io.*;
import java.util.Map;
import java.util.Objects;

import okhttp3.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class CurrencyApi {
    private String uri = "https://api.apilayer.com/currency_data/";
    private final String apiKey = "8DMyPEUp0j7f1def1nAA4zzhGNphSVl5";

    public String getUri() {
        return uri;
    }

    public String getApiKey() {
        return apiKey;
    }

    public JSONObject convert(String fromCountryCurrency, String toCountryCurrency, double amount) throws IOException, ParseException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        String completeUrl = this.getUri() + "convert?to=" + toCountryCurrency + "&from=" + fromCountryCurrency + "&amount=" + amount;
        //System.out.println(completeUrl);
        Request request = new Request.Builder()
                .url(completeUrl)
                .addHeader("apikey", this.getApiKey())
                .build();
        Response response = client.newCall(request).execute();
        //System.out.println(Objects.requireNonNull(response.body()).string());
        System.out.println(Objects.requireNonNull(response.body()).contentType());

        JSONParser parser = new JSONParser();

        return (JSONObject) parser.parse(Objects.requireNonNull(response.body()).string());
    }

    public static void main(String[] args) {
        CurrencyApi c1 = new CurrencyApi();
        try {
            JSONObject r = c1.convert("USD", "GBP", 1);
            System.out.println(r.get("amount"));
            JSONObject query = (JSONObject) r.get("query");
            System.out.println(query.get("amount"));


        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }


    }

}




