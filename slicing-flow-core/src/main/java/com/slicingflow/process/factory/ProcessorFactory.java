package com.slicingflow.process.factory;

import com.slicingflow.process.Processor;

/**
 * @author songxiaosheng
 */
public interface ProcessorFactory {
    Processor createProcessor(ProcessorMeta processorMeta);
}
