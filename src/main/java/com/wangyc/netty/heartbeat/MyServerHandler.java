package com.wangyc.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author wangyc
 */
public class MyServerHandler extends ChannelInboundHandlerAdapter {

    /**
     *��������
     * @param ctx ������
     * @param evt �¼�
     * @throws Exception �쳣
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "������";
                    break;
                case WRITER_IDLE:
                    eventType = "д����";
                    break;
                case ALL_IDLE:
                    eventType = "��д����";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + "--��ʱʱ��--" + eventType);
            System.out.println("����������Ӧ����..");
        }
    }
}
