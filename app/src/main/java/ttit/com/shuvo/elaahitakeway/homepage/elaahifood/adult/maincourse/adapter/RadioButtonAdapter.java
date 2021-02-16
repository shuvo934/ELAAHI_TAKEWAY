package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.ClassicDishItemListDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.RadioButtonDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.SeaFoodRadioDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganMainChoiceListDialogue;

public class RadioButtonAdapter extends RecyclerView.Adapter<RadioButtonAdapter.RadioButtonViewHolder> {

    private ArrayList<RadioChoiceList> radioChoiceLists;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public RadioButtonAdapter(Context context, ArrayList<RadioChoiceList> mRadio) {
        this.myContext = context;
        this.radioChoiceLists = mRadio;
    }

    @NonNull
    @Override
    public RadioButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.radio_list_item, parent,false);
        RadioButtonViewHolder rbv = new RadioButtonViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull RadioButtonViewHolder holder, int position) {
        RadioChoiceList radioChoiceList = radioChoiceLists.get(position);

        holder.sauce.setText(radioChoiceList.getSauceName());

        holder.selectedRadio.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return radioChoiceLists.size();
    }

    public class RadioButtonViewHolder extends RecyclerView.ViewHolder {
        public TextView sauce;
        public RadioButton selectedRadio;

        public RadioButtonViewHolder(@NonNull View itemView) {
            super(itemView);
            sauce = itemView.findViewById(R.id.choice_name);
            selectedRadio = itemView.findViewById(R.id.radio_choice_selected);

            selectedRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                    RadioButtonDialogue.selectedSauce = sauce.getText().toString();
                    SeaFoodRadioDialogue.selectedSauce = sauce.getText().toString();
                    VeganMainChoiceListDialogue.selectedSauce = sauce.getText().toString();
                    ClassicDishItemListDialogue.selectedSauce = sauce.getText().toString();
                    Log.i("Selected Sauce: ", sauce.getText().toString());
                }
            });
        }
    }

}
