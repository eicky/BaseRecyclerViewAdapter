package com.eicky.sample;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.eicky.BaseAdapterHelper;
import com.eicky.MultiItemTypeSupport;
import com.eicky.QuickAdapter;

import java.util.ArrayList;

/**
 * @author Eicky
 * @Description:
 * @date: 2016-10-27 21:43:09
 * @version: V1.0
 */
public class SampleActivity extends AppCompatActivity {
    private static final String TYPE_KEY = "type_key";
    public static final int LINEAR_LAYOUT_MANAGER = 1;
    public static final int GRID_LAYOUT_MANAGER = 2;
    public static final int STAGGERED_LAYOUT_MANAGER = 3;
    public static final int MULTI_TYPE = 4;
    private RecyclerView recyclerView;
    private int type;
    private QuickAdapter<Integer> mQuickAdapter;
    private ArrayList<Integer> mList, mHeights;

    public static void startIntent(AppCompatActivity activity, int type) {
        Intent intent = new Intent(activity, SampleActivity.class);
        intent.putExtra(TYPE_KEY, type);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        type = getIntent().getIntExtra(TYPE_KEY, 1);
        recyclerView = (RecyclerView) findViewById(R.id.recyler_view);
        if (type != MULTI_TYPE) {
            if (type == STAGGERED_LAYOUT_MANAGER){
                mHeights = new ArrayList<>();
                for (int i = 0; i < 100; i++){
                    mHeights.add((int) (400 + Math.random() * 300));
                }
            }
            mQuickAdapter = new QuickAdapter<Integer>(this, type == LINEAR_LAYOUT_MANAGER ? R.layout
                    .item_recycler_view : R.layout.item_grid) {
                @Override
                protected void onBindViewHolder(BaseAdapterHelper helper, Integer integer, int position) {
                    if (type == LINEAR_LAYOUT_MANAGER) {
                        helper.setText(R.id.text, "item" + integer);
                    } else {
                        int id = getResources().getIdentifier("img" + (integer % 7), "mipmap", getPackageName());
                        helper.setImageResource(R.id.image, id);
                        if (type == STAGGERED_LAYOUT_MANAGER){
                            ViewGroup.LayoutParams layoutParams = helper.itemView.getLayoutParams();
                            layoutParams.height = mHeights.get(position);
                            helper.itemView.setLayoutParams(layoutParams);
                        }
                    }
                }
            };
        } else {
            MultiItemTypeSupport<Integer> multiItemTypeSupport = new MultiItemTypeSupport<Integer>() {
                @Override
                public int getLayoutId(int viewType) {
                    if (viewType == 0) {
                        return R.layout.item_recycler_view;
                    }
                    return R.layout.item;
                }

                @Override
                public int getItemViewType(int position, Integer integer) {
                    return integer % 2;
                }
            };
            mQuickAdapter = new QuickAdapter<Integer>(this, multiItemTypeSupport) {
                @Override
                protected void onBindViewHolder(BaseAdapterHelper helper, Integer integer, int position) {
                    if (helper.getItemViewType() == 0)
                        helper.setText(R.id.text, "item" + integer);
                    else
                        helper.setText(R.id.text1, "mutitypeitem" + integer);
                }
            };
        }

        mList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            mList.add(i);
        }

        recyclerView.setAdapter(mQuickAdapter);
        switch (type) {
            case LINEAR_LAYOUT_MANAGER:
            case MULTI_TYPE:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                break;
            case GRID_LAYOUT_MANAGER:
                recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
            case STAGGERED_LAYOUT_MANAGER:
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
                break;
        }
        mQuickAdapter.addAll(mList);
    }
}
