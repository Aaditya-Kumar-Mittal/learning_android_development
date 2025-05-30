package com.example.learningandroiddev

import android.os.Parcel
import android.os.Parcelable

data class RecyclerViewDataClassOne(var dataImage: Int, var dataTitle: String, var dataDesc : String, var dataDetailImage: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt()
    ){}

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(dataImage)
        parcel.writeString(dataTitle)
        parcel.writeString(dataDesc)
        parcel.writeInt(dataDetailImage)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR: Parcelable.Creator<RecyclerViewDataClassOne> {
        override fun createFromParcel(parcel: Parcel): RecyclerViewDataClassOne {
            return RecyclerViewDataClassOne(parcel)
        }

        override fun newArray(size: Int): Array<out RecyclerViewDataClassOne?>? {
            return arrayOfNulls(size)
        }
    }

}