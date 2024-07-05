package org.example.transform;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.example.PluginFactory;
import org.example.Provider;
import org.example.ProviderFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Factory for creating XML2JSONProvider instances. This class is a service provider for the TransformPlugin.
 */
@Component
public class XML2JSONProviderFactory implements TransformProviderFactory {
    private final ObjectMapper objectMapper;
    private final XmlMapper xmlMapper;

    public XML2JSONProviderFactory(ObjectMapper objectMapper, XmlMapper xmlMapper) {
        this.objectMapper = objectMapper;
        this.xmlMapper = xmlMapper;
    }
    @Override
    public String getId() {
        return "xml-2-json";
    }

    @Override
    public TransformProvider create() {
        return new XML2JSONProvider(objectMapper, xmlMapper);
    }
}
