package com.mblhcmute.fragmentcommunicationapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mblhcmute.fragmentcommunicationapp.databinding.Fragment1Binding;
import com.mblhcmute.fragmentcommunicationapp.databinding.Fragment2Binding;


public class Fragment2 extends Fragment {

    private Fragment2Binding binding;
    ItemViewModel viewModel;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = Fragment2Binding.inflate(inflater, container, false);

        /*getParentFragmentManager().setFragmentResultListener("dataForm1",this,new FragmentResultListener() {

            @Override
            public void onFragmentResult(@NonNull String requestKey,@NonNull Bundle result) {
                String data = result.getString("df1");
                TextView textView = binding.dataForm1;
                textView.setText(data);
            }
        });

        binding.sendData1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = binding.fragment1Data;
                Bundle result = new Bundle();
                result.putString("df2",editText.getText().toString());
                getParentFragmentManager().setFragmentResult("dataForm2",result);
                editText.setText("");
            }
        });*/

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(ItemViewModel.class);

        binding.sendData1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = binding.fragment2Data;
                viewModel.setData(editText.getText().toString());
            }
        });
    }
}