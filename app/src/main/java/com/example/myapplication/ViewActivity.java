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
                dv.paint.setXfermode(null);//取消擦除效果
                dv.paint.setStrokeWidth(1);//初始化画笔的宽度

                dv.paint.setColor(colorsid.get(position));//设置笔的颜色
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
        dv.paint.setXfermode(null);//取消擦除效果
        dv.paint.setStrokeWidth(1);//初始化画笔的宽度
        switch (v.getId()) {
            case R.id.btn_view_one:
                dv.paint.setStrokeWidth(1);//设置笔触的宽度为1像素

                break;
            case R.id.btn_view_two:
                dv.paint.setStrokeWidth(5);//设置笔触的宽度为5像素
                break;
            case R.id.btn_view_three:
                dv.paint.setStrokeWidth(10);//设置笔触的宽度为10像素
                break;
            case R.id.btn_view_four:
                dv.clear();//擦除绘画
                break;
            case R.id.btn_view_five:
                initPers();//保存绘画
                break;
        }
    }

    //权限处理
    public void initPers() {
        //危险权限处理分为几步
        //1.清单文件配置权限
        //2.检测权限,有,该干干嘛,没有,第三步
        int result = ActivityCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE);
        //有权限
        //    public static final int PERMISSION_GRANTED = 0;
        //没有权限
        //    public static final int PERMISSION_DENIED = -1;
        if (result == PackageManager.PERMISSION_GRANTED) {
            //有权限，开始保存绘画
            dv.save();//保存绘画
            Toast.makeText(this,"已保存到手机根目录",Toast.LENGTH_SHORT).show();
        } else {
            //没有权限
            //3.申请权限
            String[] pers = {
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            };
            ActivityCompat.requestPermissions(this, pers, 100);
        }
        //4.处理申请结果,onRequestPermissionsResult()
    }

    //权限处理
    ////4.处理申请结果,
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 100) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //有权限
                dv.save();//保存绘画
                Toast.makeText(this,"已保存到手机根目录",Toast.LENGTH_SHORT).show();
            } else {
                //没有权限
                Toast.makeText(this, "获取存储权限被拒绝了，正在重新获取！", Toast.LENGTH_SHORT).show();
                //重新提取权限！ (选填)
                initPers();
            }
        }
    }
}


