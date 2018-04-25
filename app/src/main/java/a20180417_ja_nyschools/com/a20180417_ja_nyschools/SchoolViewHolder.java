package a20180417_ja_nyschools.com.a20180417_ja_nyschools;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;

import a20180417_ja_nyschools.com.a20180417_ja_nyschools.model.Detail;

public class SchoolViewHolder extends ChildViewHolder {

    private TextView school_name;

    public SchoolViewHolder(View itemView) {
        super(itemView);

        school_name = (TextView) itemView.findViewById(R.id.school_name);
    }

    public void onBind(Detail detail, ExpandableGroup group) {
        school_name.setText(detail.getSchoolName());


        switch(group.getTitle())
        {

            case "Astoria":

                break;

            case "Bayside":

                break;
            case "Bellerose":

                break;
            case "Bronx":

                break;
            case "Brooklyn":

                break;
            case "Cambria Heights":

                break;
            case "Corona":

                break;
            case "Elmhurst":

                break;
            case "Far Rockaway":

                break;
            case "Flushing":

                break;
            case "Forest Hills":

                break;
            case "Fresh Meadows":

                break;

            case "Hollis":
                break;


            case "Jamaica":
                  break;

            case "Long Island City":


                break;
            case "Manhattan":

                break;
            case "Oakland Gardens":

                break;
            case "Ozone Park":

                break;

            case "Queens Village":

                break;
            case "Richmond Hill":

                break;
            case "Ridgewood":

                break;
            case "Rockaway Park":

                break;
            case "Saint Albans":

                break;

            case "South Ozone Park":

                break;
            case "South Richmond Hill":

                break;
            case "Springfield Gardens":

                break;
            case "Staten Island":

                break;


            default :

        }

        school_name.setCompoundDrawablesWithIntrinsicBounds(R.drawable.school, 0, 0, 0);

    }
}


