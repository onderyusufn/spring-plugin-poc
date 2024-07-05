package org.example.adapter;

import org.example.Adapter;
import org.springframework.stereotype.Component;

@Component
public class TakeAdapter implements Adapter {
    @Override
    public String get() {
        return "spring-plugin: TakeAdapter.get() called";
    }
}
