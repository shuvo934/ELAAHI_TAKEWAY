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
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.FlavorDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.MeatSelectionDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.SauceDialogueforMenu;

public class MeatwithPriceAdapter extends RecyclerView.Adapter<MeatwithPriceAdapter.MeatwithPriceViewHolder> {

    private ArrayList<NormalFoodItem> radioChoiceLists;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public MeatwithPriceAdapter(Context context, ArrayList<NormalFoodItem> mRadio) {
        this.myContext = context;
        this.radioChoiceLists = mRadio;
    }

    @NonNull
    @Override
    public MeatwithPriceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.radio_list_item_with_price, parent,false);
        MeatwithPriceViewHolder rbv = new MeatwithPriceViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull MeatwithPriceViewHolder holder, int position) {
        NormalFoodItem radioChoiceList = radioChoiceLists.get(position);

        holder.sauce.setText(radioChoiceList.getMyFood());
        holder.price.setText(radioChoiceList.getMyFoodPrice());

        holder.selectedRadio.setChecked(lastSelectedPosition == position);
    }

    @Override
    public int getItemCount() {
        return radioChoiceLists.size();
    }

    public class MeatwithPriceViewHolder extends RecyclerView.ViewHolder {
        public TextView sauce;
        public TextView price;
        public RadioButton selectedRadio;

        public MeatwithPriceViewHolder(@NonNull View itemView) {
            super(itemView);
            sauce = itemView.findViewById(R.id.name_CD);
            price = itemView.findViewById(R.id.price_CD);
            selectedRadio = itemView.findViewById(R.id.radio_choice_selected_CD);

            selectedRadio.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    lastSelectedPosition = getAdapterPosition();
                    notifyDataSetChanged();
                    MeatSelectionDialogue.selectedSauce = sauce.getText().toString();
                    MeatSelectionDialogue.selectedPrice = price.getText().toString();
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
