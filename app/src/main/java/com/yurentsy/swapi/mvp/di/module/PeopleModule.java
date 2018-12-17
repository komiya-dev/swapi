package com.yurentsy.swapi.mvp.di.module;

import android.view.LayoutInflater;

import com.yurentsy.swapi.gui.adapter.people.PeopleAdapter;
import com.yurentsy.swapi.gui.adapter.people.PeopleListItemViewHolderFactory;
import com.yurentsy.swapi.gui.fragment.PeopleFragment;
import com.yurentsy.swapi.mvp.di.scope.ListScope;

import dagger.Module;
import dagger.Provides;

@Module
public class PeopleModule {
    private final PeopleFragment peopleFragment;

    public PeopleModule(PeopleFragment fragment) {
        this.peopleFragment = fragment;
    }

    @ListScope
    @Provides
    PeopleAdapter providePeopleAdapter(PeopleListItemViewHolderFactory factory) {
        return new PeopleAdapter(factory);
    }

    @ListScope
    @Provides
    PeopleListItemViewHolderFactory providePeopleListItemViewHolderFactory(LayoutInflater layoutInflater) {
        return new PeopleListItemViewHolderFactory(layoutInflater, peopleFragment);
    }
}
