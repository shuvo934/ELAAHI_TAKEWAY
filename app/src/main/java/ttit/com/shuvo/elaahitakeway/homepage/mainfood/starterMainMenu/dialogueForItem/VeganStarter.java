package ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.dialogueForItem;

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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.ApptestAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu.starteritempricetag;

public class VeganStarter extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    private RecyclerView normalFoodView;
    private AppitiserMainMenuAdapter aptMainMenuAdapter;
    private RecyclerView.LayoutManager aptLayout;

    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;

    public static ArrayList<SubCategoryItemTag> vstag;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(StarterMainMenu.starterTitle);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        vstag = new ArrayList<>();

        vstag = starteritempricetag;

        myStarteritem1 = new ArrayList<>();

//        myStarteritem1.add(new NormalFoodItem("Stir Fried Garlic Mushrooms", "","£3.00"));
//        myStarteritem1.add(new NormalFoodItem("Stirfried Chick peas and Potaoes", "","£3.00"));
//        myStarteritem1.add(new NormalFoodItem("Vegetable Biraan", "","£3.00"));
//        myStarteritem1.add(new NormalFoodItem("Spicy Stir-fried Chickpeas", "","£3.00"));
//        myStarteritem1.add(new NormalFoodItem("Tamarind Potatoes", "","£3.00"));
//        myStarteritem1.add(new NormalFoodItem("Okra & Potato Bhaji", "","£3.00"));

        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new AppitiserMainMenuAdapter(getContext(), vstag);
        normalFoodView.setAdapter(aptMainMenuAdapter);


        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starteritempricetag.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starteritempricetag.clear();
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
