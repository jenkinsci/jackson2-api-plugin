package com.fasterxml.jackson.dataformat.xml;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.RealJenkinsRule;

import java.nio.charset.StandardCharsets;

import javax.xml.stream.XMLInputFactory;

public class XmlMapperTest {

    @Rule public RealJenkinsRule rr = new RealJenkinsRule();

    @Test
    public void smokes() throws Throwable {
        rr.then(XmlMapperTest::_smokes);
    }

    private static void _smokes(JenkinsRule r) throws Throwable {
        XMLInputFactory inputFactory =
                XMLInputFactory.newFactory(
                        XMLInputFactory.class.getName(), XmlFactory.class.getClassLoader());
        XmlFactory factory = new XmlFactory(inputFactory);
        XmlMapper mapper = new XmlMapper(factory);
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
