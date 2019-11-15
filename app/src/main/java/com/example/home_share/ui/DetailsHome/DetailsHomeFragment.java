package com.example.home_share.ui.DetailsHome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.home_share.R;

public class DetailsHomeFragment extends Fragment {

    private DetailsHomeViewModel detailsHomeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        detailsHomeViewModel =
                ViewModelProviders.of(this).get(DetailsHomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_detailshome, container, false);
        final TextView textView = root.findViewById(R.id.text_detailsHome);
        detailsHomeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}