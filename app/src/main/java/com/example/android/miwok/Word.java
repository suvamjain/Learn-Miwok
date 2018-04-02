package com.example.android.miwok;

/**
 * Created by SUVAM JAIN on 28-03-2017.
 */

public class Word {

    // String value
    private String mDefaultTranslation;

    // String value
    private String mMiwokTranslation;

    // Integer value
    private int mImageResourceId = NO_IMAGE_PROVIDED; // this variable is set to start with No_image variable so that if it doesn't change than we can say the activity has no image

    // const variable must be capitalized and here it's value is set to be -1 becoz it is totally out of range of any image resourceId
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Constructs for defining the values for mDefaultTranslation and mMiwokTranslation.
     */
    public Word(String defaultTranslation, String miwokTranslation) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int ImageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = ImageResourceId;
    }

    /**
     * return mDefaultTranslation .
     */
    public String  getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * return mMiwokTranslation of the word.
     */
    public String  getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * return mImage of the word.
     */

    public int getImageResourceId() { return mImageResourceId; }


    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}