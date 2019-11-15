package com.example.home_share.ui.listResult;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListResultViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListResultViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Résultat de votre recherche");
    }

    public LiveData<String> getText() {
        return mText;
    }
}