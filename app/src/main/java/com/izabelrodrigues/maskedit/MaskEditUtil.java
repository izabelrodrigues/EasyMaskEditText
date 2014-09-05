package com.izabelrodrigues.maskedit;

import android.widget.EditText;

/**
 * Created by Izabel on 04/09/2014.
 */
public class MaskEditUtil {
    public static String insertSeparator(EditText mEditText, String mSeparator) {
        StringBuilder mTextFormatted = new StringBuilder();
        String mText = mEditText.getText().toString();
        mTextFormatted.append(mText.substring(0, 4));
        mTextFormatted.append(mSeparator);
        mTextFormatted.append(mText.substring(4, mText.length()));
        return mTextFormatted.toString();
    }

    public static int getLastPositionSeparator(String mTextFormatted, String mSeparator) {
        return mTextFormatted.lastIndexOf(mSeparator);
    }

    public static int countSeparator(String mTextFormatted, String mSeparator) {
        int count = 0;
        for (int i = 0; i < mTextFormatted.length(); i++) {
            if (mTextFormatted.charAt(i) == mSeparator.charAt(0)) {
                count++;
            }
        }
        return count;
    }

    public static String removeSeparatorIfNeed(String mTextFormatted, Integer... args) {
        int last = args[0];
        int qte = args[1];
        if (last > 4 && qte > 1) {
            mTextFormatted = new StringBuilder(mTextFormatted).deleteCharAt(last).toString();
        }
        return mTextFormatted;
    }
}
