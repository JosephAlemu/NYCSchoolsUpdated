package a20180417_ja_nyschools.com.a20180417_ja_nyschools.model;

import android.annotation.SuppressLint;

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup;

import java.util.List;

/**
 * Created by user on 4/24/2018.
 */


@SuppressLint("ParcelCreator")
public class SchoolType extends ExpandableGroup<Detail> {

    public SchoolType(String title, List<Detail> items) {
        super(title, items);
    }
}

