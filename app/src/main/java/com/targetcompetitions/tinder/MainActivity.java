package com.targetcompetitions.tinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import java.util.ArrayList;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayAdapter<String> adapter;
    private SwipeFlingAdapterView flingContainer;
    private ArrayList<String> al;
    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.leftButton).setOnClickListener(this);
        findViewById(R.id.rightButton).setOnClickListener(this);

        flingContainer = findViewById(R.id.swipeFlingView);
        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");
        adapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);
        flingContainer.setAdapter(adapter);

        flingContainer.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){

            @Override
            public void onLeftCardExit(Object dataObject){
                makeToast("Left");
            }

            @Override
            public void onRightCardExit(Object dataObject){
                makeToast(("Right"));
            }

            @Override
            public void onAdapterAboutToEmpty(int itemsInAdapter){
                al.add("XML ".concat(String.valueOf(count)));
                adapter.notifyDataSetChanged();
                count++;
            }

            @Override
            public void onScroll(float scrollProgressPercent){

            }

            @Override
            public void removeFirstObjectInAdapter(){
                al.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

        flingContainer.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener(){
            @Override
            public void onItemClicked(int itemPostition, Object dataObject){
                makeToast(((String)dataObject).concat(" clicked"));
            }
        });


    }

    private void makeToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.leftButton:
                onLeftButtonClick(view);
                break;

            case R.id.rightButton:
                onRightButtonClick(view);
                break;
        }
    }

    private void onLeftButtonClick(View view){
        flingContainer.getTopCardListener().selectLeft();
    }

    private void onRightButtonClick(View view){
        flingContainer.getTopCardListener().selectRight();
    }
}