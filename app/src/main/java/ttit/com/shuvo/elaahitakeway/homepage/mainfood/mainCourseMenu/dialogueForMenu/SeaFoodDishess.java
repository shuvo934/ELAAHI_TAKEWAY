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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.ElaahiItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.SauceDialogueforMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.FlavorAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.SeaFoodAnotherAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu.mainFoodTag;

public class SeaFoodDishess extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    public static ArrayList<SubCategoryItemTag> seaFoodtag;

    private RecyclerView normalFoodView;
    private SeaFoodAnotherAdapter aptMainMenuAdapter;
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
        titleName.setText(MainCourseMenu.mainCourseHeader);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        myStarteritem1 = new ArrayList<>();

        seaFoodtag = new ArrayList<>();

        seaFoodtag = mainFoodTag;

//        myStarteritem1.add(new NormalFoodItem("Garlic Chilli Fish New  HOT", "fresh fish fillet cooked with blended spices,onions, peppers, ginger, garlic and chillies. Served with a choice of curry sauce","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Salmon Tikka Mossala New  MILD", "Grilled Salmon fillets cooked in a mild creamy mossalla sauce","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("King prawn Delight (No Shells) New  Medium", "Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices.","£8.95"));
//        myStarteritem1.add(new NormalFoodItem("Bengal Fish Karahi (New)  HOT", "Fresh fish fillets cooked with onions, tomatoes and blend of Bengali spices.","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Grilled Peri Peri Tiger King Prawns  Medium", "Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Grilled Peri Peri Tiger King Prawns  HOT", "Grilled Tiger King Prawns stir fried in exotic mix of spices with spring onions, capsicum, fresh garlic, ginger and peri peri sauce. Served on a bed of seasonal vegetables and with a choice of curry sauce","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Grilled Fish Fillets  MILD", "Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled.","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Grilled Fish Fillets  Medium", "Fresh Fish Fillets marinated in a lightly spiced sauce and gently grilled","£7.60"));
//        myStarteritem1.add(new NormalFoodItem("Pan Fried Sea Bass Biraan  MILD", "Sea Bass grilled with selected spices. Served with a choice of curry sauce.","£7.60"));



        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new SeaFoodAnotherAdapter(getContext(), seaFoodtag);
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
