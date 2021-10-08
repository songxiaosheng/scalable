package com.slicingflow.flow.factory;

import com.slicingflow.flow.Flow;

/**
 * @author songxiaosheng
 */
public abstract class AbstractFlowFactory implements FlowFactory {
    @Override
    public Flow createFlow() {
        return null;
    }
}
