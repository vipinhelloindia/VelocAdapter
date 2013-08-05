VelocAdapter
============

The fastest and easiest way to create an Android adapter. 

VelocAdapter provides an easy way to implement an adapter without worrying 
about having to implement the view holder pattern or checking for 
convertView again! 

Usage
-----

For this layout:

```xml
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="48dp" >

    <ImageView
        android:id="@+id/img"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:layout_alignParentLeft="true"
        tools:ignore="ContentDescription" />

    <TextView
        android:id="@+id/text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentRight="true"
        android:layout_centerVertical="true"
        android:layout_toRightOf="@+id/img"
        android:paddingLeft="8dp" />

</RelativeLayout>
```
And this model: 

```java
public class Model {

    public String title;
    public int    imageId;

    public Model(String title, int imageId) {
        this.title = title;
        this.imageId = imageId;
    }
}
```

This adapter provides the glue between the two: 

```java
public class VelocAdapterPoC extends VelocAdapter<Model> {

    public VelocAdapterPoC(Context context) {
        super(context, R.layout.row_model);
    }

    @Override
    protected void bindView(Context context, View view, ViewHolder holder, int position) {
        ImageView iv = holder.get(R.id.img);
        TextView tv = holder.get(R.id.text);

        Model model = getItem(position);

        iv.setImageResource(model.imageId);
        tv.setText(model.title);
    }
}
```
