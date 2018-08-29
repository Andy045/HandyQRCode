package com.handy.qrcode.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.handy.qrcode.module.ScanConfig;
import com.handy.qrcode.module.ScanLauncher;

/**
 * 类名
 *
 * @author LiuJie https://www.Handy045.com
 * @description 类功能内容
 * @date Created in 2018/6/5 下午4:58
 * @modified By LiuJie
 */
public class ScanActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);

        TitleBar titleBar = findViewById(R.id.titlebar);
        titleBar.setTitle("扫描条码和二维码");
        titleBar.setTitleBarBackground(R.color.titlebar_background);
        titleBar.setImmersive(ScanActivity.this, true);
        titleBar.addLeftAction(new TitleBar.Action() {
            @Override
            public void onClick() {
                finish();
            }

            @Override
            public int setDrawable() {
                return com.handy.qrcode.R.drawable.handy_qrcode_select_titlebar_back;
            }
        });

        findViewById(R.id.zxing_single).setOnClickListener(v -> {
            ((TextView) findViewById(R.id.result)).setText("");

            ScanConfig.KEY_DECODE_1D_INDUSTRIAL = true;
            ScanConfig.KEY_DECODE_1D_PRODUCT = true;

            new ScanLauncher().startSingle(ScanActivity.this, result -> {
                ((TextView) findViewById(R.id.result)).setText("扫描结果: \n" + result);
            });
        });
    }
}

