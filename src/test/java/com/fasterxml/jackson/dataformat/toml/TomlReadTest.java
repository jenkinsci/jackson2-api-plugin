package com.fasterxml.jackson.dataformat.toml;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;
import org.jvnet.hudson.test.RealJenkinsRule;

import java.io.Reader;
import java.io.StringReader;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TomlReadTest {

    @Rule
    public RealJenkinsRule rr = new RealJenkinsRule();

    @Test
    public void smokes() throws Throwable {
        rr.then(TomlReadTest::_smokes);
    }

    private static void _smokes(JenkinsRule r) throws Throwable {
        String content = "title = \"Title\"\n[section]\nvalue = 1\n";
        Reader tomlReader = new StringReader(content);
        Map data = new ObjectMapper(new TomlFactory()).readValue(tomlReader, Map.class);
        assertEquals(data.get("title"), "Title");
        Map section = (Map) data.get("section");
        assertNotNull(section);
        assertEquals(section.get("value"), 1);
    }
}
