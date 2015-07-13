package org.aurona.sysad.lib;

public class AdLoaderFactory {
	public static AdLoader getDefaultAdLoader(){
		return new AdmobAdLoder();
	}
}
