package com.ali.pubgground.data.source.remote;

import com.ali.pubgground.data.model.Response;
import retrofit2.http.GET;
import io.reactivex.rxjava3.core.Observable;

public interface PubggApiService {

    @GET("missions")
    Observable<Response> getMission();
}
