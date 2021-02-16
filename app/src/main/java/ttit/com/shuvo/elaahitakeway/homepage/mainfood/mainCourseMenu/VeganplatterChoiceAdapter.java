package ttit.com.shuvo.elaahitakeway.homepage.mainfood.mainCourseMenu;

import android.content.Context;
import android.graphics.Color;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ttit.com.shuvo.elaahitakeway.R;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.NormalFoodItem;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.FlavorDialogue;
import ttit.com.shuvo.elaahitakeway.homepage.mainfood.dialogueBox.VeganPlatterItemss;

public class VeganplatterChoiceAdapter extends RecyclerView.Adapter<VeganplatterChoiceAdapter.VeganPlatterCViewholder> {

    public ArrayList<NormalFoodItem> myNormalFoodItem;
    public static String foodNameFromAdapter;
    public static String priceFormAdapter;
    public Context myContext;

    public VeganplatterChoiceAdapter(Context context, ArrayList<NormalFoodItem> normalFoodItems) {
        this.myContext = context;
        this.myNormalFoodItem = normalFoodItems;
    }

    @NonNull
    @Override
    public VeganPlatterCViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(myContext).inflate(R.layout.fooditem, parent, false);
        VeganPlatterCViewholder ammvh = new VeganPlatterCViewholder(v);
        return ammvh;
    }

    @Override
    public void onBindViewHolder(@NonNull VeganPlatterCViewholder holder, int position) {

        NormalFoodItem nFI = myNormalFoodItem.get(position);

        holder.mainFoodName.setText(nFI.getMyFood());
        holder.mainFoodDesc.setText(nFI.getMyFoodDesc());
        holder.mainFoodPrice.setText(nFI.getMyFoodPrice());

        if (holder.mainFoodName.getText().toString().endsWith("VE")) {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-2, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }
        if (holder.mainFoodName.getText().toString().endsWith("V")) {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(0, 148, 50)),text.length()-1, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }
        if (holder.mainFoodName.getText().toString().endsWith("HOT"))  {

            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-3, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            Log.i("paisi",holder.mainFoodName.getText().toString());

        }

        if ( holder.mainFoodName.getText().toString().endsWith("Medium")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-6, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.mainFoodName.getText().toString().endsWith("SPICY")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
        if ( holder.mainFoodName.getText().toString().endsWith("MILD")) {
            String text = holder.mainFoodName.getText().toString();
            SpannableString ss = new SpannableString(text);
            ss.setSpan(new ForegroundColorSpan(Color.rgb(192, 57, 43)),text.length()-5, text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
            holder.mainFoodName.setText(ss);
            //Log.i("paisi",holder.appitisernName.getText().toString());
        }
    }

    @Override
    public int getItemCount() {
        return myNormalFoodItem.size();
    }

    public class VeganPlatterCViewholder extends RecyclerView.ViewHolder {

        public TextView mainFoodName;
        public TextView mainFoodDesc;
        public TextView mainFoodPrice;
        public Button addButtonToCart;

        public VeganPlatterCViewholder(@NonNull View itemView) {
            super(itemView);

            mainFoodName = itemView.findViewById(R.id.foodName_normal);
            mainFoodDesc = itemView.findViewById(R.id.desc_normal);
            mainFoodPrice = itemView.findViewById(R.id.price_normal);
            addButtonToCart = itemView.findViewById(R.id.add_button_normal);

            addButtonToCart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    foodNameFromAdapter = myNormalFoodItem.get(getAdapterPosition()).getMyFood();
                    priceFormAdapter = myNormalFoodItem.get(getAdapterPosition()).getMyFoodPrice();
                    AppCompatActivity activity = (AppCompatActivity) v.getContext();
                    VeganPlatterItemss veganPlatterItemss = new VeganPlatterItemss();
                    veganPlatterItemss.show(activity.getSupportFragmentManager(),"Veeeeggga");
                }
            });
        }
    }
}
