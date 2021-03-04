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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.FlavorAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MeatSelectionAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu.mainFoodTag;

public class ClassicDishes extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    public static ArrayList<SubCategoryItemTag> classtag;

    private RecyclerView normalFoodView;
    private MeatSelectionAdapter aptMainMenuAdapter;
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

        classtag = new ArrayList<>();

        myStarteritem1 = new ArrayList<>();

        classtag = mainFoodTag;

//        myStarteritem1.add(new NormalFoodItem("Balti Dishes  Medium", "These dishes are cooked with onions, tomatoes and selected spices",""));
//        myStarteritem1.add(new NormalFoodItem("Pathia Dishes  HOT", "Sweet, sour and hot dish cooked with onions and tomatoes.",""));
//        myStarteritem1.add(new NormalFoodItem("Karahi Dishes  SPICY", "Cooked with chunky onions and peppers in a spicy garlic and ginger sauce.",""));
//        myStarteritem1.add(new NormalFoodItem("Korma Dishes  MILD", "A mild creamy dish cooked with almonds and coconut.",""));
//        myStarteritem1.add(new NormalFoodItem("Dansak Dishes  Medium", "A sweet and sour medium curry dish consisting of lentils, coriander & pineapples.",""));
//        myStarteritem1.add(new NormalFoodItem("Bhuna Dishes  Medium", "A medium curry dish cooked with onions and tomatoes.",""));
//        myStarteritem1.add(new NormalFoodItem("Rogan Josh Dishes  SPICY", "Tomato based dish cooked in a spicy sauce of onions and peppers.",""));
//        myStarteritem1.add(new NormalFoodItem("Garlic Bhuna Dishes  Medium", "Cooked with fresh garlic in a onion and tomato sauce.",""));
//        myStarteritem1.add(new NormalFoodItem("South Indian Dishes  HOT", "Cooked in a garlic and plum tomato sauce with roasted green chillies.",""));
//        myStarteritem1.add(new NormalFoodItem("Vindaloo Dishes  HOT", "A dish having a greater proportion of hotness and those spices which lend a fiery taste to its richness",""));
//        myStarteritem1.add(new NormalFoodItem("Passanda Dishes", "Cooked in a mild creamy sauce with yogurt, coriander and mixed spices.",""));
//        myStarteritem1.add(new NormalFoodItem("Makahni Dishes", "Cooked with mixed nuts and cheese.",""));


        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new MeatSelectionAdapter(getContext(), classtag);
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
