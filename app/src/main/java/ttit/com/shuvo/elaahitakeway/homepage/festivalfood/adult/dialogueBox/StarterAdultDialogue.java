package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox;


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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AdultFestiveCategory;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AppitiserItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.StarterAdapter;

public class StarterAdultDialogue  extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> starterFoodItem;

    private RecyclerView apptRecyclerView;
    private StarterAdapter apptAdapter;
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
        titleName.setText(AdultFestiveCategory.titleName);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);




        starterFoodItem = new ArrayList<>();





        starterFoodItem.add(new AppitiserItem("Carrot & Coriander Soup VE", "0",""));
        starterFoodItem.add(new AppitiserItem("Stir Fried Garlic Mushrooms VE", "0",""));
        starterFoodItem.add(new AppitiserItem("Grilled Sea Bass", "0",""));
        starterFoodItem.add(new AppitiserItem("Grilled Salmon", "0",""));
        starterFoodItem.add(new AppitiserItem("Prawn Cocktail", "0",""));
        starterFoodItem.add(new AppitiserItem("Grilled Chicken Breast", "0",""));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new StarterAdapter(getContext(), starterFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < starterFoodItem.size(); i++) {

            for (SelectedItem item : AdultFestiveCategory.selectedItemStarter) {
                if (item.getMyChosenItem().contains(starterFoodItem.get(i).getMyAppitiserItem())) {
                    starterFoodItem.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                AdultFestiveCategory.selectedItemStarter.clear();
                for (int i = 0; i < starterFoodItem.size(); i++) {
                    if (Integer.parseInt(starterFoodItem.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        AdultFestiveCategory.selectedItemStarter.add(new SelectedItem(starterFoodItem.get(i).getMyAppitiserItem(),starterFoodItem.get(i).getMyApptQuantity()));
                        Log.i("Food", starterFoodItem.get(i).getMyAppitiserItem());
                        Log.i("quan", starterFoodItem.get(i).getMyApptQuantity());

                    }
                }
                int count = StarterAdapter.ton[0];
                if (count == 0) {
                    AdultFestiveCategory.startCount.setText(String.valueOf(count));
                    AdultFestiveCategory.startCount.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultFestiveCategory.startCount.setText(String.valueOf(count));
                    AdultFestiveCategory.startCount.setBackgroundResource(R.drawable.ic_circle_red);
                }

                StarterAdapter.ton[0] = 0;


                Log.i("sss", AdultFestiveCategory.selectedItemStarter.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }

}
