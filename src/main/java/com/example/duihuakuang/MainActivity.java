package com.example.duihuakuang;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bn_ts=(Button)findViewById(R.id.button_ts);
        Button bn_dl=(Button)findViewById(R.id.button_dl);
//       final EditText id=findViewById(R.id.editTextUserId);
//      final  EditText passwd=findViewById(R.id.editTextPwd);

        bn_ts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("提示对话框");
                builder.setTitle("请点击登录按钮。");
                builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
                builder.show();
            }
        });
        bn_dl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                // Get the layout inflater
                LayoutInflater factory=LayoutInflater.from(MainActivity.this);
                final View v1=factory.inflate(R.layout.login_dialog,null);
                builder.setView(v1);
                builder.setTitle("登录");                   // Add action buttons

                builder .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // login
                        EditText id=v1.findViewById(R.id.editTextUserId);
                        EditText passwd=v1.findViewById(R.id.editTextPwd);
                        String useId=id.getText().toString();
                        String usePwd=passwd.getText().toString();
                        if(useId.equals("abc")&&usePwd.equals("123")){
                            Toast.makeText(MainActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                        }else{
                           Toast.makeText(MainActivity.this,"登录失败",Toast.LENGTH_LONG).show();
                        }
                        }
                });
                builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        }
                });
                builder.show();
                    }
        });
    }
}
