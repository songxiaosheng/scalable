package com.slicingflow.process;

import com.slicingflow.sink.Sink;
import com.slicingflow.source.Source;

import java.util.Map;

/**
 *
 * @author songxiaosheng
 */
public interface Processor {

    void setMeta(Map<String, Object> map);
    /**
     * @param source
     * @return
     */
    <T> Sink  process(Source<T> source);

}
