package chuang.shlg.com.structure.remote.api;

import chuang.shlg.com.structure.entity.Food;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2017/12/24.
 * @author MagicRain
 */

public interface FoodApi {

    @GET("foods")
    Observable<Response<Food>> getFood(@Query("id") Integer id);

}
