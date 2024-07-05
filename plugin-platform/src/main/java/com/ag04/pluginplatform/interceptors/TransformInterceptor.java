package com.ag04.pluginplatform.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.example.transform.TransformProvider;
import org.example.transform.TransformProviderFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@Component
public class TransformInterceptor implements HandlerInterceptor {

    private final List<TransformProviderFactory> providerFactory;

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws IOException {
        if (response.getContentType() != null && response.getContentType().contains("application/json")) {
            // Capture the JSON response body
            String jsonResponse = response.getOutputStream().toString();

            // Convert JSON to XML
            try {

                TransformProvider provider = providerFactory.get(0).create();
                String xmlResponse = provider.exec(jsonResponse);

                // Set the content type to XML
                response.setContentType("application/xml");
                response.getOutputStream().write(xmlResponse.getBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
