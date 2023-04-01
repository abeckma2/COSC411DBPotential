package com.example.cosc411alternative;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String wordString="";
    String encryptString="";
    String descryptString="";
    int sumOfAscii=0;
    int chosenCharPosition=0;
    
    int chosenCharValue=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void encrypt(View v)
    {
        EditText encryptMessage=(EditText) findViewById(R.id.edit_one);
        TextView entext=(TextView) findViewById(R.id.textview_encrypt);
        TextView text2=(TextView) findViewById(R.id.encrypt_text);
        wordString=encryptMessage.getText().toString();

        //text.setText(wordString);
        Encrypt encrypt=new Encrypt(wordString);
        encryptString=encrypt.getEncryptedMsg();
        entext.setText(encryptString);
        sumOfAscii=encrypt.sumOfAsciiValues;
        chosenCharPosition=encrypt.chosenCharPosition;
        chosenCharValue=encrypt.chosenCharValue;

    }
    public void decrypt(View v)
    {
        TextView text2=(TextView) findViewById(R.id.decrypt_text);
        TextView detext=(TextView) findViewById(R.id.textview_decrypt);
        Decrypt decrypt=new Decrypt(encryptString,sumOfAscii,chosenCharPosition,chosenCharValue);
        descryptString=decrypt.getDecryptedMsg();
        detext.setText(descryptString);

    }
}