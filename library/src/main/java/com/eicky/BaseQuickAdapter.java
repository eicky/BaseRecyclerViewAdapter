package com.eicky;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Eicky
 * @Description: 基类
 * @date: 2016-10-27 20:19:12
 * @version: V1.0
 */

public abstract class BaseQuickAdapter<T, H extends BaseAdapterHelper> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    protected Context context;

    protected List<T> data;

    protected int layoutResId;

    protected MultiItemTypeSupport<T> mMultiItemSupport; //多样式扩展

    public BaseQuickAdapter(Context context, int layoutResId) {
        this(context, layoutResId, null);
    }

    public BaseQuickAdapter(Context context, int layoutResId, List<T> data) {
        this.data = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        this.context = context;
        this.layoutResId = layoutResId;
    }

    public BaseQuickAdapter(Context context, MultiItemTypeSupport<T> multiItemSupport) {
        this(context, multiItemSupport, null);
    }

    public BaseQuickAdapter(Context context, MultiItemTypeSupport<T> multiItemSupport, List<T> data) {
        this.mMultiItemSupport = multiItemSupport;
        this.data = data == null ? new ArrayList<T>() : new ArrayList<T>(data);
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        if (position >= data.size()) {
            return 0;
        }
        return mMultiItemSupport != null ? mMultiItemSupport.getItemViewType(position, getItem(position)) : 1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        H helper = getAdapterHelper(context, parent, layoutResId, viewType);
        return helper;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        onBindViewHolder((BaseAdapterHelper) holder, getItem(position), position);
    }

    public T getItem(int position) {
        if (position >= data.size())
            return null;
        return data.get(position);
    }


    @Override
    public int getItemCount() {
        return data.size();
    }

    public boolean isEnabled(int position) {
        return position < data.size();
    }

    public void add(T elem) {
        data.add(elem);
        notifyDataSetChanged();
    }

    public void addAll(List<T> elem) {
        data.addAll(elem);
        notifyDataSetChanged();
    }

    public void set(T oldElem, T newElem) {
        set(data.indexOf(oldElem), newElem);
    }

    public void set(int index, T elem) {
        data.set(index, elem);
        notifyDataSetChanged();
    }

    public void remove(T elem) {
        data.remove(elem);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        data.remove(index);
        notifyDataSetChanged();
    }

    public void replaceAll(List<T> elem) {
        data.clear();
        data.addAll(elem);
        notifyDataSetChanged();
    }


    /**
     * 获取AdapterHelper(Holder)
     *
     * @param context
     * @param parent
     * @param layoutResId
     * @param viewType
     * @return
     */
    protected abstract H getAdapterHelper(Context context, ViewGroup parent, int layoutResId, int viewType);

    /**
     * 绑定视图（填充数据）
     *
     * @param helper
     * @param t
     * @param position
     */
    protected abstract void onBindViewHolder(BaseAdapterHelper helper, T t, int position);

}
