package com.protean.legislativetracker.legislativetrackerserverservicerest.services;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import com.protean.legislativetracker.legislativetrackerserverservicerest.repositories.SessionRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class SessionServiceTest {

    SessionServiceImpl sessionService;

    @Mock
    SessionRepository sessionRepository;

    @Before
    public void setUp() {
        sessionService = new SessionServiceImpl(sessionRepository);
    }

    @Test
    public void getSessionById_ValidId_SessionReturned() {
        LegislativeSession session = new LegislativeSession();
        session.setSessionId(1258);
        Optional<LegislativeSession> sessionOptional = Optional.of(session);

        when(sessionRepository.findById(anyInt())).thenReturn(sessionOptional);

        LegislativeSession sessionReturned = sessionService.getSessionById(1258);

        assertNotNull("Null session returned", sessionReturned);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getSessionById_InvalidId_SessionReturned() {
        LegislativeSession session = new LegislativeSession();
        session.setSessionId(1258);
        Optional<LegislativeSession> sessionOptional = Optional.empty();

        when(sessionRepository.findById(anyInt())).thenReturn(sessionOptional);

        LegislativeSession sessionReturned = sessionService.getSessionById(1222);
        verify(sessionRepository, times(1)).findById(anyInt());
        verify(sessionRepository, never()).findAll();
    }

    @Test
    public void getSessions_AllSessionsFound() {
        LegislativeSession session = new LegislativeSession();
        Set<LegislativeSession> sessionsData = new HashSet<>();
        sessionsData.add(session);

        when(sessionService.getSessions()).thenReturn(sessionsData);

        Set<LegislativeSession> sessions = sessionService.getSessions();

        assertEquals(sessions.size(), 1);
        verify(sessionRepository, times(1)).findAll();
        verify(sessionRepository, never()).findById(anyInt());
    }

}