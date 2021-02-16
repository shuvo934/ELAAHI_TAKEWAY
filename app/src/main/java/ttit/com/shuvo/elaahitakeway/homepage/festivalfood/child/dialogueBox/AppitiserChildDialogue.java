package ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.dialogueBox;

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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.AppitiserItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.AppitiserChildAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.ChildFestiveCategory;

public class AppitiserChildDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> appFoodItemChild;

    private RecyclerView apptRecyclerView;
    private AppitiserChildAdapter apptAdapter;
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
        titleName.setText(ChildFestiveCategory.titleNameChild);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);




        appFoodItemChild = new ArrayList<>();





        appFoodItemChild.add(new AppitiserItem("Fresh Melon Served with Cherries", "0",""));





        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new AppitiserChildAdapter(getContext(), appFoodItemChild);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < appFoodItemChild.size(); i++) {

            for (SelectedItem item : ChildFestiveCategory.selectedItemaptChild) {
                if (item.getMyChosenItem().contains(appFoodItemChild.get(i).getMyAppitiserItem())) {
                    appFoodItemChild.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                ChildFestiveCategory.selectedItemaptChild.clear();
                for (int i = 0; i < appFoodItemChild.size(); i++) {
                    if (Integer.parseInt(appFoodItemChild.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        ChildFestiveCategory.selectedItemaptChild.add(new SelectedItem(appFoodItemChild.get(i).getMyAppitiserItem(), appFoodItemChild.get(i).getMyApptQuantity()));
                        Log.i("Food", appFoodItemChild.get(i).getMyAppitiserItem());
                        Log.i("quan", appFoodItemChild.get(i).getMyApptQuantity());

                    }
                }
                int count = AppitiserChildAdapter.ton[0];
                if (count == 0) {
                    ChildFestiveCategory.apptCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.apptCountChild.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    ChildFestiveCategory.apptCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.apptCountChild.setBackgroundResource(R.drawable.ic_circle_red);
                }

                AppitiserChildAdapter.ton[0] = 0;


                Log.i("sss", ChildFestiveCategory.selectedItemaptChild.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
    
}
