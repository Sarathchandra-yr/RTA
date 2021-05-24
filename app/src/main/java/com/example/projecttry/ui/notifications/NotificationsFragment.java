package com.example.projecttry.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projecttry.MainActivity;
import com.example.projecttry.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private NotificationsViewModel notificationsViewModel;
    ListView lv;
    String item[]= {"Profile","Logout"};
    public View onCreateView(@NonNull LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        lv = (ListView) root.findViewById(R.id.lv);
        List<String> items = new ArrayList<>(Arrays.asList(item));
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1, items);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (i==1) {
                    Toast.makeText(getContext(), "Loged out", Toast.LENGTH_SHORT).show();
                    Intent p =new Intent(view.getContext(), MainActivity.class);
                    startActivity(p);
                }
            }
        });



        return root;
    }
}