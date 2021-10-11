package com.slicingflow.source.factory;

import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public abstract class AbstractSourceFactory implements SourceFactory{
    @Override
    public Source createSource(SourceMeta sourceMeta) {
        return null;
    }
}
