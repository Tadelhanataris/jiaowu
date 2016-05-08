package utils;

import org.json.*;

import java.util.ArrayList;


/**
 * Created by T on 2016/5/8.
 */
public class jsonhelper {

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
