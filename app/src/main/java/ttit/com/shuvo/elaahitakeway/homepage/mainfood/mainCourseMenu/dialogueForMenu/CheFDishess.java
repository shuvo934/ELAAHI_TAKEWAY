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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;

public class CheFDishess extends AppCompatDialogFragment {
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
        titleName.setText(MainCourseMenu.mainCourseHeader);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        myStarteritem1 = new ArrayList<>();

        myStarteritem1.add(new NormalFoodItem("Garlic Chicken Tikka Massala  Medium", "Chicken Tikka cooked in garlic with a richly flavoured Massala sauce.","£6.95"));
        myStarteritem1.add(new NormalFoodItem("Garlic Lamb Tikka Massala  Medium", "Lamb Tikka cooked in garlic with a richly flavoured Massala sauce.","£6.95"));
        myStarteritem1.add(new NormalFoodItem("Chicken Tikka Chilli Massala  HOT", "Cooked with fresh green chillies, ground spices and herbs.","£6.95"));
        myStarteritem1.add(new NormalFoodItem("Lamb Tikka Chilli Massala  HOT", "Cooked with fresh green chillies, ground spices and herbs.","£6.95"));
        myStarteritem1.add(new NormalFoodItem("Bangla Lamb  Medium", "Fresh lean lamb fillets cooked with bay leaves, cinnamon and garlic using fresh onions and selected spices","£7.85"));
        myStarteritem1.add(new NormalFoodItem("Stir Fried Peri Peri Chicken Tikka New  HOT", "Chicken fillets stir fried with onions, peppers & Peri peri sauce","£6.95"));
        myStarteritem1.add(new NormalFoodItem("Lamb Nepal  SPICY", "Cooked with chunky onions and peppers in a spicy garlic and chilli Nepalese sauce.","£7.85"));
        myStarteritem1.add(new NormalFoodItem("Kashmiri Chicken  MILD", "Marinated chicken cooked in the clay oven and further cooked on a pan with chunky onions, pepper, plum tomatoes and Kashmiri spices. You can choose the strength of this dish (medium or hot) from the pop-up that appears.","£7.85"));
        myStarteritem1.add(new NormalFoodItem("Kashmiri Lamb  Medium", "Marinated chicken cooked in the clay oven and further cooked on a pan with chunky onions, pepper, plum tomatoes and Kashmiri spices. You can choose the strength of this dish (medium or hot) from the pop-up that appears.","£7.85"));


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
