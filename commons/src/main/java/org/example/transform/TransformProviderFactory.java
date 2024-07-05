package org.example.transform;

import org.example.ProviderFactory;

/**
 * TransformProviderFactory is used to create an instance of {@link TransformProvider} and manage its lifecycle.
 */
public interface TransformProviderFactory extends ProviderFactory {
    @Override
    default String getId() {
        return "transform";
    }

    @Override
    TransformProvider create();
}
