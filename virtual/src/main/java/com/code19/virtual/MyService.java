package com.code19.virtual;

import android.content.Intent;
import android.net.VpnService;
import android.os.IBinder;

public class MyService extends VpnService {
    public MyService() {

    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
