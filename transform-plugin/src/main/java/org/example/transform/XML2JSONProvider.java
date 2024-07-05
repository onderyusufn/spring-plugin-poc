package org.example.transform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

/**
 * Transform XML to JSON. This class is a service provider for the TransformPlugin.

 */
public class XML2JSONProvider implements TransformProvider {

    private final ObjectMapper objectMapper;
    private final XmlMapper xmlMapper;

    public XML2JSONProvider(ObjectMapper objectMapper, XmlMapper xmlMapper) {
        this.objectMapper = objectMapper;
        this.xmlMapper = xmlMapper;
    }

    @Override
    public String exec(String input) throws Exception {
        Object json = objectMapper.readValue(input, Object.class);
        return xmlMapper.writeValueAsString(json);
    }
}
