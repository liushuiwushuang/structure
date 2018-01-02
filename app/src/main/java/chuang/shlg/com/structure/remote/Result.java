package chuang.shlg.com.structure.remote;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */

public class Result {

    private String code;

    private String message;

    private JSONObject data;

    public boolean isValid() {
        return this.code.equals("0");
    }

    public Object get(String key) {
        return this.data.get(key);
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public JSONObject getData() {
        return data;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDate(JSONObject data) {
        this.data = data;
    }
}
