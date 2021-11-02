package com.slicingflow.process;

import com.slicingflow.sink.Sink;
import com.slicingflow.sink.factory.SinkFactory;
import com.slicingflow.source.Source;

import java.util.Map;

/**
 * @author songxiaosheng
 */
public abstract class AbstractProcessor implements Processor {

    private Map<String, Object> meta;

    public Map<String, Object> getMeta() {
        return meta;
    }

    @Override
    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    @Override
    public <T> Sink process(Source<T> source) {

        return null;
    }
}

