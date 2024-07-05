package org.example;

/**
 * Factory for creating providers

 */
public interface ProviderFactory {

    String getId();

    Provider create();
}
