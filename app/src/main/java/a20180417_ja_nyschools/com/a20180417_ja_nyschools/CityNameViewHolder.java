package a20180417_ja_nyschools.com.a20180417_ja_nyschools;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;


public class CityNameViewHolder extends GroupViewHolder {

    private TextView cityname;

    public CityNameViewHolder(View itemView) {
        super(itemView);

        cityname = (TextView) itemView.findViewById(R.id.cityname);
    }

    @Override
    public void expand() {
        cityname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.down_arrow, 0);
        Log.i("Adapter", "expand");
    }

    @Override
    public void collapse() {
        Log.i("Adapter", "collapse");
        cityname.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.up_arrow, 0);
    }

    public void setGroupName(ExpandableGroup group) {
        cityname.setText(group.getTitle());
    }
}