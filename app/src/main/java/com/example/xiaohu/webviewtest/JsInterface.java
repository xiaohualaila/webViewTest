package com.example.xiaohu.webviewtest;

import android.util.Log;
import android.webkit.JavascriptInterface;

public class JsInterface {
    private JsBridge jsBridge;

    public JsInterface(JsBridge jsBridge) {
        this.jsBridge = jsBridge;
    }

    @JavascriptInterface
    public void setValue(String value){
        Log.i("sss",value);
        jsBridge.setTextView(value);
    }
}
