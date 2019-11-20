package com.example.home_share.fragments.DetailsHome;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class DetailsHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public DetailsHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Détail du logement choisi");
    }

    public LiveData<String> getText() {
        return mText;
    }
}