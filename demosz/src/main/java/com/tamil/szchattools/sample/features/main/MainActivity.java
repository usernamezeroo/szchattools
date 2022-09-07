package com.tamil.szchattools.sample.features.main;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.tamil.szchattools.sample.R;
import com.tamil.szchattools.sample.features.demo.custom.holder.CustomHolderDialogsActivity;
import com.tamil.szchattools.sample.features.demo.custom.layout.CustomLayoutDialogsActivity;
import com.tamil.szchattools.sample.features.demo.custom.media.CustomMediaMessagesActivity;
import com.tamil.szchattools.sample.features.demo.def.DefaultDialogsActivity;
import com.tamil.szchattools.sample.features.demo.styled.StyledDialogsActivity;
import com.tamil.szchattools.sample.features.main.adapter.DemoCardFragment;
import com.tamil.szchattools.sample.features.main.adapter.MainActivityPagerAdapter;

import me.relex.circleindicator.CircleIndicator;

/*
 * Created by sz
 */
public class MainActivity extends AppCompatActivity
        implements DemoCardFragment.OnActionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager pager = findViewById(R.id.pager);
        pager.setAdapter(new MainActivityPagerAdapter(this, getSupportFragmentManager()));
        pager.setPageMargin((int) getResources().getDimension(R.dimen.card_padding) / 4);
        pager.setOffscreenPageLimit(3);

        CircleIndicator indicator = findViewById(R.id.indicator);
        indicator.setViewPager(pager);

    }

    @Override
    public void onAction(int id) {
        switch (id) {
            case MainActivityPagerAdapter.ID_DEFAULT:
                DefaultDialogsActivity.open(this);
                break;
            case MainActivityPagerAdapter.ID_STYLED:
                StyledDialogsActivity.open(this);
                break;
            case MainActivityPagerAdapter.ID_CUSTOM_LAYOUT:
                CustomLayoutDialogsActivity.open(this);
                break;
            case MainActivityPagerAdapter.ID_CUSTOM_VIEW_HOLDER:
                CustomHolderDialogsActivity.open(this);
                break;
            case MainActivityPagerAdapter.ID_CUSTOM_CONTENT:
                CustomMediaMessagesActivity.open(this);
                break;
        }
    }
}
