package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private PopupWindow popWnd;
    private Button btnPopuOne;
    private Button btnPopuTwo;
    private Button btnPopuThree;
    private Button btnPopuBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void btn_set(View view) {

        View contentView = LayoutInflater.from(MainActivity.this).inflate(R.layout.popuplayout, null);
        popWnd = new PopupWindow(this);
        popWnd.setContentView(contentView);
        popWnd.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        popWnd.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);

        popWnd.showAtLocation(contentView, Gravity.BOTTOM, 0, 0);

        btnPopuOne = (Button) contentView.findViewById(R.id.btn_popu_one);
        btnPopuTwo = (Button) contentView.findViewById(R.id.btn_popu_two);
        btnPopuThree = (Button) contentView.findViewById(R.id.btn_popu_three);
        btnPopuBack = (Button) contentView.findViewById(R.id.btn_popu_back);
        btnPopuOne.setOnClickListener(this);
        btnPopuTwo.setOnClickListener(this);
        btnPopuThree.setOnClickListener(this);
        btnPopuBack.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_popu_one: {
                Toast.makeText(this, "暂定", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_popu_two: {
                startActivity(new Intent(this, ViewActivity.class));
                break;
            }
            case R.id.btn_popu_three: {
                Toast.makeText(this, "暂定", Toast.LENGTH_SHORT).show();
                break;
            }
            case R.id.btn_popu_back: {
                popWnd.dismiss();
                break;
            }
        }
    }
}