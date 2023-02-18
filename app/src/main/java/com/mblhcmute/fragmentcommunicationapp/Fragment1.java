package com.mblhcmute.fragmentcommunicationapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.mblhcmute.fragmentcommunicationapp.databinding.Fragment1Binding;


public class Fragment1 extends Fragment {

    private Fragment1Binding binding;
    ItemViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment1Binding.inflate(inflater, container, false);

        /*getParentFragmentManager().setFragmentResultListener("dataForm2",this,new FragmentResultListener() {

            @Override
            public void onFragmentResult(@NonNull String requestKey,@NonNull Bundle result) {
                String data = result.getString("df2");
                TextView textView = binding.dataForm2;
                textView.setText(data);
            }
        });

        binding.sendData2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = binding.fragment1Data;
                Bundle result = new Bundle();
                result.putString("df1",editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataForm1",result);
                editText.setText("");
            }
        });*/

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        binding.sendData2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = binding.fragment1Data;
                viewModel.setData(editText.getText().toString());
            }
        });
    }
}