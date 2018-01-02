package chuang.shlg.com.structure.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */
public class CacheHelper {

    private static String TAG = CacheHelper.class.getSimpleName();

    public static final String FILE_SHARED_PREFERENCE_APP = "file_shared_preference_app";

    Context context;

    SharedPreferences sharedPreferences;

    public CacheHelper(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(FILE_SHARED_PREFERENCE_APP, Context.MODE_PRIVATE);
    }

    public String readCacheAsString(String key, String defaultValue) {
        return sharedPreferences.getString(key, defaultValue);
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> readCacheAsMap(String key) {
        Map<String, Object> result = null;
        String json = readCacheAsString(key, null);
        if (json != null) {
            result = JSON.parseObject(json, Map.class);
        }
        return result;
    }

    public <T> T readCacheAsObject(String key, Class<T> clazz) {
        T result = null;
        String json = readCacheAsString(key, null);
        if (json != null) {
            result = JSON.parseObject(json, clazz);
        }
        return result;
    }


    public void writeStringCache(String key, String content) {
        SharedPreferences.Editor cacheEditor = sharedPreferences.edit();
        cacheEditor.putString(key, content);
        cacheEditor.apply();
    }

    public void writeObjectCache(String key, Object object) {
        String json = JSON.toJSONString(object);
        writeStringCache(key, json);
    }

    public void writeMapCache(String key, Map<String, Object> map) {
        String json = JSON.toJSONString(map);
        writeStringCache(key, json);;
    }
}
