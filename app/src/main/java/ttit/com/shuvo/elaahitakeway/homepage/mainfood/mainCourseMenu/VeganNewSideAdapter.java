package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu;

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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.VeganSideAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganPlatterItemDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.VeganPlatterItemss;

public class VeganNewSideAdapter extends RecyclerView.Adapter<VeganNewSideAdapter.VeganNewViewHolder> {

    private ArrayList<CheckBoxList> myVeganSideItem;
    private Context myContext;


    public VeganNewSideAdapter(Context context, ArrayList<CheckBoxList> mRadio) {
        this.myContext = context;
        this.myVeganSideItem = mRadio;
    }

    @NonNull
    @Override
    public VeganNewViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.checkbox_item, parent,false);
        VeganNewViewHolder rbv = new VeganNewViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull VeganNewViewHolder holder, int position) {
        CheckBoxList checkBoxList = myVeganSideItem.get(position);

        holder.veganSideName.setText(checkBoxList.getCheckBoxItem());
        holder.selectedBox.setChecked(checkBoxList.getCheckedItem());

    }

    @Override
    public int getItemCount() {
        return myVeganSideItem.size();
    }

    public class VeganNewViewHolder extends RecyclerView.ViewHolder {
        public TextView veganSideName;
        public CheckBox selectedBox;

        public VeganNewViewHolder(@NonNull View itemView) {
            super(itemView);
            veganSideName = itemView.findViewById(R.id.checkbox_name);
            selectedBox = itemView.findViewById(R.id.checkbox_selected);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && VeganPlatterItemss.totalSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemss.totalSelected -= 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                        myVeganSideItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && VeganPlatterItemss.totalSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemss.totalSelected += 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                        myVeganSideItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && VeganPlatterItemss.totalSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu",myVeganSideItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                    }
                }
            });

        }
    }
}
