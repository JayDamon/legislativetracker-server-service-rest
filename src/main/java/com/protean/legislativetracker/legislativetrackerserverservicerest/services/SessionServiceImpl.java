package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import com.protean.legislativetracker.legislativetrackerserverservicerest.repositories.SessionRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class SessionServiceImpl implements SessionService {

    private SessionRepository sessionRepository;

    public SessionServiceImpl(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public Set<LegislativeSession> getSessions() {
        Set<LegislativeSession> sessions = new HashSet<>();
        sessionRepository.findAll().iterator().forEachRemaining(sessions::add);
        return  sessions;
    }

    @Override
    public LegislativeSession getSessionById(int id) {
        return sessionRepository
                .findById(id)
                .orElseThrow(
                        () -> new IllegalArgumentException(id + ": This Session id was not found"));
    }
}
