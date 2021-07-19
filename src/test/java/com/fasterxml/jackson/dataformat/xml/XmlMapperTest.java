package com.fasterxml.jackson.dataformat.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.RealJenkinsRule;

import java.nio.charset.StandardCharsets;

public class XmlMapperTest {

    @Rule public RealJenkinsRule rr = new RealJenkinsRule();

    @Test
    public void smokes() throws Throwable {
        rr.then(XmlMapperTest::_smokes);
    }

    private static void _smokes(JenkinsRule r) throws Throwable {
        XmlMapper mapper = new XmlMapper();
        String content = "<foo><bar><id>123</id></bar></foo>";
        Foo foo = mapper.readValue(content.getBytes(StandardCharsets.UTF_8), Foo.class);
        assertNotNull(foo.getBar());
        assertEquals("123", foo.getBar().getId());
    }

    static class Foo {
        private Bar bar;

        public Bar getBar() {
            return bar;
        }

        public void setBar(Bar bar) {
            this.bar = bar;
        }
    }

    static class Bar {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
