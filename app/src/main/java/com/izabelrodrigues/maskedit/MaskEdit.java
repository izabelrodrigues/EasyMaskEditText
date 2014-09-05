package com.izabelrodrigues.maskedit;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Izabel on 04/09/2014.
 */
public class MaskEdit {

    private static String sTextFormatted;
    private static int sSize;

    /**
     * This method insert a mask for a telephone number with 8 and 9 digits
     *
     * @param mEditText Field for mask
     * @return TextWatcher type
     */
    public static TextWatcher insertMaskTelephone(final EditText mEditText) {

        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                sTextFormatted = mEditText.getText().toString().trim();
                if (sTextFormatted.length() == 4) {
                    sTextFormatted = mEditText.getText().toString().trim();
                    mEditText.removeTextChangedListener(this);
                    mEditText.setSelection(mEditText.getText().toString().length());
                    mEditText.addTextChangedListener(this);
                } else if (sTextFormatted.length() == 10) {
                    sTextFormatted = mEditText.getText().toString().trim();
                    mEditText.removeTextChangedListener(this);
                    sTextFormatted = sTextFormatted.replaceAll("-", "");
                    String sNewTextFormatted = new StringBuilder(sTextFormatted).insert(sTextFormatted.length() - 4, "-").toString();
                    mEditText.removeTextChangedListener(this);
                    mEditText.setText(sNewTextFormatted);
                    mEditText.setSelection(mEditText.getText().toString().length());
                    mEditText.addTextChangedListener(this);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
                sSize = mEditText.getText().toString().trim().length();

                int mlastPositionSeparator;
                int qteSeparator;
                if (sSize > 5 && sSize < 10) {
                    mEditText.removeTextChangedListener(this);
                    sTextFormatted = MaskEditUtil.insertSeparator(mEditText, "-");
                    mlastPositionSeparator = MaskEditUtil.getLastPositionSeparator(sTextFormatted, "-");
                    qteSeparator = MaskEditUtil.countSeparator(sTextFormatted, "-");
                    sTextFormatted = MaskEditUtil.removeSeparatorIfNeed(sTextFormatted, mlastPositionSeparator, qteSeparator);
                    mEditText.setText(sTextFormatted);
                    mEditText.setSelection(mEditText.getText().toString().length());
                    mEditText.addTextChangedListener(this);
                }
            }
        };

    }
}
