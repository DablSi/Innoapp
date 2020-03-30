package com.example.innoapp.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class FetchService extends Service {
    public FetchService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
