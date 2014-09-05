package com.izabelrodrigues.maskedit.samples;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;

import com.izabelrodrigues.maskedit.MaskEdit;
import com.izabelrodrigues.maskedit.R;

public class SimpleTelephone extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_telephone);
        initViews();
    }

    private void initViews() {
        EditText mTelephone = (EditText) findViewById(R.id.simple_telephoneNumber);
        mTelephone.addTextChangedListener(MaskEdit.insertMaskTelephone(mTelephone));
    }
}
