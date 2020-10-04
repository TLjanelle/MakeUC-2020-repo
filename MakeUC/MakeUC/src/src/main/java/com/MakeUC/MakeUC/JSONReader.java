package com.MakeUC.MakeUC;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;

public class JSONReader {
    public static JSONObject readJSON(String url) {
        return readJSON(url, "", "");
    }

    public static JSONObject readJSON(String url, String start, String end) {
        InputStream is = null;
        try {
            is = new URL(url).openStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder json = new StringBuilder(start);

            int character;
            while ((character = br.read()) != -1) {
                json.append((char) character);
            }
            json.append(end);
            return new JSONObject(json.toString());
        } catch (Exception e) {
            System.out.println(e);
            return null;
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (Exception e) {

                }
            }
        }
    }
}
