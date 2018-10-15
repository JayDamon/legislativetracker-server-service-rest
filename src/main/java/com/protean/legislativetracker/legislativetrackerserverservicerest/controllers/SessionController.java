package com.protean.legislativetracker.legislativetrackerserverservicerest.controllers;

import com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession;
import com.protean.legislativetracker.legislativetrackerserverservicerest.services.SessionService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RequestMapping("/sessions")
@Controller
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    Set<LegislativeSession> getSessions() {
        return sessionService.getSessions();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    LegislativeSession getSessionById(@PathVariable Integer id) {
        return sessionService.getSessionById(id);
    }
}
