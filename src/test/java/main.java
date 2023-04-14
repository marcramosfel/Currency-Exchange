import java.io.*;
import okhttp3.*;

public class main {
    public static void main(String []args) throws IOException{
        OkHttpClient client = new OkHttpClient().newBuilder().build();

        Request request = new Request.Builder()
                .url("https://api.apilayer.com/currency_data/convert?to=GBP&from=USD&amount=5")
                .addHeader("apikey", "8DMyPEUp0j7f1def1nAA4zzhGNphSVl5")
            .build();
    Response response = client.newCall(request).execute();
    System.out.println(response.body().string());
}
}