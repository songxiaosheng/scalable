package com.slicingflow.source;


/**
 * @author songxiaosheng
 */
public abstract class AbstractSource<T> implements Source<T> {

    private T source;

    @Override
    public T getSource() {
        return source;
    }

    @Override
    public void setSource(T source) {
        this.source = source;
    }
}
