package com.datum.volstatus;

import org.apache.cordova.*;
import org.json.JSONArray;
import org.json.JSONException;

import android.location.LocationManager;
import android.location.Location;
import android.location.LocationListener;
import android.util.Log;
import android.content.Context;
import android.os.Bundle;

public class VolStatus extends CordovaPlugin {

	private static CordovaWebView webView = null;

    private static CordovaInterface cordova = null;
    private static String TAG = "MFSUtils";

    @Override
    public void initialize (CordovaInterface cordova, CordovaWebView webView) {
        //LocalNotification.webView = super.webView;
        //LocalNotification.cordova = cordova;
        /*if(webView != null){
            String webUrl = webView.getUrl();
            Log.d("lNtfy","initializing - "+ webUrl);
        }*/

        try {
            if(this.webView == null){
                Log.d(TAG,"initialize - referencing instance webView");
                this.webView = webView;
            }
        } catch(Exception e) {
            //throw e;
            Log.e(TAG,"initialize - referencing instance webView, thrown exception "+ e);

        }
        try {
            if(this.cordova == null){
                Log.d(TAG,"initialize - referencing instance cordova");
                this.cordova = cordova;
            }
        } catch(Exception e) {
            //throw e;
            Log.e(TAG,"initialize - referencing instance cordova, thrown exception "+ e);

        }
    }

	@Override
    public boolean execute(String action, JSONArray data, CallbackContext callbackContext) throws JSONException {

        if (action.equals("getVolStatus")) {

            getVolStatus(command);

        } else {
            
            return false;

        }
    }

    /**
     * If a notification with an ID is present.
     *
     * @param command
     *      The callback context used when calling back into JavaScript.
     */
    private void getVolStatus (CallbackContext command) {
        Context Context = this.cordova.getActivity().getApplicationContext();
        AudioManager am = (AudioManager) Context.getSystemService(Context.AUDIO_SERVICE);
        String statusText = "";
        switch( am.getRingerMode() ){
            case AudioManager.RINGER_MODE_NORMAL:
                statusText = "NORMAL";
                break;
            case AudioManager.RINGER_MODE_SILENT:
                statusText = "SILENT";
                break;
            case AudioManager.RINGER_MODE_VIBRATE:
                statusText = "VIBRATE";
                break;
        }
        PluginResult result = new PluginResult(
                PluginResult.Status.OK, statusText);

        command.sendPluginResult(result);
    }
}