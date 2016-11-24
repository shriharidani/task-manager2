package com.example.shrihari.navbar.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.shrihari.navbar.R;
import com.example.shrihari.navbar.Services.TaskSocketIO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shrihari on 11/7/2016.
 */
public class AddTaskActivity extends AppCompatActivity {

    EditText task;
    CheckBox taskStatus;
    Button addTask;
    JSONObject jsonObject = new JSONObject();
    String name;
    Boolean completed;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_task);

        task = (EditText) findViewById(R.id.task);
        taskStatus = (CheckBox) findViewById(R.id.taskStatus);
        addTask = (Button) findViewById(R.id.addTask);

        addTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                completed = taskStatus.isChecked();
                name = task.getText().toString();
                try {
                   // jsonObject.put("to",to);
                   // jsonObject.put("from",from);
                    jsonObject.put("completed", completed);
                    jsonObject.put("name", name);

                    //Log.e("Name ",name);
                    //Log.e("Completed",completed.toString());
                    TaskSocketIO.addTask(jsonObject);

                }catch (JSONException j){
                    j.printStackTrace();
                }
                finish();
            }
        });


    }
}
