package com.protean.legislativetracker.legislativetrackerserverservicerest.controllers;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import com.protean.legislativetracker.legislativetrackerserverservicerest.model.State;
import com.protean.legislativetracker.legislativetrackerserverservicerest.services.ModelMapServiceImpl;
import com.protean.legislativetracker.legislativetrackerserverservicerest.services.SessionService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class SessionControllerTest {

    @Mock
    SessionService sessionService;

    private SessionController controller;

    @Before
    public void setUp() {
        controller = new SessionController(sessionService);
    }

    @Test
    public void getSessions_FindAll_ReturnsSession() throws Exception {

        Set<LegislativeSession> sessions = new HashSet<>();
        LegislativeSession session = new LegislativeSession();
        session.setSessionId(1258);
        sessions.add(session);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(sessionService.getSessions()).thenReturn(sessions);

        MvcResult result = mockMvc.perform(get("/sessions/"))
                .andExpect(status().isOk())
                .andDo(print())
                .andReturn();

        List<LegislativeSession> returnedSessions =
                new ModelMapServiceImpl().getListModelFromJson(
                        LegislativeSession.class, result.getResponse().getContentAsString());
        LegislativeSession returnedSession = returnedSessions.get(0);
        assertEquals(1258, returnedSession.getSessionId().intValue());
    }

    @Test
    public void getSessionById() throws Exception {

        LegislativeSession session = new LegislativeSession();
        session.setSessionId(1258);

        State state = new State();
        state.setAbbreviation("me");

        session.setState(state);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        when(sessionService.getSessionById(anyInt())).thenReturn(session);

        MvcResult result = mockMvc.perform(get("/sessions/1258/"))
                .andExpect(status().isOk())
                .andReturn();

        LegislativeSession returnedSession =
                new ModelMapServiceImpl().getModelFromJson(
                        LegislativeSession.class, result.getResponse().getContentAsString());

        assertEquals(1258, returnedSession.getSessionId().intValue());
        assertEquals("me", returnedSession.getState().getAbbreviation());
    }
}