package ir.ARtor.onlinetv.retrofit;

import java.util.List;

import ir.ARtor.onlinetv.models.Category_model;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Retrofit_interface {
    @POST("GET_Category.php")
    Call<List<Category_model>> GetCategory(@Query("type") String type);

}
