package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.Bill;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.model.LegislativeSession;
import org.junit.Before;
import org.junit.Test;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

import static org.junit.Assert.*;

public class LegiscanHttpRequestTest {

    private LegiscanHttpRequest request;
    private String expectedJson;

    @Before
    public void setUp() {
        expectedJson = "{\"status\":\"OK\",\"bill\":{\"bill_id\":897860,\"change_hash\":\"bb7e39c971b4c446b3a0fc3fc4913113\",\"session_id\":1258,\"session\":{\"session_id\":1258,\"session_name\":\"128th Legislature\",\"session_title\":\"128th Legislature\",\"year_start\":2017,\"year_end\":2018,\"special\":0},\"url\":\"https:\\/\\/legiscan.com\\/ME\\/bill\\/LD8\\/2017\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/legis\\/bills\\/display_ps.asp?LD=8&snum=128\",\"completed\":1,\"status\":4,\"status_date\":\"2018-06-21\",\"progress\":[{\"date\":\"2017-01-05\",\"event\":1},{\"date\":\"2017-01-05\",\"event\":9},{\"date\":\"2017-01-10\",\"event\":9},{\"date\":\"2017-06-08\",\"event\":2},{\"date\":\"2017-06-09\",\"event\":3},{\"date\":\"2018-06-21\",\"event\":4},{\"date\":\"2018-07-09\",\"event\":7}],\"state\":\"ME\",\"state_id\":19,\"bill_number\":\"LD8\",\"bill_type\":\"B\",\"bill_type_id\":\"1\",\"body\":\"H\",\"body_id\":47,\"current_body\":\"H\",\"current_body_id\":47,\"title\":\"An Act To Provide Training for Forest Rangers To Carry Firearms\",\"description\":\"An Act To Provide Training for Forest Rangers To Carry Firearms\",\"committee\":[],\"pending_committee_id\":0,\"history\":[{\"date\":\"2017-01-05\",\"action\":\"Committee on Agriculture, Conservation and Forestry suggested and ordered printed.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-01-05\",\"action\":\"The Bill was REFERRED to the Committee on AGRICULTURE, CONSERVATION AND FORESTRY.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":1},{\"date\":\"2017-01-05\",\"action\":\"Sent for concurrence. ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-01-10\",\"action\":\"REFERRED to the Committee on AGRICULTURE, CONSERVATION AND FORESTRY in concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":1},{\"date\":\"2017-06-08\",\"action\":\"Reports READ.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"On motion of Representative DUNPHY of Old Town, the Majority Ought to Pass as Amended Report was ACCEPTED.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"ROLL CALL NO. 274 (Yeas 132 - Nays 15 - Absent 3 - Excused 1)\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"The Bill was READ ONCE.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"Committee Amendment \\\"A\\\" (H-451) was READ and ADOPTED.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"Under suspension of the rules, the Bill was given its SECOND READING without REFERENCE to the Committee on Bills in the Second Reading.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-08\",\"action\":\"The Bill was PASSED TO BE ENGROSSED as Amended by Committee Amendment \\\"A\\\" (H-451).\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":1},{\"date\":\"2017-06-08\",\"action\":\"Sent for concurrence. ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-09\",\"action\":\"Reports Read\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-09\",\"action\":\"On motion by Senator DAVIS of Piscataquis the Majority Ought to Pass as Amended Report ACCEPTED. in concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-09\",\"action\":\"READ ONCE\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-09\",\"action\":\"Committee Amendment \\\"A\\\" (H-451) READ and ADOPTED\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-09\",\"action\":\"Under suspension of the Rules, READ A SECOND TIME and PASSED TO BE ENGROSSED AS AMENDED by Committee Amendment \\\"A\\\" (H-451) in concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":1},{\"date\":\"2017-06-12\",\"action\":\"PASSED TO BE ENACTED.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-12\",\"action\":\"Sent for concurrence. ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2017-06-14\",\"action\":\"On motion by Senator COLLINS of York Tabled until Later in Today's Session, pending ENACTMENT in concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-14\",\"action\":\"Unfinished Business\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-15\",\"action\":\"Taken from the table by the President ProTem\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-06-15\",\"action\":\"On motion by Senator KATZ of Kennebec PLACED ON THE SPECIAL APPROPRIATIONS TABLE pending ENACTMENT\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2017-08-02\",\"action\":\"CARRIED OVER to any Special or Regular Session of the 128th Legislature pursuant to Joint Order SP 601.\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-05-02\",\"action\":\"CARRIED OVER to any Special Session of the 128th Legislature pursuant to Joint Order SP 748.\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"On Motion by Senator  HAMPER of Oxford taken from the SPECIAL APPROPRIATIONS TABLE.\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"Under suspension of the Rules On further motion by Same Senator The Senate RECONSIDERED whereby the bill was  PASSED TO BE ENGROSSED as Amended by Committee Amendment \\\"A\\\" (H-451)\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"Under further suspension of the Rules On further motion by Same Senator The Senate RECONSIDERED whereby Committee Amendment \\\"A\\\" (H-451) was ADOPTED\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"On further motion by Same Senator Senate Amendment \\\"A\\\" (S-519) to Committee Amendment \\\"A\\\" (H-451) READ and ADOPTED\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"Committee Amendment \\\"A\\\" (H-451) as Amended by Senate Amendment \\\"A\\\" (S-519) thereto ADOPTED In NON-CONCURRENCE\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"PASSED TO BE ENGROSSED AS AMENDED BY Committee Amendment \\\"A\\\" (H-451) as Amended by Senate Amendment \\\"A\\\" (S-519) thereto In NON-CONCURRENCE\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-20\",\"action\":\"Sent down for concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"The House RECEDED and CONCURRED to PASSAGE TO BE ENGROSSED as Amended by Committee Amendment \\\"A\\\" (H-451) as Amended by Senate Amendment \\\"A\\\" (S-519) thereto.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"ROLL CALL NO. 681 (Yeas 118 - Nays 17 - Absent 16 - Excused 0)\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"PASSED TO BE ENACTED.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"Sent for concurrence. ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-06-21\",\"action\":\"PASSED TO BE ENACTED, in concurrence.\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":1},{\"date\":\"2018-06-21\",\"action\":\"Roll Call Ordered Roll Call Number 698 Yeas 30 - Nays 1 - Excused 4 - Absent 0\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0},{\"date\":\"2018-07-09\",\"action\":\"This Bill, having been returned by the Governor, together with objections to the same pursuant to Article IV, Part Third, Section 2 of the Constitution of the State of Maine, after reconsideration, the House proceeded to vote on the question: \\\"Shall this Bill become a law notwithstanding the objections of the Governor?\\\"\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-07-09\",\"action\":\"ROLL CALL NO. 715V 133 having voted in the affirmative and 9 in the negative, with 9 being absent, and accordingly it was the vote of the House that the Bill become a law notwithstanding the objections of the Governor, since two-thirds of the members of the House so voted.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-07-09\",\"action\":\"Sent for concurrence. ORDERED SENT FORTHWITH.\",\"chamber\":\"H\",\"chamber_id\":47,\"importance\":0},{\"date\":\"2018-07-09\",\"action\":\"LD 8 In Senate, July 9, 2018, this Bill, having been returned by the Governor, together with objections to the same pursuant to the provisions of the Constitution of the State of Maine, after reconsideration, the Senate proceeded to vote on the question: \\\"Shall this Bill become a law notwithstanding the objections of the Governor?\\\" 29 IN FAVOR and 4 AGAINST, accordingly it was the vote of the Senate that the Bill become law and the VETO was OVERRIDDEN.\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":1},{\"date\":\"2018-07-09\",\"action\":\"in concurrence\",\"chamber\":\"S\",\"chamber_id\":48,\"importance\":0}],\"sponsors\":[{\"people_id\":16786,\"person_hash\":\"t0g0kg1p\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"William Tuell\",\"first_name\":\"William\",\"middle_name\":\"R.\",\"last_name\":\"Tuell\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-139\",\"ftm_eid\":23424445,\"votesmart_id\":149293,\"opensecrets_id\":\"\",\"ballotpedia\":\"William_Tuell\",\"sponsor_type_id\":1,\"sponsor_order\":1,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":10352,\"person_hash\":\"zxrudm4l\",\"party_id\":2,\"party\":\"R\",\"role_id\":2,\"role\":\"Sen\",\"name\":\"Joyce Maker\",\"first_name\":\"Joyce\",\"middle_name\":\"A.\",\"last_name\":\"Maker\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"SD-006\",\"ftm_eid\":6683287,\"votesmart_id\":120967,\"opensecrets_id\":\"\",\"ballotpedia\":\"Joyce_Maker\",\"sponsor_type_id\":1,\"sponsor_order\":2,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":16631,\"person_hash\":\"8cfez3x6\",\"party_id\":1,\"party\":\"D\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Robert Alley\",\"first_name\":\"Robert\",\"middle_name\":\"W.\",\"last_name\":\"Alley\",\"suffix\":\"Sr.\",\"nickname\":\"\",\"district\":\"HD-138\",\"ftm_eid\":23424301,\"votesmart_id\":151337,\"opensecrets_id\":\"\",\"ballotpedia\":\"Robert_Alley\",\"sponsor_type_id\":1,\"sponsor_order\":3,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":17332,\"person_hash\":\"9q2njqjf\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Patrick Corey\",\"first_name\":\"Patrick\",\"middle_name\":\"W.\",\"last_name\":\"Corey\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-025\",\"ftm_eid\":23424353,\"votesmart_id\":151371,\"opensecrets_id\":\"\",\"ballotpedia\":\"Patrick_Corey\",\"sponsor_type_id\":1,\"sponsor_order\":4,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":16781,\"person_hash\":\"wwyzik12\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Robert Foley\",\"first_name\":\"Robert\",\"middle_name\":\"A.\",\"last_name\":\"Foley\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-007\",\"ftm_eid\":9937051,\"votesmart_id\":151401,\"opensecrets_id\":\"\",\"ballotpedia\":\"Robert_Foley\",\"sponsor_type_id\":2,\"sponsor_order\":5,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":16853,\"person_hash\":\"vg851lfj\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Sheldon Hanington\",\"first_name\":\"Sheldon\",\"middle_name\":\"Mark\",\"last_name\":\"Hanington\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-142\",\"ftm_eid\":23424446,\"votesmart_id\":151424,\"opensecrets_id\":\"\",\"ballotpedia\":\"Sheldon_Hanington\",\"sponsor_type_id\":2,\"sponsor_order\":6,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":18190,\"person_hash\":\"awpj9lr0\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Chris Johansen\",\"first_name\":\"Chris\",\"middle_name\":\"A.\",\"last_name\":\"Johansen\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-145\",\"ftm_eid\":39714277,\"votesmart_id\":170484,\"opensecrets_id\":\"\",\"ballotpedia\":\"Chris_Johansen\",\"sponsor_type_id\":2,\"sponsor_order\":7,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":15045,\"person_hash\":\"10gqyoff\",\"party_id\":1,\"party\":\"D\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Catherine Nadeau\",\"first_name\":\"Catherine\",\"middle_name\":\"M.\",\"last_name\":\"Nadeau\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-078\",\"ftm_eid\":6501370,\"votesmart_id\":121000,\"opensecrets_id\":\"\",\"ballotpedia\":\"Catherine_Nadeau\",\"sponsor_type_id\":2,\"sponsor_order\":8,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":10367,\"person_hash\":\"fjohvro6\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"John Picchiotti\",\"first_name\":\"John\",\"middle_name\":\"J.\",\"last_name\":\"Picchiotti\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-108\",\"ftm_eid\":6683504,\"votesmart_id\":121036,\"opensecrets_id\":\"\",\"ballotpedia\":\"John_Picchiotti\",\"sponsor_type_id\":2,\"sponsor_order\":9,\"committee_sponsor\":0,\"committee_id\":\"0\"},{\"people_id\":17585,\"person_hash\":\"ithl7rvq\",\"party_id\":2,\"party\":\"R\",\"role_id\":1,\"role\":\"Rep\",\"name\":\"Richard Pickett\",\"first_name\":\"Richard\",\"middle_name\":\"A.\",\"last_name\":\"Pickett\",\"suffix\":\"\",\"nickname\":\"\",\"district\":\"HD-116\",\"ftm_eid\":23424428,\"votesmart_id\":151481,\"opensecrets_id\":\"\",\"ballotpedia\":\"Richard_Pickett\",\"sponsor_type_id\":2,\"sponsor_order\":10,\"committee_sponsor\":0,\"committee_id\":\"0\"}],\"sasts\":[],\"subjects\":[{\"subject_id\":13012,\"subject_name\":\"Forestry\"},{\"subject_id\":22912,\"subject_name\":\"Forest Rangers\"}],\"texts\":[{\"doc_id\":1444527,\"date\":\"0000-00-00\",\"type\":\"Introduced\",\"type_id\":1,\"mime\":\"application\\/pdf\",\"mime_id\":2,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/text\\/LD8\\/id\\/1444527\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/legis\\/bills\\/getPDF.asp?paper=HP0009&item=1&snum=128\",\"text_size\":352391},{\"doc_id\":1631792,\"date\":\"0000-00-00\",\"type\":\"Amended\",\"type_id\":3,\"mime\":\"application\\/pdf\",\"mime_id\":2,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/text\\/LD8\\/id\\/1631792\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/legis\\/bills\\/getPDF.asp?paper=HP0009&item=2&snum=128\",\"text_size\":270364},{\"doc_id\":1810398,\"date\":\"0000-00-00\",\"type\":\"Amended\",\"type_id\":3,\"mime\":\"application\\/pdf\",\"mime_id\":2,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/text\\/LD8\\/id\\/1810398\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/legis\\/bills\\/getPDF.asp?paper=HP0009&item=4&snum=128\",\"text_size\":83227},{\"doc_id\":1813238,\"date\":\"0000-00-00\",\"type\":\"Chaptered\",\"type_id\":6,\"mime\":\"application\\/pdf\",\"mime_id\":2,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/text\\/LD8\\/id\\/1813238\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/legis\\/bills\\/getPDF.asp?paper=HP0009&item=5&snum=128\",\"text_size\":83013}],\"votes\":[{\"roll_call_id\":661120,\"date\":\"2017-06-08\",\"desc\":\"Acc Maj Otp As Amended Rep RC #274\",\"yea\":132,\"nay\":15,\"nv\":0,\"absent\":4,\"total\":151,\"passed\":1,\"chamber\":\"H\",\"chamber_id\":47,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/rollcall\\/LD8\\/id\\/661120\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/LawMakerWeb\\/rollcall.asp?ID=280062419&chamber=House&serialnumber=274\"},{\"roll_call_id\":766566,\"date\":\"2018-06-21\",\"desc\":\"Recede And Concur RC #681\",\"yea\":118,\"nay\":17,\"nv\":0,\"absent\":16,\"total\":151,\"passed\":1,\"chamber\":\"H\",\"chamber_id\":47,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/rollcall\\/LD8\\/id\\/766566\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/LawMakerWeb\\/rollcall.asp?ID=280062419&chamber=House&serialnumber=681\"},{\"roll_call_id\":766567,\"date\":\"2018-06-21\",\"desc\":\"Enactment RC #698\",\"yea\":30,\"nay\":1,\"nv\":0,\"absent\":4,\"total\":35,\"passed\":1,\"chamber\":\"S\",\"chamber_id\":48,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/rollcall\\/LD8\\/id\\/766567\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/LawMakerWeb\\/rollcall.asp?ID=280062419&chamber=Senate&serialnumber=698\"},{\"roll_call_id\":769854,\"date\":\"2018-07-09\",\"desc\":\"Reconsideration - Veto RC #715\",\"yea\":133,\"nay\":9,\"nv\":0,\"absent\":9,\"total\":151,\"passed\":1,\"chamber\":\"H\",\"chamber_id\":47,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/rollcall\\/LD8\\/id\\/769854\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/LawMakerWeb\\/rollcall.asp?ID=280062419&chamber=House&serialnumber=715\"},{\"roll_call_id\":769855,\"date\":\"2018-07-09\",\"desc\":\"Reconsideration - Veto RC #727\",\"yea\":29,\"nay\":4,\"nv\":0,\"absent\":2,\"total\":35,\"passed\":1,\"chamber\":\"S\",\"chamber_id\":48,\"url\":\"https:\\/\\/legiscan.com\\/ME\\/rollcall\\/LD8\\/id\\/769855\",\"state_link\":\"http:\\/\\/legislature.maine.gov\\/LawMakerWeb\\/rollcall.asp?ID=280062419&chamber=Senate&serialnumber=727\"}],\"amendments\":[],\"supplements\":[],\"calendar\":[{\"type_id\":1,\"type\":\"Hearing\",\"date\":\"2017-01-31\",\"time\":\"13:30\",\"location\":\"Cross Building, Room 214\",\"description\":\"Hearing\"},{\"type_id\":1,\"type\":\"Hearing\",\"date\":\"2017-02-07\",\"time\":\"13:15\",\"location\":\"Cross Building, Room 214\",\"description\":\"Hearing\"}]}}";
        LegiscanHttpUri legiscanHttp =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL, "id", "897860").build();
        this.request = new LegiscanHttpRequest(legiscanHttp);
    }

    @Test
    public void getJsonString_CorrectStringReturned() {
        String response = request.getJsonString();
        assertEquals(expectedJson, response);
    }

    @Test
    public void statusOK_JsonStrinReturnedOKStatus() {
        assertTrue(request.statusOk());
    }

    @Test
    public void getBillFromHttpRequest_BillJson_ReturnsMappedBill() {
        LegiscanHttpUri legiscanHttp =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL, "id", "897860").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttp);
        Bill bill = request.getPojoFromJson(Bill.class);
        Long expectedValue = 897860L;
        assertEquals(expectedValue, bill.getBillId());
    }

    @Test
    public void getBillFromHttpRequest_BillJson_ReturnsMappedBillWithCorrectTime() {
        LegiscanHttpUri legiscanHttp =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL, "id", "897860").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttp);
        Bill bill = request.getPojoFromJson(Bill.class);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        Time expectedTime = null;
        try {
            long ms = sdf.parse("13:30").getTime();
            expectedTime = new Time(ms);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Time finalExpectedTime = expectedTime;
        AtomicBoolean valueFound = new AtomicBoolean(false);
        bill.getCalendars().forEach(time -> {
            if (finalExpectedTime != null && time.getTime().getTime() == finalExpectedTime.getTime()) {
                valueFound.set(true);
            }
        });
        assertTrue(valueFound.get());
    }

    @Test
    public void statusOk_SessionList_StatusOk() {
        LegiscanHttpUri legiscanHttpUri = new LegiscanHttpUri.Builder(
                LegiscanOperation.GET_SESSION_LIST, "state", "me").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttpUri);
        assertTrue(request.statusOk());
    }

    @Test
    public void getPojoListFromJson_SessionJson_ReturnsMappedSessionList() {
        LegiscanHttpUri legiscanHttpUri = new LegiscanHttpUri.Builder(
                LegiscanOperation.GET_SESSION_LIST, "state", "me").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttpUri);
        List<LegislativeSession> legislativeSessions = request.getPojoListFromJson(LegislativeSession.class);
        assertEquals(new Integer(1258), legislativeSessions.get(0).getSessionId());
    }
}