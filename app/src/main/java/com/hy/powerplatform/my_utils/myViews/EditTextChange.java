package com.hy.powerplatform.my_utils.myViews;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

/**
 * Created by dell on 2018/5/9.
 */

public class EditTextChange {

    EditText editText;
    int num = 0;
    public EditTextChange(EditText editText){
        this.editText = editText;
    }
    public void changeText(){

        editText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == KeyEvent.KEYCODE_DEL) {
                    num++;
                    if (num % 2 != 0) {
                        String s = editText.getText().toString();
                        if (!TextUtils.isEmpty(s)) {
                            editText.setText("" + s.substring(0, s.length() - 1));
                            //将光标移到最后
                            editText.setSelection(editText.getText().length());
                        }

                    }
                    return true;
                }
                return false;
            }
        });
        //在这里加判断的原因是点击一次软键盘的删除键,会触发两次回调事件

    }
}
