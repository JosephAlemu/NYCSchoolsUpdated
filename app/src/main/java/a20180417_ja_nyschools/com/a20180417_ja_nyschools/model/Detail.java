package a20180417_ja_nyschools.com.a20180417_ja_nyschools.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by user on 4/24/2018.
 */

public class Detail implements Parcelable {
    String schoolName;
    String zip;

    public Detail(String schoolName, String zip) {
        this.schoolName = schoolName;
        this.zip = zip;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    protected Detail(Parcel in) {
        schoolName = in.readString();
        zip = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(schoolName);
        dest.writeString(zip);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel in) {
            return new Detail(in);
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };
}
