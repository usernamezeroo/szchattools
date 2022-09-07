package com.tamil.szchattools.sample.features.demo.custom.holder.holders.messages;

import android.util.Pair;
import android.view.View;

import com.tamil.szchattools.messages.MessageHolders;
import com.tamil.szchattools.sample.common.data.model.Message;

/*
 * Created by sz
 */
public class CustomOutcomingImageMessageViewHolder
        extends MessageHolders.OutcomingImageMessageViewHolder<Message> {

    public CustomOutcomingImageMessageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
    }

    @Override
    public void onBind(Message message) {
        super.onBind(message);

        time.setText(message.getStatus() + " " + time.getText());
    }

    //Override this method to have ability to pass custom data in ImageLoader for loading image(not avatar).
    @Override
    protected Object getPayloadForImageLoader(Message message) {
        //For example you can pass size of placeholder before loading
        return new Pair<>(100, 100);
    }
}