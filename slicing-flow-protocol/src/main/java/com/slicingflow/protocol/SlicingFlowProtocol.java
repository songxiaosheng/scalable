package com.slicingflow.protocol;


/**
 * +---------------------------------------------------------------+
 *
 * | 魔数 2byte | 协议版本号 1byte | 序列化算法 1byte | 报文类型 1byte  |
 *
 * +---------------------------------------------------------------+
 *
 * | 状态 1byte |        消息 ID 8byte     |  数据长度 4byte         |
 *
 * +---------------------------------------------------------------+
 *
 * | 数据内容 （长度不定）                                            |
 *
 * +---------------------------------------------------------------+
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
