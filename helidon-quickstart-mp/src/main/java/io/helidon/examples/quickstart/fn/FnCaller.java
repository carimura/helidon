package io.helidon.examples.quickstart.fn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FnCaller {

    public static void callFn(String trigger) throws IOException {
        String fnEndpoint = System.getenv("FN_INVOKE_ENDPOINT");
        URL url = new URL(fnEndpoint + trigger);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            System.out.println(inputLine);
        }
        in.close();
    }

}