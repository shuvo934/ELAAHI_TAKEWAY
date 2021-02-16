package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.starterdialogue;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.MeatAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.SeaFoodAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterElaahiAdult;

public class SeaFoodDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> seaFoodStarterItem;

    private RecyclerView apptRecyclerView;
    private SeaFoodAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;
    public static int seaFoodCount = 0;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(StarterElaahiAdult.starterTitle);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);


        seaFoodStarterItem = new ArrayList<>();

        seaFoodStarterItem.add(new ElaahiItem("King Prawn Puri", "0","(Mild) (No shells)"));
        seaFoodStarterItem.add(new ElaahiItem("Veg Samosa (2)", "0","(Mild) (No shells)"));
        seaFoodStarterItem.add(new ElaahiItem("Stir fried Tiger king prawns New  Medium", "0","(No shells) Succelent tiger king prawns stir fried with onion, tomatoe & peppers"));
        seaFoodStarterItem.add(new ElaahiItem("Peri Peri Tiger King Prawns New  HOT", "0","(No shells) Succulent fresh Tiger king prawns cooked with onions & peri peri sauce."));
        seaFoodStarterItem.add(new ElaahiItem("Pan fried Seabass  MILD", "0",""));
        seaFoodStarterItem.add(new ElaahiItem("Pan fried Salmon  MILD", "0",""));
        seaFoodStarterItem.add(new ElaahiItem("Mossalla grilled Fish Fillet New  SPICY", "0",""));


        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new SeaFoodAdapter(getContext(), seaFoodStarterItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < seaFoodStarterItem.size(); i++) {

            for (SelectedElahiItem item : StarterElaahiAdult.selectedSeaFoodItem) {
                if (item.getMyChosenItem().contains(seaFoodStarterItem.get(i).getMyElaahiItem())) {
                    seaFoodStarterItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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

                StarterElaahiAdult.selectedSeaFoodItem.clear();
                for (int i = 0; i < seaFoodStarterItem.size(); i++) {
                    if (Integer.parseInt(seaFoodStarterItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        StarterElaahiAdult.selectedSeaFoodItem.add(new SelectedElahiItem(seaFoodStarterItem.get(i).getMyElaahiItem(), seaFoodStarterItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", seaFoodStarterItem.get(i).getMyElaahiItem());
                        Log.i("quan", seaFoodStarterItem.get(i).getMyElaahiQuantity());

                    }
                }
//                int count = MeatAdapter.ton[0];
//                if (count == 0) {
//                    AdultElaahi.startCountadultElhi.setText(String.valueOf(count));
//                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_gray);
//                }else {
//                    AdultElaahi.startCountadultElhi.setText(String.valueOf(count));
//                    AdultElaahi.startCountadultElhi.setBackgroundResource(R.drawable.ic_circle_red);
//                }
//
//                MeatAdapter.ton[0] = 0;

                seaFoodCount = 0;
                for (int i = 0; i< StarterElaahiAdult.selectedSeaFoodItem.size(); i++) {
                    seaFoodCount = seaFoodCount + Integer.parseInt(StarterElaahiAdult.selectedSeaFoodItem.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(seaFoodCount));
                StarterElaahiAdult.myStarterItems.get(2).setFoodCount(String.valueOf(seaFoodCount));
                StarterElaahiAdult.starterAdapter.notifyDataSetChanged();
                Log.i("Adapter", StarterElaahiAdult.myStarterItems.get(2).getFoodCount().toString());


                Log.i("sss", StarterElaahiAdult.selectedSeaFoodItem.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
