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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.VeganplatterChoiceAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.SubCategoryItemTag;

import static ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu.MainCourseMenu.mainFoodTag;

public class VeganPlatter extends AppCompatDialogFragment {

    public static ArrayList<NormalFoodItem> myStarteritem1;

    public static ArrayList<SubCategoryItemTag> vpTag;

    private RecyclerView normalFoodView;
    private VeganplatterChoiceAdapter aptMainMenuAdapter;
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

        vpTag = new ArrayList<>();

        myStarteritem1 = new ArrayList<>();

        vpTag = mainFoodTag;

      //  myStarteritem1.add(new NormalFoodItem("Vegan-Platter", "(100% Vegan). Choose any three vegan dishes, and the spice strength you want, from the pop-up that appears","£6.95"));



        normalFoodView = view.findViewById(R.id.appitiser_list_view);
        normalFoodView.setHasFixedSize(true);
        aptLayout = new LinearLayoutManager(getContext());
        normalFoodView.setLayoutManager(aptLayout);

        aptMainMenuAdapter = new VeganplatterChoiceAdapter(getContext(), vpTag);
        normalFoodView.setAdapter(aptMainMenuAdapter);


        builder.setView(view);

        AlertDialog dialog = builder.create();
        dialog.setCanceledOnTouchOutside(false);
        dialog.setCancelable(false);

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
