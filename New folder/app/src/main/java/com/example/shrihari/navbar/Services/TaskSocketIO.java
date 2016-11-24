package com.example.shrihari.navbar.Services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import com.example.shrihari.navbar.DataObject.dataObject;
import com.example.shrihari.navbar.R;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.SocketIOException;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Shrihari on 11/7/2016.
 */
public class TaskSocketIO extends Service {
   //private final IBinder mBinder = new MyBinder();
    static boolean mRunning;
    static ArrayList<dataObject> list = new ArrayList<dataObject>();
    private static com.github.nkzawa.socketio.client.Socket msocket;{
        try{

            msocket = IO.socket("http://192.168.0.103:1000");
        }catch(Exception e){
           Log.e("Error occured",e.toString());
            throw new RuntimeException(e);

        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mRunning = false;

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        if(!mRunning){
            mRunning = true;
            msocket.connect();

            msocket.on("news",onNewMessage);
        }
        return Service.START_STICKY;

    }

    public static ArrayList<dataObject> getWordList() {

        return list;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        msocket.disconnect();
    }

    public static void addTask(JSONObject jsonObject){
        msocket.emit("addTask",jsonObject);
    }

    private Emitter.Listener onNewMessage = new Emitter.Listener() {

        String name;
        boolean completed;
        @Override
        public void call(Object... args) {
            JSONObject data = (JSONObject) args[0];

            try {
                name = data.getString("name");
                completed = data.getBoolean("completed");
                dataObject a = new dataObject(name,completed);
               // Log.e("SOCKETIO message",name+" "+true);

                notif("Task",name);
                list.add(a);
                Log.e("SHRIHARI"," "+list.size());
            }catch (JSONException j){
                j.printStackTrace();
            }

        }
    };

    private void notif(String title,String text){
        Intent intent = new Intent();
        PendingIntent pendingIntent = PendingIntent.getActivity(TaskSocketIO.this,0,intent,0);
        Notification.Builder notification = new Notification.Builder(this)
                .setTicker("Ticker Title")
                .setContentTitle(title)
                .setContentText(text)
                .setSmallIcon(R.drawable.ic_menu_gallery)
                .setContentIntent(pendingIntent);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(TaskSocketIO.this);
        //stackBuilder.addParentStack()

        NotificationManager mnotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            mnotificationManager.notify(0,notification.build());
        }
    }
}
