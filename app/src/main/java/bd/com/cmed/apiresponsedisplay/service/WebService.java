package bd.com.cmed.apiresponsedisplay.service;


import bd.com.cmed.apiresponsedisplay.model.BaseResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;


/**
 * Created by users on 4/25/2018.
 */

public interface WebService {

    @Headers({"Content-Type: application/json"})
    @GET("users.json")
    Call<BaseResponse> getUserList();
}
