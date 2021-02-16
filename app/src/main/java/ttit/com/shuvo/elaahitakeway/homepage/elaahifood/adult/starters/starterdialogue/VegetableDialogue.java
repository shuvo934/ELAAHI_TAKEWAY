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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.VegetableAdapter;

public class VegetableDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> vegetableStarterItem;

    private RecyclerView apptRecyclerView;
    private VegetableAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;
    public static int vegetableCount = 0;

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


        vegetableStarterItem = new ArrayList<>();

        vegetableStarterItem.add(new ElaahiItem("Onion Bhaji (4)", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Veg Samosa (2)", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Stir Fried Paneer New  Medium", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Stir Fried Garlic Mushrooms", "0","(chicken & Lamb Tikka & Seek Kebab)"));
        vegetableStarterItem.add(new ElaahiItem("Stirfried Chick peas and Potaoes", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Vegetable Biraan", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Spicy Stir-fried Chickpeas", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Tamarind Potatoes", "0",""));
        vegetableStarterItem.add(new ElaahiItem("Okra & Potato Bhaji", "0",""));


        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new VegetableAdapter(getContext(), vegetableStarterItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < vegetableStarterItem.size(); i++) {

            for (SelectedElahiItem item : StarterElaahiAdult.selectedVegetableItem) {
                if (item.getMyChosenItem().contains(vegetableStarterItem.get(i).getMyElaahiItem())) {
                    vegetableStarterItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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

                StarterElaahiAdult.selectedVegetableItem.clear();
                for (int i = 0; i < vegetableStarterItem.size(); i++) {
                    if (Integer.parseInt(vegetableStarterItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        StarterElaahiAdult.selectedVegetableItem.add(new SelectedElahiItem(vegetableStarterItem.get(i).getMyElaahiItem(), vegetableStarterItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", vegetableStarterItem.get(i).getMyElaahiItem());
                        Log.i("quan", vegetableStarterItem.get(i).getMyElaahiQuantity());

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

                vegetableCount = 0;
                for (int i = 0; i< StarterElaahiAdult.selectedVegetableItem.size(); i++) {
                    vegetableCount = vegetableCount + Integer.parseInt(StarterElaahiAdult.selectedVegetableItem.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(vegetableCount));
                StarterElaahiAdult.myStarterItems.get(1).setFoodCount(String.valueOf(vegetableCount));
                StarterElaahiAdult.starterAdapter.notifyDataSetChanged();
                Log.i("Adapter", StarterElaahiAdult.myStarterItems.get(1).getFoodCount().toString());


                Log.i("sss", StarterElaahiAdult.selectedVegetableItem.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
