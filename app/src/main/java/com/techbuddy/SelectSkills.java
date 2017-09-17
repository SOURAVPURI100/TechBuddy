package com.techbuddy;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.flexbox.FlexboxLayout;

import java.util.ArrayList;
import java.util.Random;

import fisk.chipcloud.ChipCloud;
import fisk.chipcloud.ChipCloudConfig;
import fisk.chipcloud.ChipDeletedListener;

/**
 * Created by premh on 16-Sep-17.
 */

public class SelectSkills extends AppCompatActivity {
    ArrayList<String> skillsComprehensiveList;
    ArrayList<String> results;
    String[] skill_colors;
    FloatingActionButton btn_next;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_skill);
        skill_colors = getApplicationContext().getResources().getStringArray(R.array.skill_colors);
        skillsComprehensiveList = new ArrayList<String>();
        for(String i: new String[]{"Java", "JSON", "Javascript", "Python","PHP","Ruby on Rails","Android","Django","GO","Pearl","HTML","JQuery","Firebase"}) {
            skillsComprehensiveList.add(i);
        }
        results = new ArrayList<>();
        btn_next = (FloatingActionButton) findViewById(R.id.button_next);
        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);
        final ArrayAdapter <String> adapter = new ArrayAdapter<String>
                (this,android.R.layout.simple_list_item_1, skillsComprehensiveList);
        autoCompleteTextView.setAdapter(adapter);
        FlexboxLayout deleteableFlexbox = (FlexboxLayout) findViewById(R.id.flexbox_deleteable);
        final ChipCloudConfig deleteableConfig = new ChipCloudConfig()
                .selectMode(ChipCloud.SelectMode.multi)
                .checkedChipColor(Color.parseColor(skill_colors[1]))
                .checkedTextColor(Color.parseColor("#ffffff"))
                .uncheckedChipColor(Color.parseColor(skill_colors[2]))
                .showClose(Color.parseColor("#ffffff"),300)
                .useInsetPadding(false)
                .uncheckedTextColor(Color.parseColor("#ffffff"));
        final ChipCloud deleteableCloud = new ChipCloud(this, deleteableFlexbox, deleteableConfig);
        deleteableCloud.setDeleteListener(new ChipDeletedListener() {
            @Override
            public void chipDeleted(int index, String label) {
            //    Log.d(TAG, String.format("chipDeleted at index: %d label: %s", index, label));
            }
        });

        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String skillSelectedThisTime = adapterView.getItemAtPosition(i).toString();

                skillsComprehensiveList.remove(skillSelectedThisTime);
                autoCompleteTextView.setAdapter(null);
                final ArrayAdapter<String> adapter = new ArrayAdapter<String>
                        (getApplicationContext(),android.R.layout.simple_list_item_1, skillsComprehensiveList);
                autoCompleteTextView.setAdapter(adapter);

                // add to the TextView at the bottom of the page
                results.add(skillSelectedThisTime);

                autoCompleteTextView.setText("");
                deleteableCloud.addChip(skillSelectedThisTime);

            }
        });
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SelectSkills.this, CreatePostActivity.class);
                startActivity(i);
            }
        });
    }


}
