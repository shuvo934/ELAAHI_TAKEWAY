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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.DesertAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;

public class DessertAdultDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> desertFoodItem;

    private RecyclerView apptRecyclerView;
    private DesertAdapter apptAdapter;
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




        desertFoodItem = new ArrayList<>();





        desertFoodItem.add(new AppitiserItem("Christmas Pudding", "0","With cream"));
        desertFoodItem.add(new AppitiserItem("Chocolate Fudge Cake", "0","With cream"));
        desertFoodItem.add(new AppitiserItem("Vanilla Cheese Cake", "0","Drizzled with coulis"));
        desertFoodItem.add(new AppitiserItem("Chocolate & Raspberry Torte VE", "0",""));
        desertFoodItem.add(new AppitiserItem("Gulab Jaman & Ice Cream", "0",""));





        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new DesertAdapter(getContext(), desertFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < desertFoodItem.size(); i++) {

            for (SelectedItem item : AdultFestiveCategory.selectedItemDesert) {
                if (item.getMyChosenItem().contains(desertFoodItem.get(i).getMyAppitiserItem())) {
                    desertFoodItem.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                AdultFestiveCategory.selectedItemDesert.clear();
                for (int i = 0; i < desertFoodItem.size(); i++) {
                    if (Integer.parseInt(desertFoodItem.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        AdultFestiveCategory.selectedItemDesert.add(new SelectedItem(desertFoodItem.get(i).getMyAppitiserItem(), desertFoodItem.get(i).getMyApptQuantity()));
                        Log.i("Food", desertFoodItem.get(i).getMyAppitiserItem());
                        Log.i("quan", desertFoodItem.get(i).getMyApptQuantity());

                    }
                }
                int count = DesertAdapter.ton[0];
                if (count == 0) {
                    AdultFestiveCategory.desCount.setText(String.valueOf(count));
                    AdultFestiveCategory.desCount.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultFestiveCategory.desCount.setText(String.valueOf(count));
                    AdultFestiveCategory.desCount.setBackgroundResource(R.drawable.ic_circle_red);
                }

                DesertAdapter.ton[0] = 0;

                Log.i("sss", AdultFestiveCategory.selectedItemDesert.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
