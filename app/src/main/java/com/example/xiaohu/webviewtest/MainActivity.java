package com.example.xiaohu.webviewtest;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements JsBridge{

    private WebView webView;
    private TextView textView;
    private EditText editText;
    private Button button;
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handler = new Handler();
        webView = findViewById(R.id.webView);
        textView = findViewById(R.id.text);
        editText = findViewById(R.id.edit);
        button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String edt = editText.getText().toString();
                webView.loadUrl("javascript:if(window.remote){window.remote('" + edt +"')}");
            }
        });
        webView.getSettings().setJavaScriptEnabled(true);
        webView.addJavascriptInterface(new JsInterface(this),"xiaohuajieko");
        webView.loadUrl("file:///android_asset/index.html");
    }

    @Override
    public void setTextView(final String value) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                textView.setText(value);
            }
        });
    }
}
