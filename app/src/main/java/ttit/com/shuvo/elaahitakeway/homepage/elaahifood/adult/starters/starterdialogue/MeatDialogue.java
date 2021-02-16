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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.SunDriesElahiAdultAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.MeatAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterElaahiAdult;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.starters.StarterItemAdapter;

public class MeatDialogue extends AppCompatDialogFragment {

    public static ArrayList<ElaahiItem> meatStarterItem;

    private RecyclerView apptRecyclerView;
    private MeatAdapter apptAdapter;
    private RecyclerView.LayoutManager apptLayout;
    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;
    public static int meatCount = 0;

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


        meatStarterItem = new ArrayList<>();

        meatStarterItem.add(new ElaahiItem("Chicken Biraan", "0",""));
        meatStarterItem.add(new ElaahiItem("Chicken Chat", "0",""));
        meatStarterItem.add(new ElaahiItem("Chicken Pakora (4)", "0",""));
        meatStarterItem.add(new ElaahiItem("Tandoori Mixed Kebab", "0","(chicken & Lamb Tikka & Seek Kebab)"));
        meatStarterItem.add(new ElaahiItem("Seek Kebab (2)", "0",""));
        meatStarterItem.add(new ElaahiItem("Mumbai Grilled Chilli Chicken  HOT", "0",""));
        meatStarterItem.add(new ElaahiItem("Meat Samosa (2)", "0",""));
        meatStarterItem.add(new ElaahiItem("Chicken tikka", "0",""));
        meatStarterItem.add(new ElaahiItem("Lamb Tikka", "0",""));
        meatStarterItem.add(new ElaahiItem("Chicken Shashlik ", "0","(Grilled with onions, tomatoes & peppers)"));
        meatStarterItem.add(new ElaahiItem("Lamb Shashlik", "0","(Grilled with onions, tomatoes & peppers)"));
        meatStarterItem.add(new ElaahiItem("Mixed Starter", "0","(Onion Bhaji, Samosa, Seek Kebab)"));
        meatStarterItem.add(new ElaahiItem("Southern Fried Chicken Mini Fillets x 4 ( New )", "0",""));
        meatStarterItem.add(new ElaahiItem("Spicy Peri Peri Chicken Mini fillets x 4 (New)", "0",""));
        meatStarterItem.add(new ElaahiItem("Loaded peri chicken & Fries ( new)", "0",""));



        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new MeatAdapter(getContext(), meatStarterItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < meatStarterItem.size(); i++) {

            for (SelectedElahiItem item : StarterElaahiAdult.selectedMeatItem) {
                if (item.getMyChosenItem().contains(meatStarterItem.get(i).getMyElaahiItem())) {
                    meatStarterItem.get(i).setMyElaahiQuantity(item.getMyChosenQuantity());
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

                StarterElaahiAdult.selectedMeatItem.clear();
                for (int i = 0; i < meatStarterItem.size(); i++) {
                    if (Integer.parseInt(meatStarterItem.get(i).getMyElaahiQuantity()) == 0) {

                    } else {
                        StarterElaahiAdult.selectedMeatItem.add(new SelectedElahiItem(meatStarterItem.get(i).getMyElaahiItem(), meatStarterItem.get(i).getMyElaahiQuantity()));
                        Log.i("Food", meatStarterItem.get(i).getMyElaahiItem());
                        Log.i("quan", meatStarterItem.get(i).getMyElaahiQuantity());

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
                 meatCount = 0;
                for (int i = 0; i< StarterElaahiAdult.selectedMeatItem.size(); i++) {
                    meatCount = meatCount + Integer.parseInt(StarterElaahiAdult.selectedMeatItem.get(i).getMyChosenQuantity());
                }
                Log.i("MEATCOUNT: ", String.valueOf(meatCount));
                StarterElaahiAdult.myStarterItems.get(0).setFoodCount(String.valueOf(meatCount));
                StarterElaahiAdult.starterAdapter.notifyDataSetChanged();
                Log.i("Adapter", StarterElaahiAdult.myStarterItems.get(0).getFoodCount().toString());


//                if (count == 0) {
//                    StarterItemAdapter.StarterItemViewHolder.starterCount.setText(String.valueOf(count));
//                    StarterItemAdapter.StarterItemViewHolder.starterCount.setBackgroundResource(R.drawable.ic_circle_gray);
//                } else {
//                    StarterItemAdapter.StarterItemViewHolder.starterCount.setText(String.valueOf(count));
//                    StarterItemAdapter.StarterItemViewHolder.starterCount.setBackgroundResource(R.drawable.ic_circle_red);
//                }


                Log.i("sss", StarterElaahiAdult.selectedMeatItem.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
