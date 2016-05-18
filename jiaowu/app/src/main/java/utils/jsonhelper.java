package utils;

import android.support.annotation.NonNull;

import org.json.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;


/**
 * Created by T on 2016/5/8.
 */
public class jsonhelper {

    public static final JSONArray arrayParse(byte[] _byte)
    {
        String json_s = "";
        try {
            json_s = new String(_byte, "UTF-8");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return arrayParse(json_s);
    }


    public static final JSONArray arrayParse(String json)
    {
        JSONArray array = null;
        try {
            array = new JSONArray(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return array;
    }

    public static final JSONObject ObjectParse(byte[] _byte)
    {
        String json_s = "";
        try {
            json_s = new String(_byte, "UTF-8");
        }catch(Exception e) {
            e.printStackTrace();
        }
        return ObjectParse(json_s);
    }


    public static final JSONObject ObjectParse(String json)
    {
        JSONObject obj = null;
        try {
            obj = new JSONObject(json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
