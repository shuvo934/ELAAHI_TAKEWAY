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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.appitiser.ApptestAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu.mainFoodTag;

public class BiriyaniDishes extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    public static ArrayList<SubCategoryItemTag> biriryanTag;

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

        biriryanTag = new ArrayList<>();

        biriryanTag = mainFoodTag;

//        myStarteritem1.add(new NormalFoodItem("Meat", "","£6.30"));
//        myStarteritem1.add(new NormalFoodItem("Chicken", "","£6.30"));
//        myStarteritem1.add(new NormalFoodItem("Chicken Tikka", "","£6.30"));
//        myStarteritem1.add(new NormalFoodItem("Lamb Tikka", "","£7.05"));
//        myStarteritem1.add(new NormalFoodItem("Prawn", "","£7.05"));
//        myStarteritem1.add(new NormalFoodItem("Mixed", "","£6.95"));
//        myStarteritem1.add(new NormalFoodItem("Vegetable", "","£5.50"));
//        myStarteritem1.add(new NormalFoodItem("Vegan", "","£5.50"));

        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new AppitiserMainMenuAdapter(getContext(), biriryanTag);
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
