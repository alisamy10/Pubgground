package com.ali.pubgground.ui;

import android.util.Log;

import androidx.hilt.lifecycle.ViewModelInject;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ali.pubgground.data.Repository;
import com.ali.pubgground.data.model.Response;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.schedulers.Schedulers;


 class MissionsViewModel extends ViewModel  {

    private Repository repository;
    private MutableLiveData<Response> responseMutableLiveData = new MutableLiveData<>();


    @ViewModelInject
    public MissionsViewModel(Repository repository) {
        this.repository = repository;
    }


    public void getMissions() {
        repository.getMissions()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(result -> responseMutableLiveData.postValue(result),
                        error -> Log.e("viwModel", error.getMessage()));
    }

    public LiveData<Response> getMissionsList() {
        return responseMutableLiveData;
    }
}
