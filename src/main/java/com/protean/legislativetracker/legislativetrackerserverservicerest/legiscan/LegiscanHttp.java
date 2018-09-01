package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LegiscanHttp {

    //ToDo write test first
    @Value("${legiscan.url}")
    private String url;

    @Value("${legiscan.key}")
    private String key;

    public HttpURLConnection createHttpRequest() {
        String baseUrl = url + key;
        try {
            URL url = new URL(baseUrl);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
