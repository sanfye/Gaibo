package org.gaibo.common.constants;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 临时存放机器位置信息供小程序使用
 * @author 272311
 *
 */
public class MachineInfoMap {

	private static final Map<String,String> machineInfoMap = new HashMap<String,String>();
	
	static{
		machineInfoMap.put("12432", "滨江海越大厦");
		machineInfoMap.put("12433", "滨江创海基地");
		machineInfoMap.put("12434", "天和大厦");
	}
	
	
	public static String getMachineInfo(String key){
		String machineInfo = machineInfoMap.get(key);
		if(StringUtils.isBlank(machineInfo)){
			machineInfo = "未知";
		}
		return machineInfo ;
	}
	
	
}
