package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.Bill;

import java.util.List;
import java.util.Map;

public interface LegiscanRetrievalService {

    Bill retrieveBillFromLegiscan(int billId);

    List<Bill> retrieveBillsFromLegiscan(Map<String, String>... operationAndValue);

}
