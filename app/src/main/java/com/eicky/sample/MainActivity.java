package com.eicky.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button linearLayoutManagerBtn, gridLayoutManagerBtn, staggeredLayoutManager, multiTypeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        linearLayoutManagerBtn = (Button) findViewById(R.id.linear_layout_manager);
        gridLayoutManagerBtn = (Button) findViewById(R.id.grid_layout_manager);
        staggeredLayoutManager = (Button) findViewById(R.id.staggered_layout_manager);
        multiTypeBtn = (Button) findViewById(R.id.multi_type);
        linearLayoutManagerBtn.setOnClickListener(this);
        gridLayoutManagerBtn.setOnClickListener(this);
        staggeredLayoutManager.setOnClickListener(this);
        multiTypeBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.linear_layout_manager:
                SampleActivity.startIntent(this, SampleActivity.LINEAR_LAYOUT_MANAGER);
                break;
            case R.id.grid_layout_manager:
                SampleActivity.startIntent(this, SampleActivity.GRID_LAYOUT_MANAGER);
                break;
            case R.id.staggered_layout_manager:
                SampleActivity.startIntent(this, SampleActivity.STAGGERED_LAYOUT_MANAGER);
                break;
            case R.id.multi_type:
                SampleActivity.startIntent(this, SampleActivity.MULTI_TYPE);
                break;
        }
    }
}
