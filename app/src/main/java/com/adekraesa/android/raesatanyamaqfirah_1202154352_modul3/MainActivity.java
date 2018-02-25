package com.adekraesa.android.raesatanyamaqfirah_1202154352_modul3;

import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<Drink> mDrinkData;
    private DrinkAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "Selamat Datang", Toast.LENGTH_SHORT).show();

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        int gridColumn = getResources().getInteger(R.integer.grid_column_count);

        mRecyclerView.setLayoutManager(new GridLayoutManager(this, gridColumn));

        mDrinkData = new ArrayList<>();

        mAdapter = new DrinkAdapter(this, mDrinkData);
        mRecyclerView.setAdapter(mAdapter);

        initialiseData();

    }

    private void initialiseData(){
        String[] airList = getResources().getStringArray(R.array.name_src);
        String[] airInfo = getResources().getStringArray(R.array.info_src);
        TypedArray airImageResource = getResources().obtainTypedArray(R.array.img_src);
        mDrinkData.clear();

        for (int i=0; i<airList.length; i++){
            mDrinkData.add(new Drink (airList[i], airInfo[i], airImageResource.getResourceId(i, 0)));
        }

        airImageResource.recycle();

        mAdapter.notifyDataSetChanged();
    }
}
