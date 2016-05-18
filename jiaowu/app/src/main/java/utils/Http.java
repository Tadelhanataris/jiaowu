package utils;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;

import com.example.ataris.jiaowu.Notice;
import com.example.ataris.jiaowu.Review;
import com.example.ataris.jiaowu.Schedule;
import com.example.ataris.jiaowu.project;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Ataris on 16/5/8.
 */
public class Http {

    public static final String server = "http://10.0.2.2:9292/";
    public static final String notice = "notice";
    public static final String _project = "project";
    public static final String review = "review";
    public static final String schedule = "schedule";
    public static final String chose_class = "choseclass";
    public static final String share = "share";
    public static final String download = "download";


    public static void httpGet(final String type) {
        httpGet(type,null);
    }


    public static void httpGet(final String type,final String param) {
        new AsyncTask<String, Void, byte[]>() {
            @Override
            protected byte[] doInBackground(String... params) {
                byte[] stream = null;
                try {
                    URL url = new URL(params[0]);
                    URLConnection uc = url.openConnection();
                    InputStream is = uc.getInputStream();
                    stream = new byte[uc.getContentLength()];
                    is.read(stream);
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
                switch (type)
                {
                    case "notice":m.arg1=0;Notice.instance.mHandler.sendMessage(m);break;
                    case "project":m.arg1=1;project.instance.mHandler.sendMessage(m);break;
                    case "review":m.arg1=2;Review.instance.mHandler.sendMessage(m);break;
                    case "schedule":m.arg1=3;Schedule.instance.mHandler.sendMessage(m);break;
                    case "choseclass":m.arg1=4;break;
                    case "share":m.arg1=5;break;
                    case "download":m.arg1=6;break;
                }
            }
        }.execute(Http.server+type+"/"+(param!=null?param:""));
    }

}
