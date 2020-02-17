package com.zolmk.net.http.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;

import androidx.core.app.ActivityCompat;



public class PermissionUtil {
    private Activity activity;
    private String[] permissions = {
            Manifest.permission.WRITE_EXTERNAL_STORAGE,
            Manifest.permission.READ_EXTERNAL_STORAGE
    };
    private int REQUEST_CODE = 0;

    /**
     * 动态请求权限
     * @param activity 请求权限的activity
     */
    public PermissionUtil(Activity activity){
        this.activity = activity;
    }
    public void requestPermission(){
        ActivityCompat.requestPermissions(activity,permissions,REQUEST_CODE);
    }

    /**
     * 权限请求回调
     * @param requestCode
     * @param grantResults
     */
    public void onRequestPermissionsResult(int requestCode,int[] grantResults){

    }

    /**
     * 转到设置界面
     */
    public void goToAppSetting(){
        Intent intent = new Intent();
        intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        Uri uri = Uri.fromParts("package",this.activity.getPackageName(),null);
        intent.setData(uri);
        activity.startActivity(intent);
    }
    public String[] nextRequest(){
        return null;
    }

}
