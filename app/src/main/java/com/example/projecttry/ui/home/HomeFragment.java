package com.example.projecttry.ui.home;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.projecttry.R;
import com.example.projecttry.sea;

import java.util.Calendar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ImageView ic;
    String place,d;
    EditText date,editText;
    Button b;


    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {

//        homeViewModel =
//                new ViewModelProvider(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        ic = (ImageView) root.findViewById(R.id.ic);
        date = (EditText) root.findViewById(R.id.date);
        editText = (EditText) root.findViewById(R.id.editTextTextPersonName5);
        b = (Button) root.findViewById(R.id.button3);
        ic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                // date picker dialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {
                        // set day of month , month and year value in the edit text
                        date.setText(dayOfMonth + "/"
                                + (monthOfYear + 1) + "/" + year);

                    }
                }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place = editText.getText().toString();
                d = date.getText().toString();
                if (place.isEmpty() || d.isEmpty()) {

                    Toast.makeText(getContext(), "Empty not allowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i = new Intent(view.getContext(), sea.class);
                    i.putExtra("place",place);
                    i.putExtra("date",d);
                    startActivity(i);
                }
            }
        });



//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        return root;
    }


    }