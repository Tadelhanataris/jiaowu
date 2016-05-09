package utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Ataris on 16/5/8.
 */
public class Http {


    public static final String server = "http://127.0.0.1:9292/";
    public static final String notice = "notice";
    public static final String _project = "project";
    public static final String review = "review";
    public static final String schedule = "schedule";
    public static final String chose_class = "choseclass";
    public static final String share = "share";
    public static final String download = "download";
    public enum type{
        notice,_project,review,schedule,chose_class,share, download}



    public void httpGet(final String url,final type _t) {
        new AsyncTask<String, Void, byte[]>() {
            @Override
            protected byte[] doInBackground(String... params) {
                byte[] stream = null;
                try {
                    URL url = new URL(params[0]);
                    URLConnection uc = url.openConnection();
                    InputStream is = uc.getInputStream();
                    stream = new byte[uc.getContentLength()];
                    is.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return stream;
            }

            @Override
            protected void onPostExecute(byte[] stream) {
                Message m = new Message();
                m.obj = stream;
                m.what = 2564;
                m.arg1 = _t.ordinal();
                new Handler().sendMessage(m);
            }
        }.execute(url);
    }
//    Handler mHandler = new Handler(){
//
//        @Override
//        public void handleMessage(Message msg) {
//
//            super.handleMessage(msg);
//        }
//    }

}
