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
                    assertEquals(19, s.getState().getStateId().intValue());
                    assertEquals(2017, s.getYearStart().intValue());
                    assertEquals(2018, s.getYearEnd().intValue());
                    assertFalse(s.getSpecial());
                    assertEquals("128th Legislature", s.getSessionName());
                    assertEquals("128th Legislature", s.getSessionTitle());
                    assertEquals("5f1928427d95f7da73aa827f803ec219", s.getSessionHash());
                    firstValFound = true;
                    break;
                case 1132:
                    assertEquals(19, s.getState().getStateId().intValue());
                    assertEquals(2015, s.getYearStart().intValue());
                    assertEquals(2016, s.getYearEnd().intValue());
                    assertFalse(s.getSpecial());
                    assertEquals("127th Legislature", s.getSessionName());
                    assertEquals("127th Legislature", s.getSessionTitle());
                    assertEquals("e8ce3086bdb61cd16f4a19371c9f0378", s.getSessionHash());
                    secondValFound = true;
                    break;
                case 1004:
                    assertEquals(19, s.getState().getStateId().intValue());
                    assertEquals(2013, s.getYearStart().intValue());
                    assertEquals(2014, s.getYearEnd().intValue());
                    assertFalse(s.getSpecial());
                    assertEquals("126th Legislature", s.getSessionName());
                    assertEquals("126th Legislature", s.getSessionTitle());
                    assertEquals("cfecf9d953053eed982090b4950590b6", s.getSessionHash());
                    thirdValFound = true;
                    break;
                case 81:
                    assertEquals(19, s.getState().getStateId().intValue());
                    assertEquals(2011, s.getYearStart().intValue());
                    assertEquals(2012, s.getYearEnd().intValue());
                    assertFalse(s.getSpecial());
                    assertEquals("125th Legislature", s.getSessionName());
                    assertEquals("125th Legislature", s.getSessionTitle());
                    assertEquals("f7a9b30cc6a42af780d905678b65b1a9", s.getSessionHash());
                    fourthValFound = true;
                    break;
                case 48:
                    assertEquals(19, s.getState().getStateId().intValue());
                    assertEquals(2009, s.getYearStart().intValue());
                    assertEquals(2010, s.getYearEnd().intValue());
                    assertFalse(s.getSpecial());
                    assertEquals("124th Legislature", s.getSessionName());
                    assertEquals("124th Legislature", s.getSessionTitle());
                    assertEquals("cbee568f7906a4530387560cc1d0aa67", s.getSessionHash());
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
