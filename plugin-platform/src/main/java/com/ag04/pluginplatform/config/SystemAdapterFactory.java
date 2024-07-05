package com.ag04.pluginplatform.config;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.Adapter;
import org.example.transform.TransformProviderFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Getter
@Slf4j
public class SystemAdapterFactory {

    private final List<Adapter> adapters;
    private final List<TransformProviderFactory> providerFactories;

    @PostConstruct
    void listAdapters() {
        for (Adapter adapter : adapters) {
            log.info("...Loaded Class: {} of type: {}", adapter.getClass(), adapter.get());
        }

        for (TransformProviderFactory providerFactory : providerFactories) {
            log.info("...Loaded Class: {} of type: {}", providerFactory.getClass(), providerFactory.getId());
        }
    }

}
