package ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.CheckBoxList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.RadioChoiceList;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganPlatterItemDialogue;

public class VeganStarterAdapter extends RecyclerView.Adapter<VeganStarterAdapter.VeganStarterViewHolder>{

    private ArrayList<CheckBoxList> myVeganStarterItem;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public VeganStarterAdapter(Context context, ArrayList<CheckBoxList> mRadio) {
        this.myContext = context;
        this.myVeganStarterItem = mRadio;
    }

    @NonNull
    @Override
    public VeganStarterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.checkbox_item, parent,false);
        VeganStarterViewHolder rbv = new VeganStarterViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull VeganStarterViewHolder holder, int position) {
        CheckBoxList checkBoxList = myVeganStarterItem.get(position);

        holder.veganStarterName.setText(checkBoxList.getCheckBoxItem());

    }

    @Override
    public int getItemCount() {
        return myVeganStarterItem.size();
    }

    public class VeganStarterViewHolder extends RecyclerView.ViewHolder {
        public TextView veganStarterName;
        public CheckBox selectedBox;

        public VeganStarterViewHolder(@NonNull View itemView) {
            super(itemView);
            veganStarterName = itemView.findViewById(R.id.checkbox_name);
            selectedBox = itemView.findViewById(R.id.checkbox_selected);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && VeganPlatterItemDialogue.totalSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemDialogue.totalSelected -= 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemDialogue.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && VeganPlatterItemDialogue.totalSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemDialogue.totalSelected += 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemDialogue.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && VeganPlatterItemDialogue.totalSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(VeganPlatterItemDialogue.totalSelected));
                    }
                }
            });


        }
    }
}
