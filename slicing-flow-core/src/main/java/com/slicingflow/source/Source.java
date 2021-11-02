package com.slicingflow.source;

/**
 * @author songxiaosheng
 */
public interface Source<T> {

    void setSource(T t);
    /**
     * @return
     */
    T getSource();
}

