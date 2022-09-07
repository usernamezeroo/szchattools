package com.tamil.szchattools.sample.features.demo.def;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tamil.szchattools.dialogs.DialogsList;
import com.tamil.szchattools.dialogs.DialogsListAdapter;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.fixtures.DialogsFixtures;
import com.tamil.szchattools.sample.common.data.model.Dialog;
import com.tamil.szchattools.sample.common.data.model.Message;
import com.tamil.szchattools.sample.features.demo.DemoDialogsActivity;

public class DefaultDialogsActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, DefaultDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_dialogs);

        dialogsList = findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        DefaultMessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }

    //for example
    private void onNewMessage(String dialogId, Message message) {
        boolean isUpdated = dialogsAdapter.updateDialogWithMessage(dialogId, message);
        if (!isUpdated) {
            //Dialog with this ID doesn't exist, so you can create new Dialog or update all dialogs list
        }
    }

    //for example
    private void onNewDialog(Dialog dialog) {
        dialogsAdapter.addItem(dialog);
    }
}
