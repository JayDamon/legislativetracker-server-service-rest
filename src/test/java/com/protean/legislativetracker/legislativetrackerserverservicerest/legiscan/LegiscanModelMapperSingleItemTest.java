package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.Bill;
import com.protean.legislativetracker.legislativetrackerserverservicerest.model.*;
import org.junit.Before;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.TimeZone;

import static org.junit.Assert.*;

public class LegiscanModelMapperSingleItemTest {

    private com.protean.legislativetracker.legislativetrackerserverservicerest.model.Bill bill;
    private DateFormat dtf;

    @Before
    public void setUp() {
        LegiscanHttpUri legiscanHttp =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL, "id", "897860").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttp);
        Bill bill = request.getPojoFromJson(Bill.class);
        this.bill = LegiscanModelMapper.modelToLegiscan(bill, com.protean.legislativetracker.legislativetrackerserverservicerest.model.Bill.class);
        dtf = new SimpleDateFormat("yyyy-MM-dd");
        dtf.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    @Test
    public void billModelToLegiscan_Bill_IdMapped() {
        assertEquals(new Long(897860), bill.getBillId());
    }

    @Test
    public void billModelToLegiscan_Bill_StateIdMapped() {
        assertEquals(new Integer(19), bill.getState().getStateId());
    }

    @Test
    public void billModelToLegiscan_Bill_StateNameMapped() {
        assertEquals("ME", bill.getState().getStateName());
    }

    @Test
    public void billModelToLegiscan_BillSession_SessionMapped() {
        assertEquals(new Integer(1258), bill.getLegislativeSession().getSessionId());
    }

    @Test
    public void billModelToLegiscan_BillSession_SessionNameMapped() {
        assertEquals("128th Legislature", bill.getLegislativeSession().getSessionName());
    }

    @Test
    public void billModelToLegiscan_BillSession_SessionTitleMapped() {
        assertEquals("128th Legislature", bill.getLegislativeSession().getSessionTitle());
    }

    @Test
    public void billModelToLegiscan_BillSession_SessionYearStartMapped() {
        assertEquals(new Integer(2017), bill.getLegislativeSession().getYearStart());
    }

    @Test
    public void billModelToLegiscan_BillSession_SessionYearEndMapped() {
        assertEquals(new Integer(2018), bill.getLegislativeSession().getYearEnd());
    }

    @Test
    public void billModelToLegiscan_BillBody_BodyIdMapped() {
        assertEquals(new Integer(47), bill.getBody().getId());
    }


    @Test
    public void billModelToLegiscan_BillBody_BodyNameShortMapped() {
        assertEquals("H", bill.getBody().getBodyShort());
    }

    @Test
    public void billModelToLegiscan_BillBody_CurrentBodyIdMapped() {
        assertEquals(new Integer(47), bill.getCurrentBody().getId());
    }

    @Test
    public void billModelToLegiscan_BillBody_CurrentBodyNameShortMapped() {
        assertEquals("H", bill.getCurrentBody().getBodyShort());
    }

    @Test
    public void billModelToLegiscan_BillType_BillTypeIDMapped() {
        assertEquals(new Integer(1), bill.getType().getId());
    }

    @Test
    public void billModelToLegiscan_BillType_BillTypeAbbrMapped() {
        assertEquals("B", bill.getType().getBillTypeAbbreviation());
    }

    @Test
    public void billModelToLegiscan_BillType_BillTypeNameNull() {
        assertNull(bill.getType().getBillTypeName());
    }

    @Test
    public void billModelToLegiscan_Bill_BillNumberMapped() {
        assertEquals("LD8", bill.getBillNumber());
    }

    @Test
    public void billModelToLegiscan_BillStatus_StatusMapped() {
        assertEquals(new Integer(4), bill.getStatus().getId());
    }

    @Test
    public void billModelToLegiscan_BillStatus_StatusDateMapped() {
        assertEquals("2018-06-21", dtf.format(bill.getStatusDate()));
    }

    @Test
    public void billModelToLegiscan_BillUrl_StateLinkMapped() throws MalformedURLException {
        assertEquals(new URL("http://legislature.maine.gov/legis/bills/display_ps.asp?LD=8&snum=128"), bill.getStateUrl());
    }

    @Test
    public void billModelToLegiscan_BillUrl_LegiscanUrlMapped() throws MalformedURLException {
        assertEquals(new URL("https://legiscan.com/ME/bill/LD8/2017"), bill.getLegiscanUrl());
    }

    @Test
    public void billModelToLegiscan_BillChangeHash_ChangeHashMapped() {
        assertEquals("bb7e39c971b4c446b3a0fc3fc4913113", bill.getChangeHash());
    }

    @Test
    public void billModelToLegiscan_BillTitle_BillTitleMapped() {
        assertEquals("An Act To Provide Training for Forest Rangers To Carry Firearms", bill.getTitle());
    }

    @Test
    public void billModelToLegiscan_BillDescription_DescriptionMapped() {
        assertEquals("An Act To Provide Training for Forest Rangers To Carry Firearms", bill.getDescription());
    }

    @Test
    public void billModelToLegiscan_BillPendingCommitteeId_PendingCommitteeIdMapped() {
        assertEquals(new Integer(0), bill.getPendingCommittee().getId());
    }

    @Test
    public void billModelToLegiscan_BillProgress_ProgressMapped() {
        Set<BillProgress> billProgressSet = bill.getProgress();
        boolean progressOne = false;
        boolean progressTwo = false;
        boolean progressThree = false;
        boolean progressFour = false;
        boolean progressFive = false;
        boolean progressSix = false;
        boolean progressSeven = false;

        for (BillProgress p : billProgressSet) {
            if (dtf.format(p.getProgressDate()).equals("2017-01-05")
                    && p.getId().getProgressEventId() == 1) progressOne = true;
            if (dtf.format(p.getProgressDate()).equals("2017-01-05")
                    && p.getId().getProgressEventId() == 9) progressTwo = true;
            if (dtf.format(p.getProgressDate()).equals("2017-01-10")
                    && p.getId().getProgressEventId() == 9) progressThree = true;
            if (dtf.format(p.getProgressDate()).equals("2017-06-08")
                    && p.getId().getProgressEventId() == 2) progressFour = true;
            if (dtf.format(p.getProgressDate()).equals("2017-06-09")
                    && p.getId().getProgressEventId() == 3) progressFive = true;
            if (dtf.format(p.getProgressDate()).equals("2018-06-21")
                    && p.getId().getProgressEventId() == 4) progressSix = true;
            if (dtf.format(p.getProgressDate()).equals("2018-07-09")
                    && p.getId().getProgressEventId() == 7) progressSeven = true;
        }
        assertTrue(progressOne);
        assertTrue(progressTwo);
        assertTrue(progressThree);
        assertTrue(progressFour);
        assertTrue(progressFive);
        assertTrue(progressSix);
        assertTrue(progressSeven);
    }

    @Test
    public void billModelToLegiscan_BillHistory_SetHasAllElements() {
        assertEquals(44, bill.getHistories().size());
    }

    @Test
    public void billModelToLegiscan_BillHistory_HistoryMapped() {
        Set<BillHistory> billProgressSet = bill.getHistories();
        boolean progressFirst = false;
        boolean progressMiddle = false;
        boolean progressLast = false;

        for (BillHistory p : billProgressSet) {
            if (dtf.format(p.getDate()).equals("2017-01-05")
                    && p.getAction().equals("Committee on Agriculture, Conservation and Forestry suggested and ordered printed.")
                    && p.getBody().getBodyShort().equals("H")
                    && p.getBody().getId() == 47
                    && p.getHistoryMajor() == 0) progressFirst = true;
            if (dtf.format(p.getDate()).equals("2017-06-12")
                    && p.getAction().equals("Sent for concurrence. ORDERED SENT FORTHWITH.")
                    && p.getBody().getBodyShort().equals("H")
                    && p.getBody().getId() == 47
                    && p.getHistoryMajor() == 0) progressMiddle = true;
            if (dtf.format(p.getDate()).equals("2018-07-09")
                    && p.getAction().equals("in concurrence")
                    && p.getBody().getBodyShort().equals("S")
                    && p.getBody().getId() == 48
                    && p.getHistoryMajor() == 0) progressLast = true;
        }
        assertTrue(progressFirst);
        assertTrue(progressMiddle);
        assertTrue(progressLast);
    }

    @Test
    public void billModelToLegiscan_BillSponsors_SetHasAllElements() {
        assertEquals(10, bill.getSponsors().size());
    }

    @Test
    public void billModelToLegiscan_BillSponsors_SponsorsMapped() {
        Set<BillSponsor> billProgressSet = bill.getSponsors();
        boolean sponsorFound = false;
        for (BillSponsor p : billProgressSet) {
            if (p.getPerson().getId() == 16786) {
                assertEquals("t0g0kg1p", p.getPerson().getPersonHash());
                assertEquals(new Integer(2), p.getPerson().getParty().getId());
                assertEquals(new Character('R'), p.getPerson().getParty().getAbbreviation());
                assertEquals(new Integer(1), p.getPerson().getRole().getId());
                assertEquals("Rep", p.getPerson().getRole().getRoleAbbreviation());
                assertEquals("William Tuell", p.getPerson().getName());
                assertEquals("William", p.getPerson().getFirstName());
                assertEquals("R.", p.getPerson().getMiddleName());
                assertEquals("Tuell", p.getPerson().getLastName());
                assertEquals("", p.getPerson().getSuffix());
                assertEquals("", p.getPerson().getNickname());
                assertEquals("HD-139", p.getPerson().getDistrict());
                assertEquals(new Long(23424445), p.getPerson().getFollowTheMoneyId());
                assertEquals(new Long(149293), p.getPerson().getVoteSmartId());
                assertNull(p.getPerson().getOpenSecretsId());
                assertEquals("William_Tuell", p.getPerson().getBallotpedia());
                assertEquals(new Integer(1), p.getSponsorType().getId());
                assertEquals(new Integer(1), p.getId().getSponsorOrder());
                sponsorFound = true;
            }
        }
        assertTrue(sponsorFound);
    }

    @Test
    public void billModelToLegiscan_BillSubject_SubjectMapped() {
        Set<Subject> subjectSet = bill.getSubjects();
        boolean subjectOneFound = false;
        boolean subjectTwoFound = false;
        for (Subject s : subjectSet) {
            if (s.getId() == 13012) {
                assertEquals("Forestry", s.getName());
                subjectOneFound = true;
            }
            if (s.getId() == 22912) {
                assertEquals("Forest Rangers", s.getName());
                subjectTwoFound = true;
            }
        }
        assertTrue(subjectOneFound);
        assertTrue(subjectTwoFound);
    }

    @Test
    public void billModelToLegiscan_BillText_TextsMapped() throws MalformedURLException {
        Set<BillText> texts = bill.getTexts();
        boolean textOneFound = false;
        boolean textTwoFound = false;
        boolean textThreeFound = false;
        boolean textFourFound = false;
        for (BillText t : texts) {
            if (t.getTextId() == 1444527) {
//                assertEquals("0000-00-00", dtf.format(t.getDate()));
                assertEquals("Introduced", t.getTextType().getName());
                assertEquals(new Integer(1), t.getTextType().getId());
                assertEquals("application/pdf", t.getMimeType().getType());
                assertEquals(new Integer(2), t.getMimeType().getId());
                assertEquals(new URL("https://legiscan.com/ME/text/LD8/id/1444527"), t.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/legis/bills/getPDF.asp?paper=HP0009&item=1&snum=128"), t.getStateUrl());
                textOneFound = true;
            }
            if (t.getTextId() == 1631792) {
//                assertEquals("0000-00-00", dtf.format(t.getDate()));
                assertEquals("Amended", t.getTextType().getName());
                assertEquals(new Integer(3), t.getTextType().getId());
                assertEquals("application/pdf", t.getMimeType().getType());
                assertEquals(new Integer(2), t.getMimeType().getId());
                assertEquals(new URL("https://legiscan.com/ME/text/LD8/id/1631792"), t.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/legis/bills/getPDF.asp?paper=HP0009&item=2&snum=128"), t.getStateUrl());
                textTwoFound = true;
            }
            if (t.getTextId() == 1810398) {
//                assertEquals("0000-00-00", dtf.format(t.getDate()));
                assertEquals("Amended", t.getTextType().getName());
                assertEquals(new Integer(3), t.getTextType().getId());
                assertEquals("application/pdf", t.getMimeType().getType());
                assertEquals(new Integer(2), t.getMimeType().getId());
                assertEquals(new URL("https://legiscan.com/ME/text/LD8/id/1810398"), t.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/legis/bills/getPDF.asp?paper=HP0009&item=4&snum=128"), t.getStateUrl());
                textThreeFound = true;
            }
            if (t.getTextId() == 1813238) {
//                assertEquals("0000-00-00", dtf.format(t.getDate()));
                assertEquals("Chaptered", t.getTextType().getName());
                assertEquals(new Integer(6), t.getTextType().getId());
                assertEquals("application/pdf", t.getMimeType().getType());
                assertEquals(new Integer(2), t.getMimeType().getId());
                assertEquals(new URL("https://legiscan.com/ME/text/LD8/id/1813238"), t.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/legis/bills/getPDF.asp?paper=HP0009&item=5&snum=128"), t.getStateUrl());
                textFourFound = true;
            }
        }
        assertTrue(textOneFound);
        assertTrue(textTwoFound);
        assertTrue(textThreeFound);
        assertTrue(textFourFound);
    }

    @Test
    public void billModelToLegiscan_BillVote_VotesMapped() throws MalformedURLException {
        Set<BillVote> votes = bill.getVotes();
        boolean voteOneFound = false;
        boolean voteTwoFound = false;
        boolean voteThreeFound = false;
        boolean voteFourFound = false;
        boolean voteFiveFound = false;
        for (BillVote v : votes) {
            if (v.getVoteId() == 661120) {
                assertEquals("2017-06-08", dtf.format(v.getDate()));
                assertEquals("Acc Maj Otp As Amended Rep RC #274", v.getDescription());
                assertEquals(new Integer(132), v.getYea());
                assertEquals(new Integer(15), v.getNay());
                assertEquals(new Integer(0), v.getNv());
                assertEquals(new Integer(4), v.getAbsent());
                assertEquals(new Integer(151), v.getTotal());
                assertTrue(v.getPassed());
                assertEquals(new Character('H'), v.getBody().getAbbreviation());
                assertEquals(new Integer(47), v.getBody().getId());
                assertEquals(new URL("https://legiscan.com/ME/rollcall/LD8/id/661120"), v.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/LawMakerWeb/rollcall.asp?ID=280062419&chamber=House&serialnumber=274"), v.getStateUrl());
                voteOneFound = true;
            }
            if (v.getVoteId() == 766566) {
                assertEquals("2018-06-21", dtf.format(v.getDate()));
                assertEquals("Recede And Concur RC #681", v.getDescription());
                assertEquals(new Integer(118), v.getYea());
                assertEquals(new Integer(17), v.getNay());
                assertEquals(new Integer(0), v.getNv());
                assertEquals(new Integer(16), v.getAbsent());
                assertEquals(new Integer(151), v.getTotal());
                assertTrue(v.getPassed());
                assertEquals(new Character('H'), v.getBody().getAbbreviation());
                assertEquals(new Integer(47), v.getBody().getId());
                assertEquals(new URL("https://legiscan.com/ME/rollcall/LD8/id/766566"), v.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/LawMakerWeb/rollcall.asp?ID=280062419&chamber=House&serialnumber=681"), v.getStateUrl());
                voteTwoFound = true;
            }
            if (v.getVoteId() == 766567) {
                assertEquals("2018-06-21", dtf.format(v.getDate()));
                assertEquals("Enactment RC #698", v.getDescription());
                assertEquals(new Integer(30), v.getYea());
                assertEquals(new Integer(1), v.getNay());
                assertEquals(new Integer(0), v.getNv());
                assertEquals(new Integer(4), v.getAbsent());
                assertEquals(new Integer(35), v.getTotal());
                assertTrue(v.getPassed());
                assertEquals(new Character('S'), v.getBody().getAbbreviation());
                assertEquals(new Integer(48), v.getBody().getId());
                assertEquals(new URL("https://legiscan.com/ME/rollcall/LD8/id/766567"), v.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/LawMakerWeb/rollcall.asp?ID=280062419&chamber=Senate&serialnumber=698"), v.getStateUrl());
                voteThreeFound = true;
            }
            if (v.getVoteId() == 769854) {
                assertEquals("2018-07-09", dtf.format(v.getDate()));
                assertEquals("Reconsideration - Veto RC #715", v.getDescription());
                assertEquals(new Integer(133), v.getYea());
                assertEquals(new Integer(9), v.getNay());
                assertEquals(new Integer(0), v.getNv());
                assertEquals(new Integer(9), v.getAbsent());
                assertEquals(new Integer(151), v.getTotal());
                assertTrue(v.getPassed());
                assertEquals(new Character('H'), v.getBody().getAbbreviation());
                assertEquals(new Integer(47), v.getBody().getId());
                assertEquals(new URL("https://legiscan.com/ME/rollcall/LD8/id/769854"), v.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/LawMakerWeb/rollcall.asp?ID=280062419&chamber=House&serialnumber=715"), v.getStateUrl());
                voteFourFound = true;
            }
            if (v.getVoteId() == 769855) {
                assertEquals("2018-07-09", dtf.format(v.getDate()));
                assertEquals("Reconsideration - Veto RC #727", v.getDescription());
                assertEquals(new Integer(29), v.getYea());
                assertEquals(new Integer(4), v.getNay());
                assertEquals(new Integer(0), v.getNv());
                assertEquals(new Integer(2), v.getAbsent());
                assertEquals(new Integer(35), v.getTotal());
                assertTrue(v.getPassed());
                assertEquals(new Character('S'), v.getBody().getAbbreviation());
                assertEquals(new Integer(48), v.getBody().getId());
                assertEquals(new URL("https://legiscan.com/ME/rollcall/LD8/id/769855"), v.getLegiscanUrl());
                assertEquals(new URL("http://legislature.maine.gov/LawMakerWeb/rollcall.asp?ID=280062419&chamber=Senate&serialnumber=727"), v.getStateUrl());
                voteFiveFound = true;
            }
        }
        assertTrue(voteOneFound);
        assertTrue(voteTwoFound);
        assertTrue(voteThreeFound);
        assertTrue(voteFourFound);
        assertTrue(voteFiveFound);
    }

    @Test
    public void billModelToLegiscan_BillCalendar_CalendarsMapped() {
        Set<BillCalendar> calendars = bill.getCalendars();
        boolean voteOneFound = false;
        boolean voteTwoFound = false;
        SimpleDateFormat fmt = new SimpleDateFormat("HH:mm");
        for (BillCalendar c : calendars) {
            if (dtf.format(c.getDate()).equals("2017-01-31")) {
//                assertEquals(new Long(897860), c.getSessionId().getBill().getBillId()); //TODO Fix the fact that i cant get the bill id
                assertEquals("Hearing", c.getEventType().getDescription());
                assertEquals("13:30", fmt.format(c.getTime()));
                assertEquals("Cross Building, Room 214", c.getLocation());
                assertEquals("Hearing", c.getDescription());
                voteOneFound = true;
            }
            if (dtf.format(c.getDate()).equals("2017-02-07")) {
//                assertEquals(new Long(897860), c.getSessionId().getBill().getBillId());
                assertEquals("Hearing", c.getEventType().getDescription());
                assertEquals("13:15", fmt.format(c.getTime()));
                assertEquals("Cross Building, Room 214", c.getLocation());
                assertEquals("Hearing", c.getDescription());
                voteTwoFound = true;
            }
        }
        assertTrue(voteOneFound);
        assertTrue(voteTwoFound);
    }
}