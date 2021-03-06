package com.example.myapplication;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvViewMain;
    private DrawView dvMain;
    private Button btnViewOne;
    private Button btnViewTwo;
    private Button btnViewThree;
    private Button btnViewFour;
    private ImageView ivViewOne;
    private DrawView dv;
    private Button btnViewFive;
    private int pos;
    private ArrayList<Integer> colorsid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        initView();
    }

    private void initView() {
        rvViewMain = (RecyclerView) findViewById(R.id.rv_view_main);
        dvMain = (DrawView) findViewById(R.id.dv_main);
        btnViewOne = (Button) findViewById(R.id.btn_view_one);
        btnViewTwo = (Button) findViewById(R.id.btn_view_two);
        btnViewThree = (Button) findViewById(R.id.btn_view_three);
        btnViewFour = (Button) findViewById(R.id.btn_view_four);
        ivViewOne = (ImageView) findViewById(R.id.iv_view_one);
        btnViewFive = (Button) findViewById(R.id.btn_view_five);

        rvViewMain.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL));

        colorsid = new ArrayList<>();
        colorsid.add(Color.BLACK);
        colorsid.add(Color.DKGRAY);
        colorsid.add(Color.GRAY);
        colorsid.add(Color.LTGRAY);
        colorsid.add(Color.WHITE);
        colorsid.add(Color.RED);
        colorsid.add(Color.GREEN);
        colorsid.add(Color.BLUE);
        colorsid.add(Color.YELLOW);
        colorsid.add(Color.CYAN);
        colorsid.add(Color.MAGENTA);

        colorsid.add(Color.BLACK);
        colorsid.add(Color.DKGRAY);
        colorsid.add(Color.GRAY);
        colorsid.add(Color.LTGRAY);
        colorsid.add(Color.WHITE);
        colorsid.add(Color.RED);
        colorsid.add(Color.GREEN);
        colorsid.add(Color.BLUE);
        colorsid.add(Color.YELLOW);
        colorsid.add(Color.CYAN);
        colorsid.add(Color.MAGENTA);

        colorsid.add(Color.BLACK);
        colorsid.add(Color.DKGRAY);
        colorsid.add(Color.GRAY);
        colorsid.add(Color.LTGRAY);
        colorsid.add(Color.WHITE);
        colorsid.add(Color.RED);
        colorsid.add(Color.GREEN);
        colorsid.add(Color.BLUE);
        colorsid.add(Color.YELLOW);
        colorsid.add(Color.CYAN);
        colorsid.add(Color.MAGENTA);

        colorsid.add(Color.BLACK);
        colorsid.add(Color.DKGRAY);
        colorsid.add(Color.GRAY);
        colorsid.add(Color.LTGRAY);
        colorsid.add(Color.WHITE);
        colorsid.add(Color.RED);
        colorsid.add(Color.GREEN);
        colorsid.add(Color.BLUE);
        colorsid.add(Color.YELLOW);
        colorsid.add(Color.CYAN);
        colorsid.add(Color.MAGENTA);

        colorsid.add(Color.BLACK);
        colorsid.add(Color.DKGRAY);
        colorsid.add(Color.GRAY);
        colorsid.add(Color.LTGRAY);
        colorsid.add(Color.WHITE);
        colorsid.add(Color.RED);
        colorsid.add(Color.GREEN);
        colorsid.add(Color.BLUE);
        colorsid.add(Color.YELLOW);
        colorsid.add(Color.CYAN);
        colorsid.add(Color.MAGENTA);


        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(colorsid, this);
        rvViewMain.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();

        dv = (DrawView) findViewById(R.id.dv_main);

        recyclerViewAdapter.setOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {
                dv.paint.setXfermode(null);//??????????????????
                dv.paint.setStrokeWidth(1);//????????????????????????

                dv.paint.setColor(colorsid.get(position));//??????????????????
                pos = position;
                ivViewOne.setColorFilter(colorsid.get(pos));

            }
        });

        ivViewOne.setColorFilter(Color.RED);
        btnViewOne.setOnClickListener(this);
        btnViewTwo.setOnClickListener(this);
        btnViewThree.setOnClickListener(this);
        btnViewFour.setOnClickListener(this);
        btnViewFive.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        dv.paint.setXfermode(null);//??????????????????
        dv.paint.setStrokeWidth(1);//????????????????????????
        switch (v.getId()) {
            case R.id.btn_view_one:
                dv.paint.setStrokeWidth(1);//????????????????????????1??????

                break;
            case R.id.btn_view_two:
                dv.paint.setStrokeWidth(5);//????????????????????????5??????
                break;
            case R.id.btn_view_three:
                dv.paint.setStrokeWidth(10);//????????????????????????10??????
                break;
            case R.id.btn_view_four:
                dv.clear();//????????????
                break;
            case R.id.btn_view_five:
                initPers();//????????????
                break;
        }
    }

    //????????????
    public void initPers() {
        //??????????????????????????????
        //1.????????????????????????
        //2.????????????,???,????????????,??????,?????????
        int result = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //?????????
        //    public static final int PERMISSION_GRANTED = 0;
        //????????????
        //    public static final int PERMISSION_DENIED = -1;
        if (result == PackageManager.PERMISSION_GRANTED) {
            //??????????????????????????????
            dv.save();//????????????
            Toast.makeText(this,"???????????????????????????",Toast.LENGTH_SHORT).show();
        } else {
            //????????????
            //3.????????????
            String[] pers = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            ActivityCompat.requestPermissions(this, pers, 100);
        }
        //4.??????????????????,onRequestPermissionsResult()
    }

    //????????????
    ////4.??????????????????,
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //?????????
                dv.save();//????????????
                Toast.makeText(this,"???????????????????????????",Toast.LENGTH_SHORT).show();
            } else {
                //????????????
                Toast.makeText(this, "??????????????????????????????????????????????????????", Toast.LENGTH_SHORT).show();
                //????????????????????? (??????)
                initPers();
            }
        }
    }
}


