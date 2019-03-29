package io.helidon.examples.quickstart.fn;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FnCaller {

    public static void callFn(String trigger, String input) throws IOException {
        // TODO: Add back the env var once I figure out how vscode handles them.
        //String fnEndpoint = System.getenv("FN_INVOKE_ENDPOINT");

        String fnEndpoint = "http://localhost:8080/t/"; 
        URL url = new URL(fnEndpoint + trigger);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");

        // Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(input);
		wr.flush();
        wr.close();
        
        int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + input);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		
		System.out.println(response.toString());
    }

}