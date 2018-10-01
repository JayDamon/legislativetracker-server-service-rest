package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import java.util.List;

public interface ModelMapService {

    <T> T getModelFromJson(Class<T> mappedClass, String json);

    <T> List<T> getListModelFromJson(Class<T> mappedClass, String json);

}
