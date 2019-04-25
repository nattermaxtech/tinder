package com.targetcompetitions.tinder;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.ArrayList;

import android.view.View;
import android.widget.ArrayAdapter;
import com.lorentzos.flingswipe.SwipeFlingAdapterView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ArrayList<String> al;
    private ArrayAdapter<String> arrayAdapter;
    private SwipeFlingAdapterView swipeFlingAdapterView;
    private int i;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.leftButton).setOnClickListener(this);
        findViewById(R.id.rightButton).setOnClickListener(this);

        al = new ArrayList<>();
        al.add("php");
        al.add("c");
        al.add("python");
        al.add("java");
        al.add("html");
        al.add("c++");
        al.add("css");
        al.add("javascript");

        arrayAdapter = new ArrayAdapter<>(this, R.layout.item, R.id.helloText, al);

        swipeFlingAdapterView = findViewById(R.id.flingView);
        swipeFlingAdapterView.setAdapter(arrayAdapter);
        swipeFlingAdapterView.setFlingListener(new SwipeFlingAdapterView.onFlingListener(){

            @Override
            public void onLeftCardExit(Object dataObject){
                Toast.makeText(MainActivity.this, "Left Card Exit", Toast.LENGTH_SHORT).show();
            }


            @Override
            public void onRightCardExit(Object dataObject){
                Toast.makeText(MainActivity.this, "Right Card Exit", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdapterAboutToEmpty(int itemInAdapter){
                al.add("XML ".concat(String.valueOf(i)));
                arrayAdapter.notifyDataSetChanged();
                i++;
            }

            @Override
            public void onScroll(float scrollProgressPercent){
                //TODO
            }

            @Override
            public void removeFirstObjectInAdapter(){
                al.remove(0);
                arrayAdapter.notifyDataSetChanged();
            }

        });

        swipeFlingAdapterView.setOnItemClickListener(new SwipeFlingAdapterView.OnItemClickListener(){
            @Override
            public void onItemClicked(int itemPosition, Object dataObject){
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onClick(View view){
        switch(view.getId()){
            case R.id.leftButton:
                leftButton(view);
                break;
            case R.id.rightButton:
                rightButton(view);
                break;
        }
    }


    private void leftButton(View view){
        swipeFlingAdapterView.getTopCardListener().selectLeft();
    }

    private void rightButton(View view){
        swipeFlingAdapterView.getTopCardListener().selectRight();
    }
}