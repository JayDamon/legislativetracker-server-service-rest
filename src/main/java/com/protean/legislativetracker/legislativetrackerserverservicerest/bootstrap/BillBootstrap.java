package com.protean.legislativetracker.legislativetrackerserverservicerest.bootstrap;

import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanHttpRequest;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanHttpUri;
import com.protean.legislativetracker.legislativetrackerserverservicerest.legiscan.LegiscanOperation;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class BillBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        LegiscanHttpUri legiscanHttpUri = new LegiscanHttpUri.Builder(LegiscanOperation.GET_MASTER_LIST, "state", "me").addParameter("session", "1258").build();
        LegiscanHttpRequest request = new LegiscanHttpRequest(legiscanHttpUri);
//        List<>
    }
}
