package com.hr.autoresize.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.hr.autoresize.widget.AutoResizeTextView;

import humblerookie.com.myapplication.R;

public class MainActivity extends AppCompatActivity {

    AutoResizeTextView resizableTextView;

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resizableTextView = (AutoResizeTextView) findViewById(R.id.resized_view);
        editText = (EditText) findViewById(R.id.entered_input);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                resizableTextView.setResizableText(editable.toString());
            }
        });

    }
}
