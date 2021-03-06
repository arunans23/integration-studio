package org.wso2.integrationstudio.artifact.bpel.utils;

import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.wso2.integrationstudio.utils.ui.ImageUtils;
import org.wso2.integrationstudio.artifact.bpel.Activator;

public class BPELImageUtils extends ImageUtils{

	private static ImageUtils instance;

	public static ImageUtils getInstance(){
		if (instance==null){
			instance=new BPELImageUtils();
		}
		return instance;
	} 

	public Bundle getBundle(){
		return Platform.getBundle(Activator.PLUGIN_ID);
	}

}
