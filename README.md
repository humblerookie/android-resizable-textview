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

License
=======
    Copyright 2016 Anvith Bhat

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.

