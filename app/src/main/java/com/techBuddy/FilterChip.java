package com.techBuddy;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import com.pchmn.materialchips.model.ChipInterface;

/**
 * Created by sourav on 9/16/17.
 */

public class FilterChip implements ChipInterface {

    private String id;
    private Uri avatarUri;
    private String name;
    private String phoneNumber;

    public FilterChip(String name) {
//        this.id = id;
//        this.avatarUri = avatarUri;
        this.name = name;
    }

    @Override
    public Object getId() {
        return id;
    }

    @Override
    public Uri getAvatarUri() {
        return avatarUri;
    }

    @Override
    public Drawable getAvatarDrawable() {
        return null;
    }

    @Override
    public String getLabel() {
        return name;
    }

    @Override
    public String getInfo() {
        return phoneNumber;
    }
}