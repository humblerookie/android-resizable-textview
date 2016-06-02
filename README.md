# android-resizable-textview
A TextView that grows and shrinks as per width and height needed.
As opposed to the existing widgets which rely on max lines etc, This widget relies purely on the max dimensions of the view specified.


Feel free to explore the project and submit issues or enhancements. The MainActivity defines how to use the view.

## Usage
```
 <com.hr.autoresize.widget.AutoResizeTextView
        android:id="@+id/resized_view"
        android:layout_width="150dp"
        android:layout_height="150dp"
        android:textColor="@android:color/holo_blue_bright"
        android:textSize="14sp"
        app:maxResizedHeight="150dp"
        app:maxResizedWidth="150dp"
        app:maxTextSize="22sp"
        app:minTextSize="8sp" />
```

```
resizableTextView.setResizableText("This is a reallyyyyyyyy longggggggggggggg strinnnnnnnnnnnnnnnnnnnnnnnnnnnng");
```


###Note
This uses a dummy view to calculate the view visibilty parameters. Thus for every AutoResizeTextView you include in your layout there would be 1 more TextView held in memory.
This ideally shouldn't effect your performance.  