package com.locus.sh.locusMap.service;

import com.google.gson.Gson;
import com.locus.sh.locusMap.model.GglDirectionApiResponse;
import com.locus.sh.locusMap.model.Location;
import com.locus.sh.locusMap.utils.UrlUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.stream.Collectors;

public class GglDirectionApiService {

    public static GglDirectionApiResponse getDirection(Location start, Location end) {

        GglDirectionApiResponse gglDirectionApiResponse = null;

        String requestUrl = UrlUtils.createGgleDirectionApiRequestUrl(start, end);

        try{
            URL url = new URL(requestUrl);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + conn.getResponseCode());
            }

            String result = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream()))).lines().collect(Collectors.joining("\n"));

            GglDirectionApiResponse respObj = (new Gson()).fromJson(result, GglDirectionApiResponse.class);

            gglDirectionApiResponse = respObj;

            conn.disconnect();
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        }

        return gglDirectionApiResponse;
    }
}
