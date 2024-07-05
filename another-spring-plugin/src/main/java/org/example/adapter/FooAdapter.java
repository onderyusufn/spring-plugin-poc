package org.example.adapter;


import org.example.Adapter;
import org.springframework.stereotype.Component;

@Component
public class FooAdapter implements Adapter {
    @Override
    public String get() {
        return "another-spring-plugin: FooAdapter.get() called";
    }
}
