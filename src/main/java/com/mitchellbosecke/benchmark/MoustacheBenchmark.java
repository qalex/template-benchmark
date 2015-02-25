package com.mitchellbosecke.benchmark;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Setup;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.github.mustachejava.MustacheFactory;

public class MoustacheBenchmark extends BaseBenchmark {

    private Map<String, Object> context;

    private Mustache template;

    @Setup
    public void setup() {
        MustacheFactory mustacheFactory = new DefaultMustacheFactory();
        template = mustacheFactory.compile("templates/stocks.mustache.html");
        this.context = getContext();
    }

    @Benchmark
    public String benchmark() {
        Writer writer = new StringWriter();
        template.execute(writer, context);
        return writer.toString();
    }

}
