package com.yurentsy.swapi.mvp.di.module;

import com.yurentsy.swapi.mvp.model.cache.Cache;
import com.yurentsy.swapi.mvp.model.cache.StarWarsCache;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class CacheModule {
    @Singleton
    @Provides
    public Cache provideCache() {
        return new StarWarsCache();
    }
}
