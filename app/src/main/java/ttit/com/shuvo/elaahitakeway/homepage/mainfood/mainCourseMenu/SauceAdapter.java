package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.RadioButtonAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishItemListDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.RadioButtonDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.SeaFoodRadioDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganMainChoiceListDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.FlavorDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.SauceDialogueforMenu;

public class SauceAdapter extends RecyclerView.Adapter<SauceAdapter.SauceViewHolder> {

    private ArrayList<RadioChoiceList> radioChoiceLists;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public SauceAdapter(Context context, ArrayList<RadioChoiceList> mRadio) {
        this.myContext = context;
        this.radioChoiceLists = mRadio;
    }

    @NonNull
    @Override
    public SauceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.radio_list_item, parent,false);
        SauceViewHolder rbv = new SauceViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull SauceViewHolder holder, int position) {
        RadioChoiceList radioChoiceList = radioChoiceLists.get(position);

        holder.sauce.setText(radioChoiceList.getSauceName());

        holder.selectedRadio.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return radioChoiceLists.size();
    }

    public class SauceViewHolder extends RecyclerView.ViewHolder {
        public TextView sauce;
        public RadioButton selectedRadio;

        public SauceViewHolder(@NonNull View itemView) {
            super(itemView);
            sauce = itemView.findViewById(R.id.choice_name);
            selectedRadio = itemView.findViewById(R.id.radio_choice_selected);

            selectedRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                    SauceDialogueforMenu.selectedSauce = sauce.getText().toString();
                    FlavorDialogue.selectedSauce = sauce.getText().toString();
//                    RadioButtonDialogue.selectedSauce = sauce.getText().toString();
//                    SeaFoodRadioDialogue.selectedSauce = sauce.getText().toString();
//                    VeganMainChoiceListDialogue.selectedSauce = sauce.getText().toString();
//                    ClassicDishItemListDialogue.selectedSauce = sauce.getText().toString();
                    Log.i("Selected Sauce: ", sauce.getText().toString());
                }
            });
        }
    }
}
