package com.mitchellbosecke.benchmark;

import java.io.IOException;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import de.neuland.jade4j.JadeConfiguration;
import de.neuland.jade4j.template.ClasspathTemplateLoader;
import de.neuland.jade4j.template.JadeTemplate;

public class Jade4J extends BaseBenchmark {
    private JadeConfiguration config;
    private JadeTemplate template;
    private Map<String, Object> model;

    @Setup
    public void setup() throws IOException {
        model = getContext();
        
        config = new JadeConfiguration();
        config.setTemplateLoader(new ClasspathTemplateLoader());
        template = config.getTemplate("templates/stocks.jade");
    }

    @Benchmark
    public String benchmark() throws IOException {
        return config.renderTemplate(template, model);
    }
}
