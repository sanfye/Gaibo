package org.gaibo.common.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 报警信息
 * @author sangwenhao
 * @date 2017年9月29日
 */
public class WarningInfoMap {

	private static final Map<String,String> warnIngInfoMap = new HashMap<String,String>();
	
	static{
		warnIngInfoMap.put("ECB_03","电路3电流过大");
		warnIngInfoMap.put("ECE_2","IO板2不响应");
		warnIngInfoMap.put("EC_2","没有IO板连接");
		warnIngInfoMap.put("EC_3","系统未就绪");
		warnIngInfoMap.put("EC_4","无支付设备");
		warnIngInfoMap.put("EC_6","请检查网络连接");
		warnIngInfoMap.put("EC_7","网络设置错误检查IPPort机器号");
		warnIngInfoMap.put("EI_2","通讯设备通讯或协议错误");
		warnIngInfoMap.put("EJA_01","未检测到大门电机");
		warnIngInfoMap.put("EJA_02","大门电机故障");
		warnIngInfoMap.put("ERROR:0081","搅拌电机1开路");
		warnIngInfoMap.put("ERROR:0088","搅拌电机1堵转");
		warnIngInfoMap.put("ERROR:0181","搅拌电机2开路");
		warnIngInfoMap.put("ERROR:0188","搅拌电机2堵转");
		warnIngInfoMap.put("ERROR:0281","搅拌电机3开路");
		warnIngInfoMap.put("ERROR:0288","搅拌电机3堵转");
		warnIngInfoMap.put("ERROR:0381","搅拌电机4开路");
		warnIngInfoMap.put("ERROR:0388","搅拌电机4堵转");
		warnIngInfoMap.put("ERROR:0681","空气泵开路");
		warnIngInfoMap.put("ERROR:0688","空气泵堵转");
		warnIngInfoMap.put("ERROR:0881","料盒电机1开路");
		warnIngInfoMap.put("ERROR:0888","料盒电机1堵转");
		warnIngInfoMap.put("ERROR:0981","料盒电机2开路");
		warnIngInfoMap.put("ERROR:0988","料盒电机2堵转");
		warnIngInfoMap.put("ERROR:0A81","料盒电机3开路");
		warnIngInfoMap.put("ERROR:0A88","料盒电机3堵转");
		warnIngInfoMap.put("ERROR:0B81","料盒电机4开路");
		warnIngInfoMap.put("ERROR:0B88","料盒电机4堵转");
		warnIngInfoMap.put("ERROR:0C81","料盒电机5开路");
		warnIngInfoMap.put("ERROR:0C88","料盒电机5堵转");
		warnIngInfoMap.put("ERROR:0D81","料盒电机6开路");
		warnIngInfoMap.put("ERROR:0D88","料盒电机6堵转");
		warnIngInfoMap.put("ERROR:0E81","料盒电机7开路");
		warnIngInfoMap.put("ERROR:0E88","料盒电机7堵转");
		warnIngInfoMap.put("ERROR:0F81","料盒电机8开路");
		warnIngInfoMap.put("ERROR:0F88","料盒电机8堵转");
		warnIngInfoMap.put("ERROR:1081","ES挤饼电机开路");
		warnIngInfoMap.put("ERROR:1088","ES挤饼电机堵转");
		warnIngInfoMap.put("ERROR:1181","ES密封电机开路");
		warnIngInfoMap.put("ERROR:1188","ES密封电机堵转");
		warnIngInfoMap.put("ERROR:1281","FB刮片电机开路");
		warnIngInfoMap.put("ERROR:1288","FB刮片电机堵转");
		warnIngInfoMap.put("ERROR:1381","FB密封电机开路");
		warnIngInfoMap.put("ERROR:1388","FB密封电机堵转");
		warnIngInfoMap.put("ERROR:1681","齿轮泵开路");
		warnIngInfoMap.put("ERROR:1688","齿轮泵堵转");
		warnIngInfoMap.put("ERROR:1881","分杯电机开路");
		warnIngInfoMap.put("ERROR:1888","分杯电机堵转");
		warnIngInfoMap.put("ERROR:1981","杯桶电机开路");
		warnIngInfoMap.put("ERROR:1988","杯桶电机堵转");
		warnIngInfoMap.put("ERROR:1A81","运杯电机开路");
		warnIngInfoMap.put("ERROR:1A88","运杯电机堵转");
		warnIngInfoMap.put("ERROR:1B81","大门电机开路");
		warnIngInfoMap.put("ERROR:1B88","大门电机堵转");
		warnIngInfoMap.put("ERROR:1C81","小门电机开路");
		warnIngInfoMap.put("ERROR:1C88","小门电机堵转");
		warnIngInfoMap.put("ERROR:2081","常温进水阀开路");
		warnIngInfoMap.put("ERROR:2181","冷水进水阀开路");
		warnIngInfoMap.put("ERROR:2281","ES二位三通阀开路");
		warnIngInfoMap.put("ERROR:2981","二位二通阀2开路");
		warnIngInfoMap.put("ERROR:2A81","二位二通阀3开路");
		warnIngInfoMap.put("ERROR:2B81","二位二通阀4开路");
		warnIngInfoMap.put("ERROR:2C81","二位二通阀5开路");
		warnIngInfoMap.put("ERROR:3581","水盒探针传感器一直开");
		warnIngInfoMap.put("ERROR:3A81","分杯马达位置传感器一直开");
		warnIngInfoMap.put("ERROR:3B00","杯桶旋转传感器异常");
		warnIngInfoMap.put("ERROR:3B80","杯桶旋转传感器一直关");
		warnIngInfoMap.put("ERROR:3B81","杯桶旋转传感器一直开");
		warnIngInfoMap.put("ERROR:3C81","运杯微动传感器1一直开");
		warnIngInfoMap.put("ERROR:3D81","运杯微动传感器2一直开");
		warnIngInfoMap.put("ERROR:4381","FB刮渣传感器一直开");
		warnIngInfoMap.put("ERROR:4480","FB密封传感器一直");
		warnIngInfoMap.put("ERROR:4481","FB密封传感器一直开");
		warnIngInfoMap.put("ERROR:5200","电路板电流过大");
		warnIngInfoMap.put("ERROR:5201","电路板电流过大");
		warnIngInfoMap.put("ERROR:5202","电路板电流过大");
		warnIngInfoMap.put("ERROR:5206","电路板电流过大");
		warnIngInfoMap.put("ERROR:5208","电路板电流过大");
		warnIngInfoMap.put("ERROR:520B","电路板电流过大");
		warnIngInfoMap.put("ERROR:520C","电路板电流过大");
		warnIngInfoMap.put("ERROR:5210","电路板电流过大");
		warnIngInfoMap.put("ERROR:5212","电路板电流过大");
		warnIngInfoMap.put("ERROR:5214","电路板电流过大");
		warnIngInfoMap.put("ERROR:5300","缺杯子");
		warnIngInfoMap.put("ERROR:5406","分杯失败多次");
		warnIngInfoMap.put("ERROR:5500","杯托移动不到位");
		warnIngInfoMap.put("ERROR:5600","做产品前有多余杯子");
		warnIngInfoMap.put("ERROR:5700","缺咖啡豆");
		warnIngInfoMap.put("ERROR:5901","净水缺乏1");
		warnIngInfoMap.put("ERROR:5902","净水缺乏2");
		warnIngInfoMap.put("ERROR:5A00","废水桶满");
		warnIngInfoMap.put("ERROR:5B00","接水托盘安装不到位");
		warnIngInfoMap.put("ERROR:5C00","流量计故障");
		warnIngInfoMap.put("ERROR:5C07","流量计故障");
		warnIngInfoMap.put("ERROR:5CFF","流量计故障");
		warnIngInfoMap.put("ERROR:5D00","锅炉温度传感器故障");
		warnIngInfoMap.put("ERROR:5DFF","锅炉温度传感器故障");
		warnIngInfoMap.put("ERROR:6100","锅炉温度过低");
		warnIngInfoMap.put("ERROR:6D00","做产品时执行部件异常0");
		warnIngInfoMap.put("ERROR:7000","CUP板连接异常");
		warnIngInfoMap.put("ERROR:7200","水箱填充超时");
		warnIngInfoMap.put("ERROR:7300","锅炉未连接");
		warnIngInfoMap.put("ERROR:7600","Brewer板连接错误");
		warnIngInfoMap.put("ERROR:7700","咖啡酿造器动作错误0");
		warnIngInfoMap.put("ERROR:7701","咖啡酿造器动作错误1");
		warnIngInfoMap.put("ERROR:7702","咖啡酿造器动作错误2");
		warnIngInfoMap.put("ERROR:7703","咖啡酿造器动作错误3");
		warnIngInfoMap.put("ERROR:7704","咖啡酿造器动作错误4");
		warnIngInfoMap.put("ERROR:7705","咖啡酿造器动作错误5");
		warnIngInfoMap.put("ERROR:7707","咖啡酿造器动作错误7");
		warnIngInfoMap.put("ERROR:7706","咖啡酿造器动作错误6");
		warnIngInfoMap.put("ERROR:7708","咖啡酿造器动作错误8");
		warnIngInfoMap.put("ERROR:7902","泡茶器动作错误2");
		warnIngInfoMap.put("ERROR:7906","泡茶器动作错误6");
		warnIngInfoMap.put("ERROR:7A20","压力传感器异常");
		warnIngInfoMap.put("ERROR:7AA5","压力传感器异常");
		warnIngInfoMap.put("ERROR:7AA7","压力传感器异常");
		warnIngInfoMap.put("ERROR:CUP_01","产品没被取走");
		warnIngInfoMap.put("HOPPER_2","退币器故障");
		warnIngInfoMap.put("INT_1","请检查网络连接");
		warnIngInfoMap.put("warning:01","缺糖预警（尚余少量）");
		warnIngInfoMap.put("warning:02","缺水预警（尚余少量）");
		warnIngInfoMap.put("warning:03","缺杯预警（尚余少量）");
		warnIngInfoMap.put("WARNING:0A","大门打开");
		warnIngInfoMap.put("WARNING:10009","咖啡豆不足预警");
		warnIngInfoMap.put("WARNING:10016","缺糖预警");

	}
	
	public static String getWarnIngInfo(String key){
		return  warnIngInfoMap.get(key);
	}
	
	
}
