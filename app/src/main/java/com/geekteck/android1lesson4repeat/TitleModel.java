package com.geekteck.android1lesson4repeat;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

public class TitleModel implements Parcelable {
    private String text;
    private String description;

    public TitleModel(String text, String description) {
        this.text = text;
        this.description = description;
    }

    protected TitleModel(Parcel in) {
        text = in.readString();
        description = in.readString();
    }

    public static final Creator<TitleModel> CREATOR = new Creator<TitleModel>() {
        @Override
        public TitleModel createFromParcel(Parcel in) {
            return new TitleModel(in);
        }

        @Override
        public TitleModel[] newArray(int size) {
            return new TitleModel[size];
        }
    };

    public String getText() { return text;
    }

    public String getDescription() { return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(text);
        dest.writeString(description);
    }
}
