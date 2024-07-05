package com.ag04.pluginplatform;

import com.ag04.pluginplatform.classloader.PluginClassloader;
import org.example.PluginFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.DefaultResourceLoader;

@ComponentScan(basePackages = {"org.example", "com.ag04.pluginplatform"},
		includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = PluginFactory.class))
@SpringBootApplication
public class PluginPlatformApplication {

	public static void main(String[] args) {
		PluginClassloader classLoader = new PluginClassloader(Constant.PLUGINS_DIR, Thread.currentThread().getContextClassLoader());
		SpringApplication app = new SpringApplication(PluginPlatformApplication.class);
		app.setResourceLoader(new DefaultResourceLoader(classLoader));
		app.run(args);
	}

}
