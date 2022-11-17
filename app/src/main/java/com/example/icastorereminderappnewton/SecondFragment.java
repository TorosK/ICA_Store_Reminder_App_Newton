package com.example.icastorereminderappnewton;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.icastorereminderappnewton.databinding.FragmentSecondBinding;
import com.google.android.material.textfield.TextInputEditText;

import java.sql.SQLOutput;
import java.util.Calendar;

public class SecondFragment extends Fragment {

    // For creating new Reminder objects
    public class Reminder {
        String title = "";
        String date;
        String time;
        String where = "";
        String description = "";

        public Reminder(String title, String date, String time, String where, String description) {
            this.title = title;
            this.date = date;
            this.time = time;
            this.where = where;
            this.description = description;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        public String getWhere() {
            return where;
        }

        public void setWhere(String where) {
            this.where = where;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Reminder{" +
                    "title='" + title + '\'' +
                    ", date=" + date +
                    ", time=" + time +
                    ", where='" + where + '\'' +
                    ", description='" + description + '\'' +
                    '}';
        }
    }

    TextInputEditText inputTitle;
    TextInputEditText inputDate;
    TextInputEditText inputTime;
    TextInputEditText inputWhere;
    TextInputEditText inputDescription;

    Button button_Add_Reminder;
    // End

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // For input of New Reminder
        inputTitle = (TextInputEditText) view.findViewById(R.id.input_Title);
        inputDate = (TextInputEditText) view.findViewById(R.id.input_Date);
        inputTime = (TextInputEditText) view.findViewById(R.id.input_Time);
        inputWhere = (TextInputEditText) view.findViewById(R.id.input_Where);
        inputDescription = (TextInputEditText) view.findViewById(R.id.input_Description);

        button_Add_Reminder = (Button) view.findViewById(R.id.buttonAddReminder);
        button_Add_Reminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Describe what will happen when user clicks submit new reminder button
                Reminder reminder = new Reminder(
                        inputTitle.getText().toString(),
                        inputDate.getText().toString(),
                        inputTime.getText().toString(),
                        inputWhere.getText().toString(),
                        inputDescription.getText().toString());

                Toast.makeText(getActivity().getApplicationContext(),
                        inputTitle + " \n" +
                                inputDate + " \n" +
                                inputTime + " \n" +
                                inputWhere + " \n" +
                                inputDescription
                        , Toast.LENGTH_LONG).show();
                System.out.println(reminder);
            }

        });
        // end

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}