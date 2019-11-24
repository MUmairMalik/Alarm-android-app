package com.example.assignment4;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;


import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;

public class DialogActivity extends DialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.message,container,false);

       /* Button bCancelAction = view.findViewById(R.id.button_dismiss);

        bCancelAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                getDialog().dismiss();


            }
        });
*/


        return view;
    }

    void alertScreen()
    {
        this.show(getFragmentManager(), "PopUp");
    }
}
