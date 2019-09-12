package com.example.logmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.smailnet.eamil.Callback.GetSendCallback;
import com.smailnet.eamil.EmailConfig;
import com.smailnet.eamil.EmailSendClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sendMailTest();     //发送一封电子邮件

    }

    private void sendMailTest() {
        //配置邮件服务器
        EmailConfig config = new EmailConfig()
                .setSmtpHost("smtp.yeah.net")              //设置发件服务器地址
                .setSmtpPort(465)                               //设置发件服务器端口
                .setAccount("zhiwuidas@yeah.net")        //你的邮箱地址
                .setPassword("1qaz2wsx");                         //你的邮箱密码或授权码

        //邮件发送，确保配置emailConfig的信息正确
        EmailSendClient emailSendClient = new EmailSendClient(config);
        emailSendClient
                .setTo("junhuanchen@qq.com")               //收件人的邮箱地址
                .setNickname("百年小糊涂")                   //设置发信人的昵称
                .setSubject("这是一封测试邮件")              //邮件主题
                .setText("Hello World !")                   //邮件正文，若是发送HTML类型的正文用setContent()
                .sendAsyn(this, new GetSendCallback() {
                    @Override
                    public void sendSuccess() {
                        Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void sendFailure(String errorMsg) {
                        Toast.makeText(MainActivity.this, "发送失败 " + errorMsg, Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
