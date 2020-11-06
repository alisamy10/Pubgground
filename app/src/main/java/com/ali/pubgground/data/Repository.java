package com.ali.pubgground.data;


import com.ali.pubgground.data.model.Response;
import com.ali.pubgground.data.source.remote.PubggApiService;
import io.reactivex.rxjava3.core.Observable;
import javax.inject.Inject;

public class Repository {
    private  PubggApiService pubggApiService;

    @Inject
    public Repository(PubggApiService pubggApiService) {
        this.pubggApiService = pubggApiService;
    }

    public Observable<Response> getMissions(){
        return pubggApiService.getMission();
    }
}
