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

import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.ChildFestiveCategory;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.child.StarterChildAdapter;

public class StarterChildDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> starterFoodChild;

    private RecyclerView apptRecyclerView;
    private StarterChildAdapter apptAdapter;
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




        starterFoodChild = new ArrayList<>();

        starterFoodChild.add(new AppitiserItem("Carrot & Coriander Soup VE", "0",""));
        starterFoodChild.add(new AppitiserItem("Stir Fried Garlic Mushrooms VE", "0",""));
        starterFoodChild.add(new AppitiserItem("Grilled Sea Bass", "0",""));
        starterFoodChild.add(new AppitiserItem("Grilled Salmon", "0",""));
        starterFoodChild.add(new AppitiserItem("Prawn Cocktail", "0",""));
        starterFoodChild.add(new AppitiserItem("Grilled Chicken Breast", "0",""));




        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new StarterChildAdapter(getContext(), starterFoodChild);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < starterFoodChild.size(); i++) {

            for (SelectedItem item : ChildFestiveCategory.selectedItemStarterChild) {
                if (item.getMyChosenItem().contains(starterFoodChild.get(i).getMyAppitiserItem())) {
                    starterFoodChild.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                ChildFestiveCategory.selectedItemStarterChild.clear();
                for (int i = 0; i < starterFoodChild.size(); i++) {
                    if (Integer.parseInt(starterFoodChild.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        ChildFestiveCategory.selectedItemStarterChild.add(new SelectedItem(starterFoodChild.get(i).getMyAppitiserItem(), starterFoodChild.get(i).getMyApptQuantity()));
                        Log.i("Food", starterFoodChild.get(i).getMyAppitiserItem());
                        Log.i("quan", starterFoodChild.get(i).getMyApptQuantity());

                    }
                }
                int count = StarterChildAdapter.ton[0];
                if (count == 0) {
                    ChildFestiveCategory.startCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.startCountChild.setBackgroundResource(R.drawable.ic_circle_gray);
                }else {
                    ChildFestiveCategory.startCountChild.setText(String.valueOf(count));
                    ChildFestiveCategory.startCountChild.setBackgroundResource(R.drawable.ic_circle_red);
                }

                StarterChildAdapter.ton[0] = 0;


                Log.i("sss", ChildFestiveCategory.selectedItemStarterChild.toString());
                dialog.dismiss();
            }
        });





        return dialog;
    }
}
