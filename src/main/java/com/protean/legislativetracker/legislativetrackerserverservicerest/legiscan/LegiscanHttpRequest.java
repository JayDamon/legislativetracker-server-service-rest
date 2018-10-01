package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.annotations.LegiscanJsonName;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.markerinterface.LegiscanOperationable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.List;

public class LegiscanHttpRequest {

    private LegiscanHttpUri request;
    private String jsonString;

    public LegiscanHttpRequest(LegiscanHttpUri uri) {
        this.request = uri;
        this.jsonString = readResponse();
    }

    private String readResponse() {
        HttpURLConnection con = request.getConnection();
        try {
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder content = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            return content.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        } finally {
            con.disconnect();
        }
    }

    boolean statusOk() {
        return getNodeFromJson("status").asText().equals("OK");
    }

    <T extends LegiscanOperationable> T getPojoFromJson(Class<T> mappedClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.treeToValue(getNodeFromJson(mappedClass.getSimpleName().toLowerCase()),mappedClass);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public <T extends LegiscanOperationable> List<T> getPojoListFromJson(Class<T> mappedClass) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            String name = "";
            if (mappedClass.isAnnotationPresent(LegiscanJsonName.class)) {
                name = mappedClass.getAnnotation(LegiscanJsonName.class).name();
            } else {
                throw new IllegalArgumentException(mappedClass.toString() + " does not have a 'LegiscanJsonName' annotation");
            }
            return mapper.readValue(
                    getNodeFromJson(name + "s").toString(),
                    mapper.getTypeFactory().constructCollectionType(
                            List.class, mappedClass
            ));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private JsonNode getNodeFromJson(String node) {
        JsonNode jsonNode = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode fullNode = mapper.readTree(jsonString);
            jsonNode = fullNode.get(node);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonNode;
    }

    String getJsonString() {
        return jsonString;
    }
}
