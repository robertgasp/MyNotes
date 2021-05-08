package com.example.mynotes.domain;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.StringRes;

public class Notes implements Parcelable {

    @StringRes
    private final int titleRes;
    private final int contentRes;

    public Notes(int titleRes, int contentRes) {
        this.titleRes = titleRes;
        this.contentRes=contentRes;
    }

    protected Notes(Parcel in) {
        titleRes = in.readInt();
        contentRes=in.readInt();
    }

    public static final Creator<Notes> CREATOR = new Creator<Notes>() {
        @Override
        public Notes createFromParcel(Parcel in) {
            return new Notes(in);
        }

        @Override
        public Notes[] newArray(int size) {
            return new Notes[size];
        }
    };

    public int getTitleRes() {
        return titleRes;
    }

    public int getContentRes() {
        return contentRes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(titleRes);
        dest.writeInt(contentRes);
    }
}
