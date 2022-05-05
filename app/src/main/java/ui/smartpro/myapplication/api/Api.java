package ui.smartpro.myapplication.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import ui.smartpro.myapplication.response.AccessToken;
import ui.smartpro.myapplication.response.Response;
import ui.smartpro.myapplication.response.User;

public interface Api {

    @POST("oauth/token")
    @FormUrlEncoded
    Call<AccessToken> getToken(
            @Field("grant_type") String grant_type,
            @Field("username") String username,
            @Field("password") String password
    );

    @GET("user")
    Call<Response> getUser();
}
