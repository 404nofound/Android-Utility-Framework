package com.eddy.androidutilityframework.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

    private String name;

    private String author;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(author);
    }

    public static final Parcelable.Creator<Book> CREATOR =
            new Parcelable.Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel source) {
            Book book = new Book();

            //Order should be same as writeToParcel()
            book.name = source.readString();
            book.author = source.readString();
            return book;
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
