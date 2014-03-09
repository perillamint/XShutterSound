package org.maneulyori.xshuttersound;

import android.content.res.XModuleResources;
import android.content.res.XResources;
import de.robv.android.xposed.IXposedHookZygoteInit;

public class XposedHooker implements IXposedHookZygoteInit {

	private String MODULE_PATH = null;
	
	public void initZygote(StartupParam startupParam) throws Throwable {
		MODULE_PATH = startupParam.modulePath;
		XModuleResources modRes = XModuleResources.createInstance(MODULE_PATH, null);
		XResources.setSystemWideReplacement("android", "bool",
				"config_camera_sound_forced", modRes.fwd(R.bool.config_camera_sound_forced));
	}

}