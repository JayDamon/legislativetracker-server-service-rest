package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.markerinterface.LegiscanOperationable;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class LegiscanModelMapper {

    public static <T> T modelToLegiscan(
            LegiscanOperationable startType, Class<T> destinationType) {
        ModelMapper mapper = new ModelMapper();
        return mapper.map(startType, destinationType);
    }

    public static <T> List<T> modelListToLegiscan(
            List<? extends LegiscanOperationable> startType, Class<T> destinationType) {
        List<T> destinationList = new ArrayList<>();
        ModelMapper mapper = new ModelMapper();
        for (LegiscanOperationable o : startType) {
            destinationList.add(mapper.map(o, destinationType));
        }
        return destinationList;
    }
}
