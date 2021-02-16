package ttit.com.shuvo.elaahitakeway.homepage.order.fragment;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import ttit.com.shuvo.elaahitakeway.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DeliveryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DeliveryFragment extends Fragment {

    public static EditText myDate;
    public static EditText myTime;
    public static EditText deliveryAddss;
    public static EditText postalC;
    public static EditText noteDeli;
    public static TextView depAmDelivery;
    private int mYear, mMonth, mDay, mHour, mMinute;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DeliveryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DeliveryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DeliveryFragment newInstance(String param1, String param2) {
        DeliveryFragment fragment = new DeliveryFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delivery, container, false);

        myDate = view.findViewById(R.id.deliveryDate);
        myTime = view.findViewById(R.id.deliveryTime);
        deliveryAddss = view.findViewById(R.id.deliveryAddress);
        postalC = view.findViewById(R.id.deliveryPostalCode);
        noteDeli = view.findViewById(R.id.editNoteDelivery);
        depAmDelivery = view.findViewById(R.id.depositAmount_delivery);

        myDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mYear = c.get(Calendar.YEAR);
                mMonth = c.get(Calendar.MONTH);
                mDay = c.get(Calendar.DAY_OF_MONTH);

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                            myDate.setText(dayOfMonth + "/" + month+1 + "/" + year);

                        }
                    }, mYear, mMonth, mDay);
                    datePickerDialog.show();
                }
            }
        });

        myTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        String AM_PM ;
                        if(hourOfDay < 12) {
                            AM_PM = "AM";
                            if (hourOfDay == 0) {
                                hourOfDay = 12;
                            }
                        } else {
                            AM_PM = "PM";
                            if (hourOfDay > 12 ) {
                                hourOfDay = hourOfDay - 12;
                            }
                        }
                        String tt = String.valueOf(minute);
                        if (tt.length() == 1) {
                            tt = "0"+tt;
                            myTime.setText(hourOfDay + ":" + tt + " " + AM_PM);
                        } else {
                            myTime.setText(hourOfDay + ":" + minute + " " + AM_PM);
                        }
                    }
                },mHour, mMinute,false);
                timePickerDialog.show();
            }
        });
        return view;
    }
}