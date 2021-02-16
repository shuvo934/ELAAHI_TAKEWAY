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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.starterMainMenu.StarterMainMenu;

public class SeaFood extends AppCompatDialogFragment {
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
        titleName.setText(StarterMainMenu.starterTitle);
        cancel = view.findViewById(R.id.cancel_image);
        okBtn = view.findViewById(R.id.ok_button);

        myStarteritem1 = new ArrayList<>();

        myStarteritem1.add(new NormalFoodItem("King Prawn Puri", "(Mild) (No shells)","£4.15"));
        myStarteritem1.add(new NormalFoodItem("Prawn Puri", "(Mild) (No shells)","£3.25"));
        myStarteritem1.add(new NormalFoodItem("Stir fried Tiger king prawns New  Medium", "(No shells) Succelent tiger king prawns stir fried with onion, tomatoe & peppers","£4.95"));
        myStarteritem1.add(new NormalFoodItem("Peri Peri Tiger King Prawns New  HOT", "(No shells) Succulent fresh Tiger king prawns cooked with onions & peri peri sauce.","£4.95"));
        myStarteritem1.add(new NormalFoodItem("Pan fried Seabass  MILD", "","£4.95"));
        myStarteritem1.add(new NormalFoodItem("Pan fried Salmon  MILD", "","£4.95"));
        myStarteritem1.add(new NormalFoodItem("Mossalla grilled Fish Fillet New  SPICY", "","£4.95"));

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
