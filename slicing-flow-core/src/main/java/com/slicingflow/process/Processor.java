package com.slicingflow.process;

import com.slicingflow.sink.Sink;
import com.slicingflow.source.Source;

/**
 *
 * @author songxiaosheng
 */
public interface Processor {
    Sink process(Source source);
}
