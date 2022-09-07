package com.tamil.szchattools.sample.features.demo.custom.media.holders;

import android.view.View;
import android.widget.TextView;

import com.tamil.szchattools.messages.MessageHolders;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.model.Message;
import com.tamil.szchattools.sample.utils.FormatUtils;
import com.tamil.szchattools.utils.DateFormatter;

/*
 * Created by sz
 */
public class IncomingVoiceMessageViewHolder
        extends MessageHolders.IncomingTextMessageViewHolder<Message> {

    private TextView tvDuration;
    private TextView tvTime;

    public IncomingVoiceMessageViewHolder(View itemView, Object payload) {
        super(itemView, payload);
        tvDuration = itemView.findViewById(R.id.duration);
        tvTime = itemView.findViewById(R.id.time);
    }

    @Override
    public void onBind(Message message) {
        super.onBind(message);
        tvDuration.setText(
                FormatUtils.getDurationString(
                        message.getVoice().getDuration()));
        tvTime.setText(DateFormatter.format(message.getCreatedAt(), DateFormatter.Template.TIME));
    }
}
