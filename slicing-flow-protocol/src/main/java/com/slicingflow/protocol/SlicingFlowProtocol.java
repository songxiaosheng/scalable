package com.slicingflow.protocol;

/**
 * @author songxiaosheng
 */
public class SlicingFlowProtocol<T> {
    private SlicingFlowProtocolHeader header;
    private T body;

    public SlicingFlowProtocolHeader getHeader() {
        return header;
    }

    public void setHeader(SlicingFlowProtocolHeader header) {
        this.header = header;
    }

    public T getBody() {
        return body;
    }

    public void setBody(T body) {
        this.body = body;
    }
}
