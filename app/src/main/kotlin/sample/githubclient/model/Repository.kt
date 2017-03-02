package sample.githubclient.model

import android.os.Parcel
import android.os.Parcelable

data class Repository(val id: Long,
                      val fullName: String,
                      val description: String,
                      val htmlUrl: String,
                      val stargazersCount: Int,
                      val language: String,
                      val owner: User) : Parcelable {

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Repository> = object : Parcelable.Creator<Repository> {
            override fun createFromParcel(source: Parcel): Repository =
                    Repository(source.readLong(),
                            source.readString(),
                            source.readString(),
                            source.readString(),
                            source.readInt(),
                            source.readString(),
                            source.readParcelable(Repository::class.java.classLoader))

            override fun newArray(size: Int): Array<out Repository?> = kotlin.arrayOfNulls(size)
        }
    }

    override fun describeContents(): Int = 0

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeLong(id)
        dest.writeString(fullName)
        dest.writeString(description)
        dest.writeString(htmlUrl)
        dest.writeInt(stargazersCount)
        dest.writeString(language)
        dest.writeParcelable(owner, flags)
    }
}
