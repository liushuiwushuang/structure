package chuang.shlg.com.structure.ui;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import chuang.shlg.com.structure.App;
import chuang.shlg.com.structure.injection.component.ActivityComponent;

/**
 * Created by Administrator on 2017/12/30.
 * @author MagicRain
 */

public class BaseActivity extends AppCompatActivity {

    private ActivityComponent activityComponent;

    private ProgressDialog loadingDialog;

    @Override
    protected void onDestroy() {
        hideLoading();
        super.onDestroy();
    }

    /********* Define BaseActivity methods *********************/

    protected ActivityComponent getActivityComponent() {
        if (activityComponent == null) {
            activityComponent = ((App)this.getApplication()).getApplicationComponent().newActivityComponent();
        }
        return activityComponent;
    }

    public void toastShort(final String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();

        Handler mainHandler = new Handler(this.getMainLooper());
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                Toast.makeText(BaseActivity.this, text, Toast.LENGTH_SHORT).show();
            } // This is your code
        };
        mainHandler.post(myRunnable);
    }

    public void showLoading(String text) {
        if(isShowingLoading()) {
            loadingDialog.setMessage(text);
        } else {
            loadingDialog = ProgressDialog.show(this, "", text, true);
        }
    }

    public void hideLoading() {
        if (isShowingLoading()) {
            loadingDialog.dismiss();
        }
    }

    protected boolean isShowingLoading() {
        return loadingDialog != null && loadingDialog.isShowing();
    }
}
