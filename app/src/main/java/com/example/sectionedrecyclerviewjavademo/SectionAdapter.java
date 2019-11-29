package com.example.sectionedrecyclerviewjavademo;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import io.github.luizgrp.sectionedrecyclerviewadapter.Section;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;

public class SectionAdapter extends Section {

    private Context context;
    private String header;
    private String[] item;

    SectionAdapter(Context context, String header, String[] item) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item)
                .headerResourceId(R.layout.header)
                .build());
        this.context = context;
        this.header = header;
        this.item = item;
    }

    @Override
    public int getContentItemsTotal() {
        return item.length;
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindHeaderViewHolder(final RecyclerView.ViewHolder holder) {
        final HeaderViewHolder headerHolder = (HeaderViewHolder)holder;
        headerHolder.headerText.setText(header);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, final int position) {
        final ItemViewHolder itemHolder = (ItemViewHolder)holder;
        itemHolder.itemText.setText(item[position]);
        itemHolder.itemText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "正在點擊: " + header + " 的 " + item[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        private final TextView headerText;
        HeaderViewHolder(View itemView) {
            super(itemView);
            headerText = itemView.findViewById(R.id.headerText);
        }
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView itemText;
        ItemViewHolder(View itemView) {
            super(itemView);
            itemText = itemView.findViewById(R.id.itemText);
        }
    }

}