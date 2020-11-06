package com.ali.pubgground.di;

import com.ali.pubgground.data.Repository;
import com.ali.pubgground.data.source.remote.PubggApiService;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.components.ApplicationComponent;

@Module
@InstallIn(ApplicationComponent.class)
class RepoModule {

    @Provides
    @Singleton
    public static Repository provideRepository(PubggApiService service) {
        return new Repository(service);
    }

}
