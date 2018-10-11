package com.protean.legislativetracker.legislativetrackerserverservicerest.bootstrap;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanHttpRequest;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanHttpUri;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanModelMapper;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanOperation;
import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import com.protean.legislativetracker.legislativetrackerserverservicerest.repositories.SessionRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private SessionRepository sessionRepository;

    public SessionBootstrap(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LegiscanHttpUri legiscanHttpUri = new LegiscanHttpUri.Builder(
                LegiscanOperation.GET_SESSION_LIST, "state", "me").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttpUri);
        List<com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.LegislativeSession> legiscanLegislativeSessions =
                request.getPojoListFromJson(com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.LegislativeSession.class);
        List<LegislativeSession> legislativeSessions =
                LegiscanModelMapper.modelListToLegiscan(legiscanLegislativeSessions, LegislativeSession.class);
        sessionRepository.saveAll(legislativeSessions);
    }
}
