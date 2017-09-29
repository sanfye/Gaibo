package org.gaibo.common.constants;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * 产品信息临时存放于map,后面改成数据库
 * @author 272311
 *
 */
public class ProductInfoMap {

	private static final Map<String,String> productInfoMap = new HashMap<String,String>();
	
	static{
		productInfoMap.put("102", "卡布奇诺");
		productInfoMap.put("284", "摩卡");
		productInfoMap.put("246", "拿铁");
		productInfoMap.put("122", "维也纳咖啡");
		productInfoMap.put("240", "玛琪雅朵");
		productInfoMap.put("148", "煎咖啡");
		productInfoMap.put("931", "经典美式冰咖");
		productInfoMap.put("204", "意式长咖啡");
		productInfoMap.put("103", "意式黑咖啡");
		productInfoMap.put("951", "长岛冰茶");
		productInfoMap.put("147", "清香鲜萃茶");
		productInfoMap.put("127", "英式皇家奶茶");
		productInfoMap.put("146", "丝袜奶茶");
		productInfoMap.put("104", "鸳鸯奶茶");
		productInfoMap.put("811", "醇香牛奶");
		productInfoMap.put("802", "牛奶巧克力");
		productInfoMap.put("800", "香浓巧克力");
		
		
		/*
		productInfoMap.put("101", "卡布奇诺");
		productInfoMap.put("102", "卡布奇诺加糖");
		productInfoMap.put("103", "卡布奇诺加糖");
		productInfoMap.put("104", "咖啡加茶");
		productInfoMap.put("105", "美式咖啡");
		productInfoMap.put("106", "美式咖啡加糖");
		productInfoMap.put("204", "意式长咖啡");
		productInfoMap.put("205", "意式长咖啡");
		productInfoMap.put("206", "意式长咖啡");
		productInfoMap.put("207", "意式长咖啡");
		productInfoMap.put("210", "双份意式咖啡");
		productInfoMap.put("220", "意式巧克力");
		productInfoMap.put("237", "玛琪雅朵");
		productInfoMap.put("240", "玛琪雅朵加糖");
		productInfoMap.put("243", "拿铁");
		productInfoMap.put("245", "抹茶拿铁");
		productInfoMap.put("246", "拿铁加糖");
		productInfoMap.put("283", "摩卡");
		productInfoMap.put("284", "摩卡加糖");
		productInfoMap.put("700", "红茶");
		productInfoMap.put("701", "奶茶");
		productInfoMap.put("702", "奶茶加糖");
		productInfoMap.put("704", "甜红茶");
		productInfoMap.put("800", "巧克力");
		productInfoMap.put("801", "巧克力加糖");
		productInfoMap.put("802", "巧克力牛奶");
		productInfoMap.put("803", "巧克力奶茶");
		productInfoMap.put("805", "玛琪雅朵加糖");
		productInfoMap.put("806", "摩卡");
		productInfoMap.put("807", "美式咖啡");
		productInfoMap.put("810", "热牛奶");
		productInfoMap.put("811", "热牛奶加糖");
		productInfoMap.put("812", "热芒果");
		productInfoMap.put("813", "雀巢柠檬茶");
		productInfoMap.put("814", "牦牛奶");
		productInfoMap.put("815", "橙C");
		productInfoMap.put("816", "热水");
		productInfoMap.put("817", "热菠萝");
		productInfoMap.put("818", "热芒果菠萝");
		productInfoMap.put("819", "热豆浆");
		productInfoMap.put("820", "焦糖卡布奇诺");
		productInfoMap.put("821", "榛果卡布奇诺");
		productInfoMap.put("822", "爱尔兰卡布奇诺");
		productInfoMap.put("823", "香草牛奶");
		productInfoMap.put("901", "速溶咖啡");
		productInfoMap.put("904", "香草卡布奇诺");
		productInfoMap.put("920", "美禄");
		productInfoMap.put("921", "冰芒果");
		productInfoMap.put("922", "冰菠萝");
		productInfoMap.put("923", "冰芒果菠萝");
		productInfoMap.put("925", "冰柠檬");
		productInfoMap.put("926", "冰美禄");
		productInfoMap.put("927", "冰香橙");
		productInfoMap.put("928", "冰糖雪梨");
		productInfoMap.put("929", "蜂蜜柚子茶");
		productInfoMap.put("930", "美式咖啡(冷饮)");
		productInfoMap.put("931", "美式咖啡(冷饮)");
		productInfoMap.put("932", "冰抹茶");
		productInfoMap.put("933", "冰卡布奇诺");
		productInfoMap.put("934", "冰拿铁");
		productInfoMap.put("938", "冰抹茶拿铁");
		productInfoMap.put("935", "冰巧克力");
		productInfoMap.put("936", "冰绿茶拿铁");
		productInfoMap.put("937", "话梅柠檬茶(冷)");
		productInfoMap.put("950", "热水");
		productInfoMap.put("960", "热牛奶");
		productInfoMap.put("970", "巧克力");
		productInfoMap.put("980", "巧克力牛奶");
		productInfoMap.put("990", "奶茶");
		productInfoMap.put("991", "巧克力");
		productInfoMap.put("955", "冰红茶(冷饮)");
		productInfoMap.put("952", "酸梅汤(冷饮)");
		productInfoMap.put("107", "港式鸳鸯加糖");
		productInfoMap.put("902", "速溶茶");
		productInfoMap.put("924", "凉茶");
		productInfoMap.put("954", "冰水蜜桃(冷饮)");
		productInfoMap.put("956", "冰牛奶");
		productInfoMap.put("108", "瑞士咖啡");
		productInfoMap.put("109", "拿铁摩茶");
		productInfoMap.put("110", "抹香奶咖");
		productInfoMap.put("705", "冰卡布奇诺(甜)");
		productInfoMap.put("940", "冰拿铁(甜)");
		productInfoMap.put("941", "冰玫茶");
		productInfoMap.put("942", "冰咖啡");
		productInfoMap.put("825", "冰柠檬茶");
		productInfoMap.put("824", "原味奶茶");
		productInfoMap.put("957", "冰荔枝");
		productInfoMap.put("958", "冰黄桃");
		productInfoMap.put("843", "巧克力牛奶加糖");
		*/
	}

	public static String getProductInfo(String key){
		String productInfo = productInfoMap.get(key);
		if(StringUtils.isBlank(productInfo)){
			productInfo = "未知";
		}
		return productInfo ;
	}	

}
