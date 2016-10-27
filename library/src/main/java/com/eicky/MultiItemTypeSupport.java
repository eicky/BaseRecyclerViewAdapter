package com.eicky;

/**
 * @author Eicky
 * @Description: 多ItemType类型支持
 * @date: 2016-10-27 20:21:08
 * @version: V1.0
 */

public interface MultiItemTypeSupport<T> {

    /**
     * 设置ViewTyp相对应的布局文件
     * @param viewType
     * @return
     */
    int getLayoutId(int viewType);

    /**
     * 获取ViewTyp
     * @param position
     * @param t
     * @return
     */
    int getItemViewType(int position, T t);
}
