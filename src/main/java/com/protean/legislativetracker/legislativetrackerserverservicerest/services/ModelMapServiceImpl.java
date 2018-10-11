package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

public class ModelMapServiceImpl implements ModelMapService {

    private static Logger log = LoggerFactory.getLogger(ModelMapServiceImpl.class);

    @Override
    public <T> T getModelFromJson(Class<T> mappedClass, String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(json);
            return mapper.treeToValue(node, mappedClass);
        } catch (IOException e) {
            log.debug(e.getMessage());
            return null;
        }
    }

    @Override
    public <T> List<T> getListModelFromJson(Class<T> mappedClass, String json) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(
                    json,
                    mapper.getTypeFactory().constructCollectionType(
                            List.class, mappedClass)
            );
        } catch (IOException e) {
            log.debug(e.getMessage());
            return null;
        }
    }
}
