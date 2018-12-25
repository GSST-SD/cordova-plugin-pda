

package cordova.plugin.pda;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.PluginResult;
import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.BroadcastReceiver;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

import java.util.List;

public class ScanerUtil extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("readScanerText")) {
            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK,"不想扫描");
            pluginResult.setKeepCallback(true);
            callbackContext.sendPluginResult(pluginResult);
            //定义条码Receiver
//            BroadcastReceiver mScanDataReceiver = new BroadcastReceiver(){
//                @Override
//                public void onReceive(Context context, Intent intent){
//                    String action = intent.getAction();
////                    int keycode = intent.getIntExtra("Scan_Keycode", 0);
//                    try {
//                        if (action.equals("com.android.scancontext")){
//                            // 前台输出
//                            String str = intent.getStringExtra("Scan_context");
//                            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK,str );
//                            pluginResult.setKeepCallback(true);
//                            callbackContext.sendPluginResult(pluginResult);
//                            //注销条码Receiver
//                            unregisterReceiver(mScanDataReceiver);
//                        } else if (action.equals("com.android.scanservice.scancontext")) {
//                            // 后台输出
//                            String str = intent.getStringExtra("Scan_context");
//                            PluginResult pluginResult = new PluginResult(PluginResult.Status.OK,str );
//                            pluginResult.setKeepCallback(true);
//                            callbackContext.sendPluginResult(pluginResult);
//                            //注销条码Receiver
//                            unregisterReceiver(mScanDataReceiver);
//                        }
//                    } catch (Exception e) {
//                        PluginResult pluginResult = new PluginResult(PluginResult.Status.OK,"获取扫描结果失败");
//                        pluginResult.setKeepCallback(true);
//                        callbackContext.sendPluginResult(pluginResult);
//                    }
//
//                }
//            };
//
//            //注册条码Receiver
//            IntentFilter scanDataIntentFilter = new IntentFilter();
//            scanDataIntentFilter.addAction("com.android.scancontext");
//            scanDataIntentFilter.addAction("com.android.scanservice.scancontext");
//            registerReceiver(mScanDataReceiver, scanDataIntentFilter);
//
//            if(!isServiceRunning("com.android.scanservice.ScanService")) {
//                Toast.makeText(activity, "未检测到扫描服务", Toast.LENGTH_LONG).show();
//                //注销条码Receiver
//                unregisterReceiver(mScanDataReceiver);
//                return false;
//            }
            return true;
        }
        return false;
    }



//    //扫描，对应“扫描键”down
//    private void startDecode() {
//        /*
//        // 扫描键禁用时，此intent无效
//        Intent intent = new Intent("android.intent.action.FUNCTION_BUTTON_DOWN", null);
//        sendBroadcast(intent);
//        */
//        Intent intent = new Intent("com.android.scanservice.scan.button.down", null);
//        sendBroadcast(intent);
//    }
//
//    //停止扫描，对应“扫描键”up
//    private void stopDecode() {
//        /*
//        // 扫描键禁用时，此intent无效
//        Intent intent = new Intent("android.intent.action.FUNCTION_BUTTON_UP", null);
//        sendBroadcast(intent);
//        */
//        Intent intent = new Intent("com.android.scanservice.scan.button.up", null);
//        sendBroadcast(intent);
//    }
//
//    //打开扫描头，对应“扫描服务”中“启用扫描”打勾
//    private void scanEnable() {
//        Intent intent = new Intent("com.android.scanservice.scan.on", null);
//        sendBroadcast(intent);
//    }
//
//    //关闭扫描头，对应“扫描服务”中“启用扫描”不打勾
//    private void scanDisable() {
//        Intent intent = new Intent("com.android.scanservice.scan.off", null);
//        sendBroadcast(intent);
//    }
//
//    //启用扫描键，对应“扫描服务”中“扫描模式”打勾
//    private void scanButtonEnable() {
//        Intent intent = new Intent("com.android.scanservice.scan.button.enabled", null);
//        intent.putExtra("Scan_button_enabled", true);
//        sendBroadcast(intent);
//    }
//
//    //禁用扫描键，对应“扫描服务”中“扫描模式”不打勾
//    private void scanButtonDisable() {
//        Intent intent = new Intent("com.android.scanservice.scan.button.enabled", null);
//        intent.putExtra("Scan_button_enabled", false);
//        sendBroadcast(intent);
//    }
//
//    //启用前台输出，对应“扫描服务”中“前台输出”打勾
//    private void scanOutputEnable() {
//        Intent intent = new Intent("com.android.scanservice.output.foreground", null);
//        intent.putExtra("Scan_output_foreground", true);
//        sendBroadcast(intent);
//    }
//
//    //禁用前台输出，对应“扫描服务”中“前台输出”不打勾
//    private void scanOutputDisable() {
//        Intent intent = new Intent("com.android.scanservice.output.foreground", null);
//        intent.putExtra("Scan_output_foreground", false);
//        sendBroadcast(intent);
//    }


    // 检查Service是否运行
    private boolean isServiceRunning(String className) {
        boolean isRunning = false;
        ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        List<ActivityManager.RunningServiceInfo> serviceList = activityManager.getRunningServices(100);

        if (!(serviceList.size() > 0)) {
            return false;
        }

        for (int i = 0; i < serviceList.size(); i++) {
            if (serviceList.get(i).service.getClassName().equals(className) == true) {
                isRunning = true;
                break;
            }
        }
        return isRunning;
    }

}
