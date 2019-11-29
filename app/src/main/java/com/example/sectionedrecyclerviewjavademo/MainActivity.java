package com.example.sectionedrecyclerviewjavademo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity {

    private String header1 = "A";
    private String header2 = "B";
    private String header3 = "C";
    private String[] item1 = {"001", "002", "003", "004", "005", "006"};
    private String[] item2 = {"007", "008", "009", "010", "011", "012"};
    private String[] item3 = {"013", "014", "015", "016", "017", "018"};

    private int ITEM_PER_LINE = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SectionedRecyclerViewAdapter sectionAdapter = new SectionedRecyclerViewAdapter();
        sectionAdapter.addSection(new SectionAdapter(this, header1, item1));
        sectionAdapter.addSection(new SectionAdapter(this, header2, item2));
        sectionAdapter.addSection(new SectionAdapter(this, header3, item3));
        GridLayoutManager glm = new GridLayoutManager(this, ITEM_PER_LINE);
        glm.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if(sectionAdapter.getSectionItemViewType(position) == SectionedRecyclerViewAdapter.VIEW_TYPE_HEADER) {
                    return ITEM_PER_LINE;
                } else {
                    return 1;
                }
            }
        });
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(glm);
        recyclerView.setAdapter(sectionAdapter);
    }

}
