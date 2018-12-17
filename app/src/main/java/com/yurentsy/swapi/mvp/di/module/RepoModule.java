package com.yurentsy.swapi.mvp.di.module;

import com.yurentsy.swapi.mvp.model.api.Api;
import com.yurentsy.swapi.mvp.model.cache.Cache;
import com.yurentsy.swapi.mvp.model.repo.Repo;
import com.yurentsy.swapi.mvp.model.repo.StarWarsRepo;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(includes = {ApiModule.class, CacheModule.class})
public class RepoModule {
    @Singleton
    @Provides
    Repo provideRepo(Api api, Cache cache) {
        return new StarWarsRepo(api, cache);
    }
}
