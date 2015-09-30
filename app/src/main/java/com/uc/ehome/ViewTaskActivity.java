package com.uc.ehome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Stephanie Lyn on 9/24/2015.
 */
public class ViewTaskActivity extends AppCompatActivity {

    ImageView img;
    TextView title, location, status;
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_task);

        img = (ImageView) findViewById(R.id.view_task_attached_image);
        title = (TextView) findViewById(R.id.view_task_title);
        location = (TextView) findViewById(R.id.view_task_location);

    }
}
