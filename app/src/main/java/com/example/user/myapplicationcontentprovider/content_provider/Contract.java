package com.example.user.myapplicationcontentprovider.content_provider;

import android.net.Uri;

/**
 * Created by user on 02.03.15.
 */
public class Contract {
    public static final String CONTENT_PATH = "com.example.user.myapplicationcontentprovider.content_provider.NamesContentProvider";
   public static final Uri CONTENT_URI = Uri.parse("content://" + CONTENT_PATH  + "/");


}
