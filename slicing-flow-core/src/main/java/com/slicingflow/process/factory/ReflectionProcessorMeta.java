package com.slicingflow.process.factory;


public class ReflectionProcessorMeta<Processor> extends ProcessorMeta {
    private Class<Processor> processClass;

    public ReflectionProcessorMeta(Class<Processor> processClass) {
        this.processClass = processClass;
    }

    public Class<Processor> getProcessClass() {
        return processClass;
    }

    public void setProcessClass(Class<Processor> processClass) {
        this.processClass = processClass;
    }
}
