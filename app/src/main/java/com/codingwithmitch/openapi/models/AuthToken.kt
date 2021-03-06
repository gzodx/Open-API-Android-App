package com.codingwithmitch.openapi.models

import android.accounts.Account
import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Data class for saving authentication token locally for open-api.xyz
 * NOTES:
 * 1) local 'auth_token' table has foreign key relationship to 'account_properties' table through 'account' field (PK)
 *
 * Docs: https://open-api.xyz/api/
 */
@Entity(
    tableName = "auth_token",
    foreignKeys = [
        ForeignKey(
            entity = AccountProperties::class,
            parentColumns = ["pk"],
            childColumns = ["account_pk"],
            onDelete = CASCADE
        )
    ]
)
data class AuthToken(

    @PrimaryKey
    @ColumnInfo(name = "account_pk")
    var account_pk: Int? = -1,


    @ColumnInfo(name = "token")
    @SerializedName("token")
    @Expose
    var token: String? = null
): Parcelable
{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        account_pk?.let { parcel.writeInt(it) }
        parcel.writeString(token)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun toString(): String {
        return "AuthToken(account_pk=$account_pk, token='$token')"
    }

    companion object CREATOR : Parcelable.Creator<AuthToken> {
        override fun createFromParcel(parcel: Parcel): AuthToken {
            return AuthToken(parcel)
        }

        override fun newArray(size: Int): Array<AuthToken?> {
            return arrayOfNulls(size)
        }
    }



}










