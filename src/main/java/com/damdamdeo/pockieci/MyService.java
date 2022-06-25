package com.damdamdeo.pockieci;

import org.kie.api.KieServices;
import org.kie.api.builder.KieScanner;
import org.kie.api.runtime.KieContainer;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public MyService() {
        System.setProperty("kie.maven.settings.custom", "/home/damien/IdeaProjects/poc-kie-ci/settings.xml");
        KieServices ks = KieServices.Factory.get();
        KieContainer kContainer = ks.newKieContainer(ks.newReleaseId("com.sample", "poc", "1.0.0-SNAPSHOT"));

        KieScanner scanner = ks.newKieScanner(kContainer);
        //Configure the scanner to check for new versions every 10 seconds
        scanner.start(10_000);
    }

}
