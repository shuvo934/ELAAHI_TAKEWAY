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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.ApptestAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.sideDishMainMenu.SideDishMainMenu.sideItemtag;

public class ClassicDish extends AppCompatDialogFragment {
    public static ArrayList<NormalFoodItem> myStarteritem1;

    public static ArrayList<SubCategoryItemTag> side1item;

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

        side1item = new ArrayList<>();

        side1item = sideItemtag;

        myStarteritem1 = new ArrayList<>();

//        myStarteritem1.add(new NormalFoodItem("Saag Paneer", "","£2.90"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Balti Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Pathia Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Passanda Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Shaheen Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Korma Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Mossala Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Dupiaza Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Dansak Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Bhuna Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Rogan Josh Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Samber Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Madras Sauce", "","£2.95"));
//        myStarteritem1.add(new NormalFoodItem("Portion of Vindaloo Sauce", "","£2.95"));


        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new AppitiserMainMenuAdapter(getContext(), side1item);
        normalFoodView.setAdapter(aptMainMenuAdapter);


        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sideItemtag.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sideItemtag.clear();
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
