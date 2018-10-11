package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.protean.legislativetracker.legislativetrackerserverservicerest.utilities.PropertiesFile;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LegiscanHttpUri {

    private HttpURLConnection connection;

    public HttpURLConnection getConnection() {
        return connection;
    }

    public static class Builder {

        private String url;

        private String key;

        private HttpURLConnection connection;
        private Map<String, String> parameters;
        private LegiscanOperation operation;
        private String firstOpKey;
        private String firstOpVal;

        public Builder(LegiscanOperation operation) {
            if (operation.equals(LegiscanOperation.GET_STATE_LIST)) {
                setUpParams(operation);
            } else {
                throw new IllegalArgumentException(operation  +
                        ": must be accompanied by an initial set of parameters.");
            }
        }

        public Builder(LegiscanOperation operation, String firstOpKey, String firstOpVal) {
            if (operation.equals(LegiscanOperation.GET_STATE_LIST)) {
                setUpParams(operation);
            } else {
                setUpParams(operation, firstOpKey, firstOpVal);
            }
        }

        private void setUpParams(LegiscanOperation operation, String firstOpKey, String firstOpVal) {
            setBaseValues(operation);
            this.firstOpKey = firstOpKey;
            this.firstOpVal = firstOpVal;
        }

        private void setUpParams(LegiscanOperation operation) {
            setBaseValues(operation);
        }

        private void setBaseValues(LegiscanOperation operation) {
            PropertiesFile propertiesFile = new PropertiesFile();
            this.url = propertiesFile.getUrl();
            this.key = propertiesFile.getKey();
            this.operation = operation;
            this.parameters = new HashMap<>();
        }

        public Builder addParameter(String key, String value) {
            parameters.put(key, value);
            return this;
        }

        public LegiscanHttpUri build() {
            try {
                StringBuilder stringBuilder = appendInitialValues(
                        new StringBuilder(url)
                );
                if(parameters.size() > 0) {
                   stringBuilder.append(ParameterStringBuilder.getParamsString(parameters));
                }
                return new LegiscanHttpUri(createHttpRequest(stringBuilder.toString()));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return null;
            }
        }

        private StringBuilder appendInitialValues(StringBuilder stringBuilder) throws UnsupportedEncodingException {
            stringBuilder.append("/?")
                    .append(ParameterStringBuilder.addItem("key", key))
                    .append("&")
                    .append(ParameterStringBuilder.addItem("op", operation.getValue()));

            if (firstOpVal != null && firstOpKey != null) {
                stringBuilder.append("&")
                        .append(firstOpKey)
                        .append("=")
                        .append(firstOpVal);
            }

            return stringBuilder;

        }

        private HttpURLConnection createHttpRequest(String urlString) {
            try {
                URL url = new URL(urlString);
                return (HttpURLConnection) url.openConnection();
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    private LegiscanHttpUri(HttpURLConnection connection) {
        this.connection = connection;
    }

}
