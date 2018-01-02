package chuang.shlg.com.structure.remote.api;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Response;
import rx.Subscriber;

/**
 * Created by Administrator on 2017/12/25.
 * @author MagicRain
 */

public abstract class ApiSubscriber<T> extends Subscriber<Response<T>> {

    private static final String TAG = "ApiSubscriber";

    Context context;

    public ApiSubscriber(Context activity) {
        this.context = activity;
    }

    @Override
    public void onCompleted() {
        Log.e(TAG, "出现了");
    }

    @Override
    public void onError(Throwable e) {
        Log.e(TAG, "##onError();", e);
        if (e instanceof RuntimeException) {
            tryToastShort(e.getMessage());
        } else {
            tryToastShort("Network Connection Error");
        }
    }

    @Override
    public void onNext(Response<T> response) {
        if (response.isSuccessful()) {
            try {
                httpSuccess(response.body());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            int code = response.code();
            String body = null;
            ResponseBody responseBody = response.errorBody();
            try {
                body = responseBody.string();
            } catch (IOException e) {
                Log.e(TAG, "##onNext()", e);
            } finally {
                responseBody.close();
            }
            httpError(code, body);
        }
    }

    protected abstract void httpSuccess(T t) throws IOException;

    protected void httpError(int code, String body) {
        String message = "Unknown error, please check network connection";
        try {
            message = JSON.parseObject(body).getString("message");
            tryToastShort(message);
        } catch (Exception e) {
            Log.e(TAG, "##httpError()", e);
            tryToastShort(message);
        }
    }


    private void tryToastShort(String message) {
        if(context != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        }
    }

}
