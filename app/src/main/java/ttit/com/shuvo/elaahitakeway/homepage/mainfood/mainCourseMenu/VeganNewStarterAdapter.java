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
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.adapter.VeganStarterAdapter;
import ttit.com.shuvo.elaahitakeway.homepage.elaahifood.adult.maincourse.mainCourseDialogue.VeganPlatterItemDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.VeganPlatterItemss;

public class VeganNewStarterAdapter extends RecyclerView.Adapter<VeganNewStarterAdapter.VeganNewSSViewHolder> {

    private ArrayList<CheckBoxList> myVeganStarterItem;
    private Context myContext;

    private int lastSelectedPosition = -1;

    public VeganNewStarterAdapter(Context context, ArrayList<CheckBoxList> mRadio) {
        this.myContext = context;
        this.myVeganStarterItem = mRadio;
    }

    @NonNull
    @Override
    public VeganNewSSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(myContext).inflate(R.layout.checkbox_item, parent,false);
        VeganNewSSViewHolder rbv = new VeganNewSSViewHolder(view);
        return rbv;
    }

    @Override
    public void onBindViewHolder(@NonNull VeganNewSSViewHolder holder, int position) {
        CheckBoxList checkBoxList = myVeganStarterItem.get(position);

        holder.veganStarterName.setText(checkBoxList.getCheckBoxItem());

    }

    @Override
    public int getItemCount() {
        return myVeganStarterItem.size();
    }

    public class VeganNewSSViewHolder extends RecyclerView.ViewHolder {
        public TextView veganStarterName;
        public CheckBox selectedBox;

        public VeganNewSSViewHolder(@NonNull View itemView) {
            super(itemView);
            veganStarterName = itemView.findViewById(R.id.checkbox_name);
            selectedBox = itemView.findViewById(R.id.checkbox_selected);

            selectedBox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (selectedBox.isChecked() == true && VeganPlatterItemss.totalSelected != 0) {
                        selectedBox.setChecked(true);
                        Log.i("true",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemss.totalSelected -= 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(true);
                    } else if (selectedBox.isChecked() == false && VeganPlatterItemss.totalSelected >= 0) {
                        selectedBox.setChecked(false);
                        Log.i("false",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        VeganPlatterItemss.totalSelected += 1;
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                        myVeganStarterItem.get(getAdapterPosition()).setCheckedItem(false);
                    } else if (selectedBox.isChecked() == true && VeganPlatterItemss.totalSelected == 0) {
                        selectedBox.setChecked(false);
                        Log.i("hobe na kisu",myVeganStarterItem.get(getAdapterPosition()).getCheckBoxItem());
                        Log.i("number of selection", String.valueOf(VeganPlatterItemss.totalSelected));
                    }
                }
            });


        }
    }
}
