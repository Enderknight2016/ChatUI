package com.example.chatui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import static com.example.chatui.ChatAppMsgDTO.MSG_TYPE_RECEIVED;
import static com.example.chatui.ChatAppMsgDTO.MSG_TYPE_SENT;

/**
 *
 */
public class ChatAppMsgAdapter extends RecyclerView.Adapter<ChatAppMsgViewHolder>
{

    private List<ChatAppMsgDTO> msgDtoList = null;

    /**
     *
     * @param msgDtoList
     */
    public ChatAppMsgAdapter(List<ChatAppMsgDTO> msgDtoList) {
        this.msgDtoList = msgDtoList;
    }

    /**
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(ChatAppMsgViewHolder holder, int position)
    {
        ChatAppMsgDTO msgDto = this.msgDtoList.get(position);
        // If the message is a received message.
        if(MSG_TYPE_RECEIVED.equals(msgDto.getMsgType()))
        {
            holder.leftMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.leftMsgTextView.setText(msgDto.getMsgContent());
            holder.rightMsgLayout.setVisibility(LinearLayout.GONE);
        }
        else if(MSG_TYPE_SENT.equals(msgDto.getMsgType()))
        {
            // Show sent message in right linearlayout.
            holder.rightMsgLayout.setVisibility(LinearLayout.VISIBLE);
            holder.rightMsgTextView.setText(msgDto.getMsgContent());
            // Remove left linearlayout.The value should be GONE, can not be INVISIBLE
            // Otherwise each iteview's distance is too big.
            holder.leftMsgLayout.setVisibility(LinearLayout.GONE);
        }
    }

    /**
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ChatAppMsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.message, parent, false);
        return new ChatAppMsgViewHolder(view);
    }

    /**
     *
     * @return
     */
    @Override
    public int getItemCount()
    {
        if(msgDtoList==null)
        {
            msgDtoList = new ArrayList<ChatAppMsgDTO>();
        }
        return msgDtoList.size();
    }
}
