package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;

import java.util.Set;

public interface SessionService {

    Set<LegislativeSession> getSessions();

    LegislativeSession getSessionById(int id);

}
