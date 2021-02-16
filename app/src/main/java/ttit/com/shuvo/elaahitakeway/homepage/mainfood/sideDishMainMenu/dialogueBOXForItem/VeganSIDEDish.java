package ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.dialogueBOXForItem;

import android.app.Dialog;
import android.os.Bundle;
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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.AppitiserMainMenuAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenu;

public class VeganSIDEDish extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    private RecyclerView normalFoodView;
    private AppitiserMainMenuAdapter aptMainMenuAdapter;
    private RecyclerView.LayoutManager aptLayout;

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
        titleName.setText(SideDishMainMenu.starterTitle);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        myStarteritem1 = new ArrayList<>();

        myStarteritem1.add(new NormalFoodItem("Saag Bhaji", "","£2.90"));
        myStarteritem1.add(new NormalFoodItem("Mixed Veg Bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Chickpeas & Potato Bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Bombay Potato", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Saag Aloo ( spinich & potatoes)", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Tarka Dhal ( lentils)", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Spicy Stir Fried Chick Peas", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Garlic Mushroom Bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Tamarind Potatoes", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Okra & Potato Bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Okra Bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Potatoes & Cauliflower bhaji", "","£2.95"));
        myStarteritem1.add(new NormalFoodItem("Bhindy Baji", "","£2.95"));


        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new AppitiserMainMenuAdapter(getContext(), myStarteritem1);
        normalFoodView.setAdapter(aptMainMenuAdapter);


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
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
