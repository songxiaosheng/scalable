package com.slicingflow.source.factory;


/**
 * @author songxiaosheng
 */
public class ReflectionSourceMeta<Source> extends  SourceMeta{

    private Class<Source> sourceClass;

    public ReflectionSourceMeta(Class<Source> sourceClass) {
        this.sourceClass = sourceClass;
    }

    public Class<Source> getSourceClass() {
        return sourceClass;
    }

    public void setSourceClass(Class<Source> sourceClass) {
        this.sourceClass = sourceClass;
    }
}
