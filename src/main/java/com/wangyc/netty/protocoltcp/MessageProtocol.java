package com.wangyc.netty.protocoltcp;

import lombok.Data;

/**
 * Э���
 *
 * @author: wangyc
 */
@Data
public class MessageProtocol {
    /** ������ */
    private int len;
    /** ������ */
    private byte[] content;
}