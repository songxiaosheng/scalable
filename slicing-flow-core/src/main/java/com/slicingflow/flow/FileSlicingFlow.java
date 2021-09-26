package com.slicingflow.flow;

import com.slicingflow.source.FileSlicingSource;

/**
 * @author songxiaosheng
 */
public class FileSlicingFlow implements Flow {

    public Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        public Builder source(FileSlicingSource fileSlicingSource){
            return this;
        }
    }
}
