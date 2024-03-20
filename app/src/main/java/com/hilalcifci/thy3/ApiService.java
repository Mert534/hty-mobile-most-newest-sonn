package com.hilalcifci.thy3;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiService {
    @POST("http://htytech.com.tr/api/mobile") // API'nin gerçek URL'sini buraya yazın
    Call<Void> loginUser(@Body User user); // User nesnesini JSON formatında göndermek için @Body kullanılır
}

