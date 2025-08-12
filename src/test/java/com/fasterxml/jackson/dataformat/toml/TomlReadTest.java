package com.fasterxml.jackson.dataformat.toml;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.jvnet.hudson.test.junit.jupiter.RealJenkinsExtension;

import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TomlReadTest {

    @RegisterExtension
    private final RealJenkinsExtension extension = new RealJenkinsExtension();

    @Test
    void smokes() throws Throwable {
        extension.then(r -> {
            String content = "title = \"Title\"\n[section]\nvalue = 1\n";
            Reader tomlReader = new StringReader(content);
            Map data = new ObjectMapper(new TomlFactory()).readValue(tomlReader, Map.class);
            assertEquals("Title", data.get("title"));
            Map section = (Map) data.get("section");
            assertNotNull(section);
            assertEquals(1, section.get("value"));
        });
    }
}
