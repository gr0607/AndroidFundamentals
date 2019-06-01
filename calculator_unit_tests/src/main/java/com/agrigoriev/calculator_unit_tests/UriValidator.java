package com.agrigoriev.calculator_unit_tests;

import android.content.Context;

import java.net.URI;

public class UriValidator {

    private final Context mContext;

    public UriValidator(Context context) {
        mContext = context;
    }

    public String validate(String uri) {
        int resId = R.string.nothing;
        if (isUrl(uri)){
            resId = R.string.url;
        } else if (isFile(uri)) {
            resId = R.string.file;
        }
        return mContext.getString(resId);
    }

    private boolean isUrl(String uri) {
        return "http".equals(URI.create(uri).getScheme());
    }

    private boolean isFile(String uri) {
        return "file".equals(URI.create(uri).getScheme());
    }
}
