package com.fasterxml.jackson.jaxrs.json;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.RealJenkinsRule;

public class JacksonJsonProviderTest {

    @Rule public RealJenkinsRule rr = new RealJenkinsRule();

    @Test
    public void smokes() throws Throwable {
        rr.then(j -> new JacksonJsonProvider());
    }
}
