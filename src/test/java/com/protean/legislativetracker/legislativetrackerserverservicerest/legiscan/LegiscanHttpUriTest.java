package com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan;

import org.junit.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class LegiscanHttpUriTest {

    private URL expectedURL;

    @Test
    public void createHttpRequest_NormalConditions_UrlCorrect() throws MalformedURLException {
        LegiscanHttpUri legiscanHttp =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL, "id", "897860").build();
        assertEquals(new URL("https://api.legiscan.com/?key=d8934a599e5330ecd6442d34332eb1bc&op=getBill&id=897860"),
                legiscanHttp.getConnection().getURL());
    }

    @Test
    public void creatHttpRequest_NonParameterizedOperation_UrlCorrect() throws MalformedURLException {
        LegiscanHttpUri legiscanHttpUri =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_STATE_LIST).build();
        assertEquals(new URL("https://api.legiscan.com/?key=d8934a599e5330ecd6442d34332eb1bc&op=getStateList"),
                legiscanHttpUri.getConnection().getURL());
    }

    @Test(expected = IllegalArgumentException.class)
    public void createHttpRequest_ParameterizedOperationWithoutParameters_ThrowsIncorrectParameterException() {
        new LegiscanHttpUri.Builder(LegiscanOperation.GET_BILL).build();
    }

    @Test
    public void createHttpRequest_NonParameterizedOperationWithParameters_UrlCorrect() throws MalformedURLException {
        LegiscanHttpUri legiscanHttpUri =
                new LegiscanHttpUri.Builder(LegiscanOperation.GET_STATE_LIST, "irrelivent", "alsoIrrelivent").build();
        assertEquals(new URL("https://api.legiscan.com/?key=d8934a599e5330ecd6442d34332eb1bc&op=getStateList"),
                legiscanHttpUri.getConnection().getURL());
    }

    @Test
    public void test() {
        try {
            URL url = new URL("https://Httpasldfkjasdl;kfj");
            url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}