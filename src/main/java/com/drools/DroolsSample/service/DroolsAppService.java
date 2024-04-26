package com.drools.DroolsSample.service;

import com.drools.DroolsSample.model.User;
import org.apache.poi.ss.formula.functions.Rate;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DroolsAppService {
    @Autowired
    private KieContainer kieContainer;

    public Rate getRate(User applicantRequest){
        Rate rate = new Rate();
        KieSession kieSession = kieContainer.newKieSession();
        kieSession.setGlobal("rate", rate);
        kieSession.insert(applicantRequest);
        kieSession.fireAllRules();
        kieSession.dispose();
        return rate;
    }
}
