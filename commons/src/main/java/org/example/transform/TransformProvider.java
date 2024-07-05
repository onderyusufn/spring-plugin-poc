package org.example.transform;

import org.example.Provider;

/**
 * TransformProvider interface is used to define the extension points in the system. Providers are the actual implementations of the SPIs.

 */
public interface TransformProvider extends Provider {
    String exec(String input) throws Exception;
}
