package com.gaibo.biz.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.utils.HttpHelper;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gaibo.biz.services.IQueryDeviceInfo;
import com.gaibo.biz.services.provide.UserMachineProvideSerice;
import com.gaibo.biz.share.vo.DeviceInfoDo;
import com.gaibo.biz.share.vo.DeviceInfoResultVo;
import com.gaibo.biz.share.vo.ResultVo;

@Service
public class QueryDeviceInfoImpl implements IQueryDeviceInfo {
	
//	http://103.231.67.143:8079/DEVICE?QID=300001&QLEVEL=INFO&USERNAME=user&MAC=f9add388b2fc6ca7628deb27d3504245
	private static String TYPE_INFO = "INFO" ;
	private static String TYPE_SUPPLY = "SUPPLY" ;
	
	private static final Logger logger = LoggerFactory.getLogger(QueryDeviceInfoImpl.class);
	
	String url = GaiboConstant.URL+"/"+GaiboConstant.URI_DEVICE+"?";
	
	@Resource
	private UserMachineProvideSerice userMachineProvideSerice ;
	
	//QID：000001~999999 随机数， 6 位长度，这里去300000~399999的随机数
	int QID= RandomUtils.nextInt(300000, 399999);
	/**
	 * 查询设备信息
	 * @param queryType:INFO 查询机器信息；queryType:SUPPLY 查询机器物料状态
	 * @author sangwenhao
	 * @date 2017年8月30日
	 */
	@Override
	public String queryDevice(String queryType,Map<String,Object> map) {
		logger.info("进入service层-queryDevice ......");
		//用户名
		String userName = (String) map.get("userName");
		//密码
		String password = (String) map.get("password");
		
		//md5校验顺序：QID=300001&USERNAME=user&PASSWORD=password&QLEVEL=INFO
		StringBuilder uri = new StringBuilder("QID=").append(QID)
			.append("&USERNAME=").append(GaiboConstant.USERNAME)
			.append("&PASSWORD=").append(GaiboConstant.PASSWORD);
			
		//查询物料信息
		if(StringUtils.equalsIgnoreCase(queryType, TYPE_SUPPLY)){
			uri.append("&QLEVEL=SUPPLY"); 
			
		}else if(StringUtils.equalsIgnoreCase(queryType, TYPE_INFO)){//查询机器信息
			uri.append("&QLEVEL=INFO"); 
			
		}else{
			//输入参数有误
		}

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac) ;
		String httpPath = url + uri ;
		httpPath.replace("&PASSWORD="+GaiboConstant.PASSWORD, "").intern();
		logger.info(" >>>>>>>>>>>>>>>>url:{}",  httpPath);

		ResultVo resultVo = new ResultVo();
		try {
			String response = HttpHelper.execute(httpPath);
			
			List<DeviceInfoDo> deviceInfoDos = new ArrayList<>();
			DeviceInfoResultVo deviceInfoResultVo = JSON.parseObject(response, DeviceInfoResultVo.class);
			
			List<String> machines = userMachineProvideSerice.findMachineByUser(userName);
			boolean flag = false ;
			if(StringUtils.equals(userName, GaiboConstant.USERNAME) ){
				flag = true ;
			}
			if(deviceInfoResultVo != null && deviceInfoResultVo.getRecord()!= null){
				for(List<String> list : deviceInfoResultVo.getRecord()){
				//过滤用户机器-暂时
				if(flag || machines.contains(list.get(0))){
					DeviceInfoDo deviceInfoDo = new DeviceInfoDo();
					deviceInfoDo.setMachineNo(list.get(0));
					deviceInfoDo.setSiteSimple(list.get(1));
					deviceInfoDo.setSiteDetail(list.get(2));
					deviceInfoDo.setOnOffLine(Integer.valueOf(StringUtils.defaultString(list.get(3),"0")));
					deviceInfoDos.add(deviceInfoDo);
				}//if end
			  }//for end
			}//if end
			
			resultVo.setDeviceInfoDos(deviceInfoDos);
		} catch (Exception e) {
			resultVo.setIsError("true");
			resultVo.setMessage("服务器出现异常");
			resultVo.setErrorInfo(e.getMessage());
			e.printStackTrace();
		}
		String result = JSON.toJSONString(resultVo) ;
		logger.info("json:" + result);
		return result ;
	}

}
