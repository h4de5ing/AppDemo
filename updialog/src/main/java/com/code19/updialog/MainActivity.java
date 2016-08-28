package com.code19.updialog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        Button dialog2 = (Button) findViewById(R.id.dialog2);
        Button dialog = (Button) findViewById(R.id.dialog);
        dialog.setOnClickListener(this);
        dialog2.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog:
                String tips = "1.升级重要功能;\n2.修复Bug;\n3.优化性能。";
                final UpDialog upDialog = new UpDialog(this, tips, true);
                upDialog.setOnDialogListener(new UpDialog.DialogListener() {
                    @Override
                    public void onCancle() {
                        upDialog.dismiss();
                    }

                    @Override
                    public void onConfirm() {
                        upDialog.dismiss();
                    }
                });
                upDialog.show();
                break;
            case R.id.dialog2:
                UpdataDialog dialog = new UpdataDialog();
                dialog.show(getSupportFragmentManager(), getLocalClassName());
                break;
        }
    }
}
