package com.eicky;

import android.content.Context;
import android.view.ViewGroup;

import java.util.List;

/**
 * @author Eicky
 * @Description: Adapter
 * @date: 2016-10-27 20:21:15
 * @version: V1.0
 */

public abstract class QuickAdapter<T> extends BaseQuickAdapter<T, BaseAdapterHelper> {

    public QuickAdapter(Context context, int layoutResId) {
        super(context, layoutResId);
    }

    public QuickAdapter(Context context, int layoutResId, List<T> data) {
        super(context, layoutResId, data);
    }

    public QuickAdapter(Context context, MultiItemTypeSupport<T> multiItemSupport) {
        super(context, multiItemSupport);
    }

    public QuickAdapter(Context context, MultiItemTypeSupport<T> multiItemSupport, List<T> data) {
        super(context, multiItemSupport, data);
    }

    protected BaseAdapterHelper getAdapterHelper(Context context, ViewGroup parent, int layoutResId, int viewType) {
        if (mMultiItemSupport != null) {
            return BaseAdapterHelper.getViewHolder(context, parent, mMultiItemSupport.getLayoutId(viewType));
        } else {
            return BaseAdapterHelper.getViewHolder(context, parent, layoutResId);
        }
    }

}
