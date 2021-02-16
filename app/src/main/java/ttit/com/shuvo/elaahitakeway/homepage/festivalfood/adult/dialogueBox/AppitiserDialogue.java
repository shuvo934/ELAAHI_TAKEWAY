package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.dialogueBox;


import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AppitiserAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AppitiserItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;

public class AppitiserDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> appFoodItem;

    private RecyclerView apptRecyclerView;
    private AppitiserAdapter apptAdapter;
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




        appFoodItem = new ArrayList<>();





        appFoodItem.add(new AppitiserItem("Fresh Melon Served with Cherries", "0",""));





        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new AppitiserAdapter(getContext(), appFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < appFoodItem.size(); i++) {

            for (SelectedItem item : AdultFestiveCategory.selectedItemapt) {
                if (item.getMyChosenItem().contains(appFoodItem.get(i).getMyAppitiserItem())) {
                    appFoodItem.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                AdultFestiveCategory.selectedItemapt.clear();
                for (int i = 0; i < appFoodItem.size(); i++) {
                    if (Integer.parseInt(appFoodItem.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        AdultFestiveCategory.selectedItemapt.add(new SelectedItem(appFoodItem.get(i).getMyAppitiserItem(),appFoodItem.get(i).getMyApptQuantity()));
                        Log.i("Food", appFoodItem.get(i).getMyAppitiserItem());
                        Log.i("quan", appFoodItem.get(i).getMyApptQuantity());

                    }
                }
                int count = AppitiserAdapter.ton[0];
                if (count == 0) {
                    AdultFestiveCategory.apptCount.setText(String.valueOf(count));
                    AdultFestiveCategory.apptCount.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    AdultFestiveCategory.apptCount.setText(String.valueOf(count));
                    AdultFestiveCategory.apptCount.setBackgroundResource(R.drawable.ic_circle_red);
                }

                AppitiserAdapter.ton[0] = 0;


                Log.i("sss", AdultFestiveCategory.selectedItemapt.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
