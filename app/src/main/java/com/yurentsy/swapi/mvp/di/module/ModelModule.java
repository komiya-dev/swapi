package com.yurentsy.swapi.mvp.di.module;

import android.view.LayoutInflater;

import com.yurentsy.swapi.gui.adapter.list.ListAdapter;
import com.yurentsy.swapi.gui.adapter.list.ListItemViewHolderFactory;
import com.yurentsy.swapi.gui.fragment.ListFragment;
import com.yurentsy.swapi.mvp.di.scope.ListScope;
import com.yurentsy.swapi.mvp.model.Model;

import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

@Module
public class ModelModule {
    private final ListFragment listFragment;

    public ModelModule(ListFragment listFragment) {
        this.listFragment = listFragment;
    }

    @ListScope
    @Provides
    ListAdapter provideListAdapter(
            ListItemViewHolderFactory factory,
            List<Model> list) {
        return new ListAdapter(factory, list);
    }

    @ListScope
    @Provides
    ListItemViewHolderFactory provideListItemViewHolderFactory(LayoutInflater layoutInflater) {
        return new ListItemViewHolderFactory(layoutInflater, listFragment);
    }

    @ListScope
    @Provides
    List<Model> provideModels() {
        return Arrays.asList(
                new Model("1", "a", android.R.color.holo_red_dark),
                new Model("2", "b", android.R.color.holo_blue_dark),
                new Model("3", "c", android.R.color.holo_green_dark),
                new Model("4", "d", android.R.color.holo_orange_dark),
                new Model("5", "e", android.R.color.holo_purple)
        );
    }
}
