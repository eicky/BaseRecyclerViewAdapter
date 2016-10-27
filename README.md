# BaseRecyclerViewAdapter     [![](https://jitpack.io/v/eicky/BaseRecyclerViewAdapter.svg)](https://jitpack.io/#eicky/BaseRecyclerViewAdapter)
RecyclerView通用适配器
## Use
```get
    allprojects {
    		repositories {
    			...
    			maven { url "https://jitpack.io" }
    		}
    	}

```
```get
    dependencies {
    	        compile 'com.github.eicky:BaseRecyclerViewAdapter:1.0'
    	}

```

##Code
```code
mQuickAdapter = new QuickAdapter<Integer>(this, R.layout.item) {
            @Override
            protected void onBindViewHolder(BaseAdapterHelper helper, Integer integer, int position) {
                helper.setText();
                ....
            }
        };
```
<img src="https://github.com/eicky/BaseRecyclerViewAdapter/blob/master/img/img.png" height="640" width="360" >
<img src="https://github.com/eicky/BaseRecyclerViewAdapter/blob/master/img/img1.png" height="640" width="360" >
<img src="https://github.com/eicky/BaseRecyclerViewAdapter/blob/master/img/img2.png" height="640" width="360" >
<img src="https://github.com/eicky/BaseRecyclerViewAdapter/blob/master/img/img3.png" height="640" width="360" >
<img src="https://github.com/eicky/BaseRecyclerViewAdapter/blob/master/img/img4.png" height="640" width="360" >


## BaseAdapterHelper

* ```setText()``` Calls ```setText(String)``` on any TextView.
* ```setAlpha()``` Calls ```setAlpha(float)``` on any View.
* ```setVisible()``` Calls ```setVisibility(int)``` on any View.
* ```linkify()``` Calls ```Linkify.addLinks(view, ALL)``` on any TextView.
* ```setTypeface()``` Calls ```setTypeface(Typeface)``` on any TextView.
* ```setProgress()``` Calls ```setProgress(int)``` on any ProgressBar.
* ```setMax()``` Calls ```setMax(int)``` on any ProgressBar.
* ```setRating()``` Calls ```setRating(int)``` on any RatingBar.
* ```setImageResource()``` Calls ```setImageResource(int)``` on any ImageView.
* ```setImageDrawable()``` Calls ```setImageDrawable(Drawable)``` on any ImageView.
* ```setImageBitmap()``` Calls ```setImageBitmap(Bitmap)``` on any ImageView.
* ```setOnClickListener()```
* ```setOnTouchListener()```
* ```setOnLongClickListener()```
* ```setTag()```
* ```setChecked()```
* ```setAdapter()```