package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.dialogueForMenu;

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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.SauceDialogueforMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MCItemAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu.mainFoodTag;

public class Tandoori extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    private RecyclerView normalFoodView;
    private MCItemAdapter aptMainMenuAdapter;
    private RecyclerView.LayoutManager aptLayout;

    private TextView titleName;
    public ImageView cancel;
    public Button okBtn;

    public static ArrayList<SubCategoryItemTag> tandooritag;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();

        View view = inflater.inflate(R.layout.appitiser_dialogue, null);

        titleName = view.findViewById(R.id.selected_ID);
        titleName.setText(MainCourseMenu.mainCourseHeader);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        tandooritag = new ArrayList<>();

        tandooritag = mainFoodTag;

        myStarteritem1 = new ArrayList<>();

//        myStarteritem1.add(new NormalFoodItem("Tandoori Chicken", "","£6.30"));
//        myStarteritem1.add(new NormalFoodItem("Lamb Tikka", "","£6.60"));
//        myStarteritem1.add(new NormalFoodItem("Tandoori Mix Grill", "","£7.95"));
//        myStarteritem1.add(new NormalFoodItem("Tandoori Mixed Kebab", "Tandoori chicken, chicken tikka, lamb tikka, onion and garlic seek kebab","£3.95"));
//        myStarteritem1.add(new NormalFoodItem("Chicken tikka", "Grilled with onions, tomatoes & peppers.","£6.95"));
//        myStarteritem1.add(new NormalFoodItem("Lamb Tikka Shashlik", "Grilled with onions, tomatoes & peppers.","£6.95"));
//        myStarteritem1.add(new NormalFoodItem("Tandoori Mix Shashlik", "Grilled with onions, tomatoes & peppers.","£7.95"));
//        myStarteritem1.add(new NormalFoodItem("Chicken Biraan  Medium", "Chicken breast fillet cooked with fried onions and selected spices.","£6.95"));
//        myStarteritem1.add(new NormalFoodItem("Mumbai Grilled Chilli Chicken  HOT", "Fresh chicken fillets marinated and grilled. Served with stir fried onions and crushed chillies.","£7.10"));
//        myStarteritem1.add(new NormalFoodItem("Stir Fried Peri Peri Chicken or Lamb Tikka  HOT", "Chicken or lamb stir fried with onions and peppers","£7.10"));
//        myStarteritem1.add(new NormalFoodItem("Tandoori King Prawns", "","£8.95"));
//        myStarteritem1.add(new NormalFoodItem("Tandoori King Prawn Shashlick", "Grilled with onions, tomatoes & peppers.","£9.95"));

        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new MCItemAdapter(getContext(), tandooritag);
        normalFoodView.setAdapter(aptMainMenuAdapter);


        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFoodTag.clear();
                dialog.dismiss();
            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainFoodTag.clear();
                dialog.dismiss();
            }
        });

        return dialog;
    }
}
