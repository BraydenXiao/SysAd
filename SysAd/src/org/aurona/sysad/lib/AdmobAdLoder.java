package org.aurona.sysad.lib;

import com.google.android.gms.ads.*;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.ViewGroup;



public class AdmobAdLoder extends AdLoader{

	AdView adView;
	@Override
	public void loadAdView(Context activity, ViewGroup adBanner, String adID) {
		try {
			
			//原因：Android3.2系统报"java.lang.NoClassDefFoundError: android.net.http.HttpResponseCache"错误
			if(Build.VERSION.SDK_INT == 13) return;
			
			adView = new AdView(activity);
		    adView.setAdUnitId(adID);
		    adView.setAdSize(AdSize.BANNER);
		    
		    adBanner.addView(adView);
		    
			AdRequest adRequest = new AdRequest.Builder().setGender(AdRequest.GENDER_FEMALE).build();
			adView.setAdListener(new AdListener(){
				public void onAdLoaded(){
					Log.v("AdmobAdLoder","onAdLoaded");
				}
				
				public void onAdFailedToLoad(int errorCode){
					Log.v("AdmobAdLoder","onAdFailedToLoad");
				}
				
				public void onAdOpened(){
					Log.v("AdmobAdLoder","onAdOpened");
				}
				
				public void onAdClosed(){
					Log.v("AdmobAdLoder","onAdClosed");
				}
				
				public void onAdLeftApplication(){
					Log.v("AdmobAdLoder","onAdLeftApplication");
				}
			});
			 adView.loadAd(adRequest);
		} catch (Exception e) {
		} catch (Throwable e) {
		}
	}

	public  void clearAdView(){
		if(adView != null){
			adView.destroy();
		}	
	}
}
