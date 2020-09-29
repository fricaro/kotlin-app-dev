package br.edu.ifpb.pdm.francisco.truecolorslollipop.Model

import android.os.Parcel
import android.os.Parcelable

class Cor(var codigo: String?): Parcelable {

    constructor(parcel: Parcel): this(
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(codigo)
    }

    override fun describeContents(): Int {
        return 0
    }


    override fun toString(): String {
        return "Código: #${this.codigo}"
    }

    companion object CREATOR : Parcelable.Creator<Cor> {
        override fun createFromParcel(parcel: Parcel): Cor {
            return Cor(parcel)
        }

        override fun newArray(size: Int): Array<Cor?> {
            return arrayOfNulls(size)
        }
    }
}