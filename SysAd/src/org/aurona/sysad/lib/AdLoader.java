package org.aurona.sysad.lib;

import android.app.Activity;
import android.content.Context;
import android.view.ViewGroup;

public abstract class AdLoader {
	public abstract void loadAdView(Context activity,ViewGroup adBanner, String adID);
	
	public abstract void clearAdView();
}
