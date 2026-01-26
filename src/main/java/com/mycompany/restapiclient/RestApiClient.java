package com.mycompany.restapiclient;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class RestApiClient {

    public static void main(String[] args) {

        try {
            // Step 1: API URL
            URL url = new URL("https://jsonplaceholder.typicode.com/posts/1");

            // Step 2: Open HTTP Connection
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            // Step 3: Read API response
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));

            String response = "";
            String line;

            while ((line = br.readLine()) != null) {
                response += line;
            }
            br.close();

            // Step 4: Convert response string to JSON object
            JSONObject jsonObject = new JSONObject(response);

            // Step 5: Display data in JSON format (Pretty Print)
            System.out.println("\n------ JSON RESPONSE ------");
            System.out.println(jsonObject.toString(4)); // 4 = indentation
            System.out.println("---------------------------");

        } catch (Exception e) {
            System.out.println("Error while fetching API data");
            e.printStackTrace();
        }
    }
}
