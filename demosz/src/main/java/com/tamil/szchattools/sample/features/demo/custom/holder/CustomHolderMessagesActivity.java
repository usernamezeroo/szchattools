package com.tamil.szchattools.sample.features.demo.custom.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.tamil.szchattools.messages.MessageHolders;
import com.tamil.szchattools.messages.MessageInput;
import com.tamil.szchattools.messages.MessagesList;
import com.tamil.szchattools.messages.MessagesListAdapter;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.fixtures.MessagesFixtures;
import com.tamil.szchattools.sample.common.data.model.Message;
import com.tamil.szchattools.sample.features.demo.DemoMessagesActivity;
import com.tamil.szchattools.sample.features.demo.custom.holder.holders.messages.CustomIncomingImageMessageViewHolder;
import com.tamil.szchattools.sample.features.demo.custom.holder.holders.messages.CustomIncomingTextMessageViewHolder;
import com.tamil.szchattools.sample.features.demo.custom.holder.holders.messages.CustomOutcomingImageMessageViewHolder;
import com.tamil.szchattools.sample.features.demo.custom.holder.holders.messages.CustomOutcomingTextMessageViewHolder;
import com.tamil.szchattools.sample.utils.AppUtils;

public class CustomHolderMessagesActivity extends DemoMessagesActivity
        implements MessagesListAdapter.OnMessageLongClickListener<Message>,
        MessageInput.InputListener,
        MessageInput.AttachmentsListener {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CustomHolderMessagesActivity.class));
    }

    private MessagesList messagesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_holder_messages);

        messagesList = findViewById(R.id.messagesList);
        initAdapter();

        MessageInput input = findViewById(R.id.input);
        input.setInputListener(this);
        input.setAttachmentsListener(this);
    }

    @Override
    public boolean onSubmit(CharSequence input) {
        messagesAdapter.addToStart(
                MessagesFixtures.getTextMessage(input.toString()), true);
        return true;
    }

    @Override
    public void onAddAttachments() {
        messagesAdapter.addToStart(MessagesFixtures.getImageMessage(), true);
    }

    @Override
    public void onMessageLongClick(Message message) {
        AppUtils.showToast(this, R.string.on_log_click_message, false);
    }

    private void initAdapter() {

        //We can pass any data to ViewHolder with payload
        CustomIncomingTextMessageViewHolder.Payload payload = new CustomIncomingTextMessageViewHolder.Payload();
        //For example click listener
        payload.avatarClickListener = () -> Toast.makeText(CustomHolderMessagesActivity.this,
                "Text message avatar clicked", Toast.LENGTH_SHORT).show();

        MessageHolders holdersConfig = new MessageHolders()
                .setIncomingTextConfig(
                        CustomIncomingTextMessageViewHolder.class,
                        R.layout.item_custom_incoming_text_message,
                        payload)
                .setOutcomingTextConfig(
                        CustomOutcomingTextMessageViewHolder.class,
                        R.layout.item_custom_outcoming_text_message)
                .setIncomingImageConfig(
                        CustomIncomingImageMessageViewHolder.class,
                        R.layout.item_custom_incoming_image_message)
                .setOutcomingImageConfig(
                        CustomOutcomingImageMessageViewHolder.class,
                        R.layout.item_custom_outcoming_image_message);

        super.messagesAdapter = new MessagesListAdapter<>(super.senderId, holdersConfig, super.imageLoader);
        super.messagesAdapter.setOnMessageLongClickListener(this);
        super.messagesAdapter.setLoadMoreListener(this);
        messagesList.setAdapter(super.messagesAdapter);
    }
}
