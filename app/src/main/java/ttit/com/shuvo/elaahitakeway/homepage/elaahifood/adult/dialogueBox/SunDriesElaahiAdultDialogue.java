package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.dialogueBox;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.AdultElaahi;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SelectedElahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SunDriesElahiAdultAdapter;

public class SunDriesElaahiAdultDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> sunDriesItem;

    private RecyclerView apptRecyclerView;
    private SunDriesElahiAdultAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(AdultElaahi.titleNameadultElhi);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);


        sunDriesItem = new ArrayList<>();

        sunDriesItem.add(new ElaahiItem("Plain Nan", "0",""));
        sunDriesItem.add(new ElaahiItem("Keema Nan", "0",""));
        sunDriesItem.add(new ElaahiItem("Garlic Nan", "0",""));
        sunDriesItem.add(new ElaahiItem("Coriander Nan", "0",""));
        sunDriesItem.add(new ElaahiItem("Cheese Naan", "0",""));
        sunDriesItem.add(new ElaahiItem("Peshwari Nan", "0",""));
        sunDriesItem.add(new ElaahiItem("Chunky Chips", "0",""));
        sunDriesItem.add(new ElaahiItem("Spicy Peri Peri Fries (New)", "0",""));
        sunDriesItem.add(new ElaahiItem("Chapatti", "0",""));
        sunDriesItem.add(new ElaahiItem("Boiled Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Pilau Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Egg Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Mushroom Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Vegetable Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Chana Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Sweet Coconut Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Lemon Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Keema Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Onion Rice", "0",""));
        sunDriesItem.add(new ElaahiItem("Garlic Rice", "0",""));



        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new SunDriesElahiAdultAdapter(getContext(), sunDriesItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < sunDriesItem.size(); i++) {

            for (SelectedElahiItem item : AdultElaahi.selectedItemSunDriesadultElhi) {
                if (item.getMyChosenItem().contains(sunDriesItem.get(i).getMyElaahiItem())) {
                    sunDriesItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
                }
            }

        }


        builder.setView(view);

        AlertDialog dialog = builder.create();


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AdultElaahi.selectedItemSunDriesadultElhi.clear();
                for (int i = 0; i < sunDriesItem.size(); i++) {
                    if (Integer.parseInt(sunDriesItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        AdultElaahi.selectedItemSunDriesadultElhi.add(new SelectedElahiItem(sunDriesItem.get(i).getMyElaahiItem(), sunDriesItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", sunDriesItem.get(i).getMyElaahiItem());
                        Log.i("quan", sunDriesItem.get(i).getMyElaahiQuantity());

                    }
                }
                int count = SunDriesElahiAdultAdapter.ton[0];
                if (count == 0) {
                    AdultElaahi.sunCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.sunCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultElaahi.sunCountadultElhi.setText(String.valueOf(count));
                    AdultElaahi.sunCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
                }

                SunDriesElahiAdultAdapter.ton[0] = 0;


                Log.i("sss", AdultElaahi.selectedItemSunDriesadultElhi.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
