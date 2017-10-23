package com.gaibo.biz.services.impl;

import init.ProductInit;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.constants.WarningInfoMap;
import org.gaibo.common.utils.HttpHelper;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gaibo.biz.services.IQueryWarningInfo;
import com.gaibo.biz.services.provide.UserMachineProvideSerice;
import com.gaibo.biz.share.vo.ResultVo;
import com.gaibo.biz.share.vo.WarningDto;
import com.gaibo.biz.share.vo.WarningResultVo;

@Service
public class QueryWarningInfoImpl implements IQueryWarningInfo {

	private static Logger logger = LoggerFactory.getLogger(QueryWarningInfoImpl.class);
	
//	http://103.231.67.143:8079/WARNING?QID=200001&QLEVEL=WARNING&USERNAME=user&MAC=081fa7a80661901dcb6051eaf0cfbfb6

	String url = GaiboConstant.URL + "/" + GaiboConstant.URI_WARNING + "?" ;
	
	//QID：000001~999999 随机数， 6 位长度，这里去200000~299999的随机数
	int QID= RandomUtils.nextInt(200000, 299999);
	@Resource
	private UserMachineProvideSerice userMachineProvideSerice ;
	
	/**
	 * 查询报警信息
	 * @author sangwenhao
	 * @date 2017年8月31日
	 * @see com.gaibo.biz.services.IQueryWarningInfo#queryWarning()
	 */
	@Override
	public String queryWarning(Map<String,Object> map) {
		logger.info("进入service层-queryOrderByCurrent ......");
		ResultVo resultVo = new ResultVo();
		try {
			//用户名
			String userName = (String) map.get("userName");
			//密码
			String password = (String) map.get("password");
			
			//md5校验顺序：QID=200001&USERNAME=user&PASSWORD=password&QLEVEL=WARNING
			StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=WARNING");
			
			//生成md5校验值
			String mac = MD5Utils.getMD5HEX(uri.toString());

			uri.append("&MAC=").append(mac) ;

			String httpPath = url + uri ;
			
			httpPath.replace("&PASSWORD="+GaiboConstant.PASSWORD, "").intern();
			logger.info(" >>>>>>>>>>>>>>>>url:{}",  httpPath);

			String response = HttpHelper.execute(httpPath);
			
			WarningResultVo warningVo = JSON.parseObject(response, WarningResultVo.class);
			//查询该客户下面有多少机器
			List<String> machines = userMachineProvideSerice.findMachineByUser(userName);
			List<WarningDto>   warningDtos = new ArrayList<WarningDto>();
			
			boolean flag = false ;
			if(StringUtils.equals(userName, GaiboConstant.USERNAME) ){
				flag = true ;
			}
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if(warningVo != null &&warningVo.getRecord() != null){
				for(List<String> list :warningVo.getRecord()){
					if(flag || machines.contains(list.get(0))){
						WarningDto dto = new WarningDto();
						dto.setMachineCode(list.get(0));
						dto.setWarningId(list.get(1));
						//错误编码能获取到中文就获取中文否则就用英文
						dto.setWarningMessage(StringUtils.isNotEmpty(ProductInit.getWarningInfo(list.get(1)))
								?ProductInit.getWarningInfo(list.get(1)):list.get(2));
						dto.setWarningDate(simpleDateFormat.format(new Date(list.get(3)+"+0800")));
						warningDtos.add(dto);
					}
				}
			}
			resultVo.setWarningDtos(warningDtos);
		} catch (Exception e) {
			// TODO: handle exception
			resultVo.setIsError("true");
			resultVo.setMessage("服务器出现异常");
			resultVo.setErrorInfo(e.getMessage());
			e.printStackTrace();
		}
		
		
		return JSON.toJSONString(resultVo);
	}

}
