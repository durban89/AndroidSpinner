package com.gowhich.androidspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.SimpleAdapter;
import android.widget.Spinner;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private Spinner spinner2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //使用Spinner方式一
        spinner = (Spinner) this.findViewById(R.id.spinner);
        List<String> list = MyAdapter.getData();
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_dropdown_item_1line, list);
        spinner.setAdapter(adapter);

        //使用Spinner方式二
        spinner2 = (Spinner) this.findViewById(R.id.spinner2);
        List<Map<String, Object>> data = MyAdapter.getMapData();
        SimpleAdapter simpleAdapter = new SimpleAdapter(MainActivity.this, data, R.layout.item, new String[]{"image", "text"}, new int[]{R.id.imageView, R.id.textView});
        spinner2.setAdapter(simpleAdapter);

        //选中事件
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String title = ((Map<String, Object>)spinner2.getItemAtPosition(i)).get("text").toString();
                setTitle(title);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
