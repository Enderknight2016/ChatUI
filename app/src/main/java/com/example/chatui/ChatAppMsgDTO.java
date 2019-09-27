package com.example.chatui;

public class ChatAppMsgDTO {

    public final static String MSG_TYPE_SENT = "MSG_TYPE_SENT";

    public final static String MSG_TYPE_RECEIVED = "MSG_TYPE_RECEIVED";

    // Message content.
    private String msgContent;

    // Message type.
    private String msgType;

    /**
     *
     * @param msgType
     * @param msgContent
     */
    public ChatAppMsgDTO(String msgType, String msgContent)
    {
        this.msgType = msgType;
        this.msgContent = msgContent;
    }

    /**
     *
     * @return
     */
    public String getMsgContent()
    {
        return msgContent;
    }

    /**
     *
     * @param msgContent
     */
    public void setMsgContent(String msgContent)
    {
        this.msgContent = msgContent;
    }

    /**
     *
     * @return
     */
    public String getMsgType()
    {
        return msgType;
    }

    /**
     *
     * @param msgType
     */
    public void setMsgType(String msgType)
    {
        this.msgType = msgType;
    }
}
