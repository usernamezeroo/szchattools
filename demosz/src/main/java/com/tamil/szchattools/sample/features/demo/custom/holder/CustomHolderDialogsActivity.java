package com.tamil.szchattools.sample.features.demo.custom.holder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tamil.szchattools.dialogs.DialogsList;
import com.tamil.szchattools.dialogs.DialogsListAdapter;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.fixtures.DialogsFixtures;
import com.tamil.szchattools.sample.common.data.model.Dialog;
import com.tamil.szchattools.sample.features.demo.DemoDialogsActivity;
import com.tamil.szchattools.sample.features.demo.custom.holder.holders.dialogs.CustomDialogViewHolder;

public class CustomHolderDialogsActivity extends DemoDialogsActivity {

    public static void open(Context context) {
        context.startActivity(new Intent(context, CustomHolderDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_holder_dialogs);

        dialogsList = findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        CustomHolderMessagesActivity.open(this);
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(
                R.layout.item_custom_dialog_view_holder,
                CustomDialogViewHolder.class,
                super.imageLoader);

        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
