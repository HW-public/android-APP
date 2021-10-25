package com.example.myappmovies;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public class Fragment2 extends Fragment implements View.OnClickListener{
    Button button1,button2,button3,button4;
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity01, container, false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        button1=view.findViewById(R.id.button1);
        button2=view.findViewById(R.id.button2);
        button3=view.findViewById(R.id.button3);
        button4=view.findViewById(R.id.button4);
        //button.setOnKeyListener()监听
        button1.setOnClickListener(this::onClick);
        button2.setOnClickListener(this::onClick);
        button3.setOnClickListener(this::onClick);
        button4.setOnClickListener(this::onClick);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button1:
                setSelectStatus(1);
                break;
            case R.id.button2:
                setSelectStatus(2);
                break;
            case R.id.button3:
                setSelectStatus(3);
                break;
            case R.id.button4:
                setSelectStatus(4);
                break;
        }
    }
    private void setSelectStatus(int index) {
        switch (index){
            case 1:
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_1.class);
                startActivity(intent);
                break;
                }
            case 2:
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_2.class);
                startActivity(intent);
                break;
                }
            case 3:
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_3.class);
                startActivity(intent);
                break;
                }
            case 4:
            {
                Intent intent = new Intent();
                intent.setClass(getActivity(), Activity_4.class);
                startActivity(intent);
                break;
                }
        }
    }
}

