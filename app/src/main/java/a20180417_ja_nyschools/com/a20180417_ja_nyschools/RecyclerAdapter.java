package a20180417_ja_nyschools.com.a20180417_ja_nyschools;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter;
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.Detail;
import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.SchoolType;


public class RecyclerAdapter extends ExpandableRecyclerViewAdapter<CityNameViewHolder, SchoolViewHolder> {

    private Activity activity;

    public RecyclerAdapter(Activity activity, List<? extends ExpandableGroup> groups) {
        super(groups);
        this.activity = activity;
    }

    @Override
    public CityNameViewHolder onCreateGroupViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.group_view_holder, parent, false);

        return new CityNameViewHolder(view);
    }

    @Override
    public SchoolViewHolder onCreateChildViewHolder(ViewGroup parent, final int viewType) {
        LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.child_view_holder, parent, false);

        return new SchoolViewHolder(view);
    }

    @Override
    public void onBindChildViewHolder(SchoolViewHolder holder, int flatPosition, ExpandableGroup group, int childIndex) {
        final Detail detail = ((SchoolType) group).getItems().get(childIndex);
        holder.onBind(detail,group);
    }

    @Override
    public void onBindGroupViewHolder(CityNameViewHolder holder, int flatPosition, ExpandableGroup group) {
        holder.setGroupName(group);
    }
}