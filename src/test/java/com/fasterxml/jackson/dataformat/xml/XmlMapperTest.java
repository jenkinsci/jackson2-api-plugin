package com.fasterxml.jackson.dataformat.xml;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.junit.jupiter.WithJenkins;

import java.nio.charset.StandardCharsets;

@WithJenkins
class XmlMapperTest {

    @Test
    void smokes(@SuppressWarnings("unused") JenkinsRule r) throws Throwable {
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
