package com.tamil.szchattools.sample.features.demo.styled;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.tamil.szchattools.dialogs.DialogsList;
import com.tamil.szchattools.dialogs.DialogsListAdapter;
import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.common.data.fixtures.DialogsFixtures;
import com.tamil.szchattools.sample.common.data.model.Dialog;
import com.tamil.szchattools.sample.features.demo.DemoDialogsActivity;
import com.tamil.szchattools.utils.DateFormatter;

import java.util.Date;

public class StyledDialogsActivity extends DemoDialogsActivity
        implements DateFormatter.Formatter {

    public static void open(Context context) {
        context.startActivity(new Intent(context, StyledDialogsActivity.class));
    }

    private DialogsList dialogsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_styled_dialogs);

        dialogsList = findViewById(R.id.dialogsList);
        initAdapter();
    }

    @Override
    public void onDialogClick(Dialog dialog) {
        StyledMessagesActivity.open(this);
    }

    @Override
    public String format(Date date) {
        if (DateFormatter.isToday(date)) {
            return DateFormatter.format(date, DateFormatter.Template.TIME);
        } else if (DateFormatter.isYesterday(date)) {
            return getString(R.string.date_header_yesterday);
        } else if (DateFormatter.isCurrentYear(date)) {
            return DateFormatter.format(date, DateFormatter.Template.STRING_DAY_MONTH);
        } else {
            return DateFormatter.format(date, DateFormatter.Template.STRING_DAY_MONTH_YEAR);
        }
    }

    private void initAdapter() {
        super.dialogsAdapter = new DialogsListAdapter<>(super.imageLoader);
        super.dialogsAdapter.setItems(DialogsFixtures.getDialogs());

        super.dialogsAdapter.setOnDialogClickListener(this);
        super.dialogsAdapter.setOnDialogLongClickListener(this);
        super.dialogsAdapter.setDatesFormatter(this);

        dialogsList.setAdapter(super.dialogsAdapter);
    }
}
