package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.LegislativeSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LegiscanModelMapperListTest {

    private List<com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession> legislativeLegislativeSessions;

    @Before
    public void setUp() {
        LegiscanHttpUri legiscanHttpUri =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_SESSION_LIST, "state", "me").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttpUri);
        List<LegislativeSession> legislativeSessions = request.getPojoListFromJson(LegislativeSession.class);
        this.legislativeLegislativeSessions = LegiscanModelMapper.modelListToLegiscan(legislativeSessions,
                com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession.class);
    }

    @Test
    public void modelListToLegiscan_MapRequestToModel_MapSuccessful() {
        boolean firstValFound = false;
        boolean secondValFound = false;
        boolean thirdValFound = false;
        boolean fourthValFound = false;
        boolean fifthValFound = false;

        for (com.protean.legislativetracker.legislativetrackerserverservicerest.model.LegislativeSession s : legislativeLegislativeSessions) {
            switch (s.getSessionId()) {
                case 1258:
                    assertEquals(new Integer(19), s.getState().getStateId());
                    assertEquals(new Integer(2017), s.getYearStart());
                    assertEquals(new Integer(2018), s.getYearEnd());
                    assertFalse(s.getSpecial());
                    assertEquals("128th Legislature", s.getSessionName());
                    assertEquals("128th Legislature", s.getSessionTitle());
//                    assertEquals("6e7e2ce10a18bbf1da8b5db6a09a6397", s.hashCode()); //ToDo Maybe add hash code?
                    firstValFound = true;
                    break;
                case 1132:
                    assertEquals(new Integer(19), s.getState().getStateId());
                    assertEquals(new Integer(2015), s.getYearStart());
                    assertEquals(new Integer(2016), s.getYearEnd());
                    assertFalse(s.getSpecial());
                    assertEquals("127th Legislature", s.getSessionName());
                    assertEquals("127th Legislature", s.getSessionTitle());
                    secondValFound = true;
                    break;
                case 1004:
                    assertEquals(new Integer(19), s.getState().getStateId());
                    assertEquals(new Integer(2013), s.getYearStart());
                    assertEquals(new Integer(2014), s.getYearEnd());
                    assertFalse(s.getSpecial());
                    assertEquals("126th Legislature", s.getSessionName());
                    assertEquals("126th Legislature", s.getSessionTitle());
                    thirdValFound = true;
                    break;
                case 81:
                    assertEquals(new Integer(19), s.getState().getStateId());
                    assertEquals(new Integer(2011), s.getYearStart());
                    assertEquals(new Integer(2012), s.getYearEnd());
                    assertFalse(s.getSpecial());
                    assertEquals("125th Legislature", s.getSessionName());
                    assertEquals("125th Legislature", s.getSessionTitle());
                    fourthValFound = true;
                    break;
                case 48:
                    assertEquals(new Integer(19), s.getState().getStateId());
                    assertEquals(new Integer(2009), s.getYearStart());
                    assertEquals(new Integer(2010), s.getYearEnd());
                    assertFalse(s.getSpecial());
                    assertEquals("124th Legislature", s.getSessionName());
                    assertEquals("124th Legislature", s.getSessionTitle());
                    fifthValFound = true;
                    break;
            }
        }
        assertTrue(firstValFound);
        assertTrue(secondValFound);
        assertTrue(thirdValFound);
        assertTrue(fourthValFound);
        assertTrue(fifthValFound);
    }

}
