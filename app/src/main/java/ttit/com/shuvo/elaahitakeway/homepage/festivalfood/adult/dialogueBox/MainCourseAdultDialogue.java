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
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.MainCourseAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.festivalfood.adult.SelectedItem;

public class MainCourseAdultDialogue extends AppCompatDialogFragment {

    public static ArrayList<AppitiserItem> mcFoodItem;

    private RecyclerView apptRecyclerView;
    private MainCourseAdapter apptAdapter;
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


        mcFoodItem = new ArrayList<>();


        mcFoodItem.add(new AppitiserItem("Roast Turkey", "0","Roast turkey seasoned with oregano, black pepper and sea salt. Served with chestnut stuffing, roast potatoes, honey glazed roasted carrots & parsnips, with sprouts and a rich seasoned gravy."));
        mcFoodItem.add(new AppitiserItem("Roast Lamb", "0","Lamb cooked slowly with fresh herbs and sprinkled with lemon zest. Dusted with fresh garlic and served with traditional seasonal roast vegetables."));
        mcFoodItem.add(new AppitiserItem("Vegetable Roast VE", "0","Vegetable Nut roast served with seasonal roast vegetables as above served with vegan rich bistro gravy."));
        mcFoodItem.add(new AppitiserItem("Seabass", "0","Grilled fillets served with traditional seasonal roasted vegetables"));
        mcFoodItem.add(new AppitiserItem("Salmon", "0","Grilled fillets served with traditional seasonal roasted vegetables"));


        apptRecyclerView = view.findViewById(R.id.appitiser_list_view);
        apptRecyclerView.setHasFixedSize(true);
        apptLayout = new LinearLayoutManager(getContext());
        apptRecyclerView.setLayoutManager(apptLayout);

        apptAdapter = new MainCourseAdapter(getContext(), mcFoodItem);
        apptRecyclerView.setAdapter(apptAdapter);

        for (int i = 0; i < mcFoodItem.size(); i++) {

            for (SelectedItem item : AdultFestiveCategory.selectedItemMC) {
                if (item.getMyChosenItem().contains(mcFoodItem.get(i).getMyAppitiserItem())) {
                    mcFoodItem.get(i).setMyApptQuantity(item.getMyChosenQuantity());
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

                AdultFestiveCategory.selectedItemMC.clear();
                for (int i = 0; i < mcFoodItem.size(); i++) {
                    if (Integer.parseInt(mcFoodItem.get(i).getMyApptQuantity()) == 0) {

                    } else {
                        AdultFestiveCategory.selectedItemMC.add(new SelectedItem(mcFoodItem.get(i).getMyAppitiserItem(), mcFoodItem.get(i).getMyApptQuantity()));
                        Log.i("Food", mcFoodItem.get(i).getMyAppitiserItem());
                        Log.i("quan", mcFoodItem.get(i).getMyApptQuantity());

                    }
                }
                int count = MainCourseAdapter.ton[0];
                if (count == 0) {
                    AdultFestiveCategory.mcCount.setText(String.valueOf(count));
                    AdultFestiveCategory.mcCount.setBackgroundResource(R.drawable.ic_circle_gray);
                } else {
                    AdultFestiveCategory.mcCount.setText(String.valueOf(count));
                    AdultFestiveCategory.mcCount.setBackgroundResource(R.drawable.ic_circle_red);
                }

                MainCourseAdapter.ton[0] = 0;


                Log.i("sss", AdultFestiveCategory.selectedItemMC.toString());
                dialog.dismiss();
            }
        });


        return dialog;
    }
}
