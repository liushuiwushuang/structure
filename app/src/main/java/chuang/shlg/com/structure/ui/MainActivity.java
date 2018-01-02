package chuang.shlg.com.structure.ui;

import android.os.Bundle;
import android.widget.TextView;
import javax.inject.Inject;
import javax.inject.Provider;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import chuang.shlg.com.structure.R;
import chuang.shlg.com.structure.entity.Food;
import chuang.shlg.com.structure.helper.CacheHelper;
import chuang.shlg.com.structure.remote.api.ApiSubscriber;
import chuang.shlg.com.structure.remote.api.FoodApi;
import chuang.shlg.com.structure.util.ApiUtil;
import rx.functions.Action0;

public class MainActivity extends BaseActivity {

//    private static final String TAG = "MainActivity";

    @Inject
    Provider<FoodApi> foodApiProvider;

    @Inject
    CacheHelper cacheHelperProvider;

    @BindView(R.id.hello_textview)
    TextView helloTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getActivityComponent().inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.hello_textview)
    void helloTextViewClick() {
        requestFood();
    }

    @OnClick(R.id.button)
    void buttonClick() {
        requestFood();
    }

    private void requestFood() {
        ApiUtil.invokeAsync(foodApiProvider.get().getFood(1))
            .doOnSubscribe(new Action0() {
                @Override
                public void call() {
                    showLoading("Loading...");
                }
            })
            .doAfterTerminate(new Action0() {
                @Override
                public void call() {
                    hideLoading();
                }
            })
            .subscribe(new ApiSubscriber<Food>(this) {

                @Override
                protected void httpSuccess(Food f) {
                    showLoading("request success");
                    if (f != null) {
                        helloTextView.setText(f.getFoodName());
                    } else {
                        toastShort("food not get");
                    }

                }
            });
    }

}
