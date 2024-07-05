package com.ag04.pluginplatform.controller;

import lombok.RequiredArgsConstructor;
import org.example.Adapter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.pattern.PathPattern;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Controller for introspection of the application. It provides information about the registered endpoints and adapters.
 */
@RestController
@RequestMapping("/introspect")
@RequiredArgsConstructor
public class IntrospectionController {

    @Qualifier("requestMappingHandlerMapping")
    private final RequestMappingHandlerMapping handlerMapping;
    private final List<Adapter> factory;

    @GetMapping("/endpoints")
    public List<PathPattern> getEndpoints() {
        return handlerMapping.getHandlerMethods()
                .keySet().stream().map(key -> Objects.requireNonNull(key.getPathPatternsCondition()).getPatterns())
                .flatMap(Collection::stream)
                .toList();
    }

    @GetMapping("/adapters")
    public List<String> getAdapters() {
        return factory.stream().map(Adapter::get).toList();
    }

}
