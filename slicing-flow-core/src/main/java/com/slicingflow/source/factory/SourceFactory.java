package com.slicingflow.source.factory;

import com.slicingflow.source.Source;

/**
 * @author songxiaosheng
 */
public interface SourceFactory {
    /**
     * @param sourceMeta
     * @return
     */
    Source createSource(SourceMeta sourceMeta);
}
