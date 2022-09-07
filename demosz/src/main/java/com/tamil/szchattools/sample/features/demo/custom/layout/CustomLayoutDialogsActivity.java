package com.tamil.szchattools.sample.features.demo.custom.layout;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tamil.szchattools.dialogs.DialogsList;
import com.tamil.szchattools.dialogs.DialogsListAdapter;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.fixtures.DialogsFixtures;
import com.tamil.szchattools.sample.common.data.model.Dialog;
import com.tamil.szchattools.sample.features.demo.DemoDialogsActivity;

public class CustomLayoutDialogsActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CustomLayoutDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_layout_dialogs);

        dialogsList = findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        CustomLayoutMessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(R.layout.item_custom_dialog, super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
