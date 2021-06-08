package com.example.myapplication;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ItemBean itemBean = (ItemBean) getIntent().getSerializableExtra("bean");

        ImageView image = (ImageView) findViewById(R.id.image);
        TextView title = (TextView) findViewById(R.id.title);
        TextView detail = (TextView) findViewById(R.id.detail);

        image.setImageResource(itemBean.getDrawable());
        title.setText(itemBean.getTitle());
        detail.setText(itemBean.getDetail());


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
}
