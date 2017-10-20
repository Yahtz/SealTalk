package cn.rongcloud.im.db;


import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import io.rong.common.ParcelUtils;
import io.rong.imlib.model.UserInfo;

/**
 * Entity mapped to table FRIEND.
 */
public class Friend extends UserInfo {

    private String displayName;
    private String region;
    private String phoneNumber;
    private String status;
    private Long timestamp;
    private String letters;
    private String nameSpelling;
    private String displayNameSpelling;

    public Friend(String userId, String name, Uri portraitUri) {
        super(userId, name, portraitUri);
    }

    public Friend(String userId, String name, Uri portraitUri, String displayName, String region, String phoneNumber, String status, Long timestamp, String nameSpelling, String displayNameSpelling, String letters) {
        super(userId, name, portraitUri);
        this.displayName = displayName;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.timestamp = timestamp;
        this.nameSpelling = nameSpelling;
        this.displayNameSpelling = displayNameSpelling;
        this.letters = letters;
    }

    public Friend(String userId, String name, Uri portraitUri, String displayName, String region, String phoneNumber, String status, Long timestamp, String nameSpelling, String displayNameSpelling) {
        super(userId, name, portraitUri);
        this.displayName = displayName;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.timestamp = timestamp;
        this.nameSpelling = nameSpelling;
        this.displayNameSpelling = displayNameSpelling;
    }

    public Friend(String userId, String name, Uri portraitUri, String displayName, String region, String phoneNumber, String status, Long timestamp) {
        super(userId, name, portraitUri);
        this.displayName = displayName;
        this.region = region;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Friend(String userId, String name, Uri portraitUri, String displayName, String status, Long timestamp) {
        super(userId, name, portraitUri);
        this.displayName = displayName;
        this.status = status;
        this.timestamp = timestamp;
    }

    public Friend(String userId, String name, Uri portraitUri, String phoneNumber, String displayName) {
        super(userId, name, portraitUri);
        this.phoneNumber = phoneNumber;
        this.displayName = displayName;
    }

    public Friend(String userId, String name, Uri portraitUri, String displayName) {
        super(userId, name, portraitUri);
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getLetters() {
        return letters;
    }

    public void setLetters(String letters) {
        this.letters = letters;
    }

    public String getNameSpelling() {
        return nameSpelling;
    }

    public void setNameSpelling(String nameSpelling) {
        this.nameSpelling = nameSpelling;
    }

    public String getDisplayNameSpelling() {
        return displayNameSpelling;
    }

    public void setDisplayNameSpelling(String displayNameSpelling) {
        this.displayNameSpelling = displayNameSpelling;
    }

    public Friend(Parcel in) {
        super(in);
        setDisplayName(ParcelUtils.readFromParcel(in));
        setRegion(ParcelUtils.readFromParcel(in));
        setPhoneNumber(ParcelUtils.readFromParcel(in));
        setStatus(ParcelUtils.readFromParcel(in));
        setTimestamp(ParcelUtils.readLongFromParcel(in));
        setNameSpelling(ParcelUtils.readFromParcel(in));
        setDisplayNameSpelling(ParcelUtils.readFromParcel(in));
        setLetters(ParcelUtils.readFromParcel(in));
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        super.writeToParcel(dest,flags);
        ParcelUtils.writeToParcel(dest, getDisplayName());
        ParcelUtils.writeToParcel(dest, getRegion());
        ParcelUtils.writeToParcel(dest, getPhoneNumber());
        ParcelUtils.writeToParcel(dest, getStatus());
        ParcelUtils.writeToParcel(dest, getTimestamp());
        ParcelUtils.writeToParcel(dest, getNameSpelling());
        ParcelUtils.writeToParcel(dest, getDisplayNameSpelling());
        ParcelUtils.writeToParcel(dest, getLetters());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Friend> CREATOR = new Creator<Friend>() {
        @Override
        public Friend createFromParcel(Parcel in) {
            return new Friend(in);
        }

        @Override
        public Friend[] newArray(int size) {
            return new Friend[size];
        }
    };

    public boolean isExitsDisplayName() {
        return !TextUtils.isEmpty(displayName);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null) {
            Friend friendInfo = (Friend) o;
            return (getUserId() != null && getUserId().equals(friendInfo.getUserId()))
                   && (getName() != null && getName().equals(friendInfo.getName()))
                   && (getPortraitUri() != null && getPortraitUri().equals(friendInfo.getPortraitUri()))
                   && (phoneNumber != null && phoneNumber.equals(friendInfo.getPhoneNumber()))
                   && (displayName != null && displayName.equals(friendInfo.getDisplayName()));
        } else {
            return false;
        }
    }
}
