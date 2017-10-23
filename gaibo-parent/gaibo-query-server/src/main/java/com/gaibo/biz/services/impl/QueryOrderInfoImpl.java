package com.gaibo.biz.services.impl;

import init.ProductInit;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.gaibo.common.constants.GaiboConstant;
import org.gaibo.common.constants.PayWayMap;
import org.gaibo.common.utils.HttpHelper;
import org.gaibo.common.utils.MD5Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.gaibo.biz.services.IQueryOrderInfo;
import com.gaibo.biz.services.provide.UserMachineProvideSerice;
import com.gaibo.biz.share.vo.JetinnoResultVo;
import com.gaibo.biz.share.vo.OrderInfoDo;
import com.gaibo.biz.share.vo.ResultVo;

@Service
public class QueryOrderInfoImpl implements IQueryOrderInfo {

	private static final Logger logger = LoggerFactory.getLogger(QueryOrderInfoImpl.class);

	// QID：000001~999999 随机数， 6 位长度，这里去100000~199999的随机数
	int QID = RandomUtils.nextInt(100000, 199999);

	String url = GaiboConstant.URL + "/" + GaiboConstant.URI_QUERY + "?";
	
	@Autowired
	private UserMachineProvideSerice userMachineProvideSerice ;
	
	public UserMachineProvideSerice getUserMachineProvideSerice() {
		return userMachineProvideSerice;
	}

	public void setUserMachineProvideSerice(UserMachineProvideSerice userMachineProvideSerice) {
		this.userMachineProvideSerice = userMachineProvideSerice;
	}

	/**
	 * @param startTime yyyyMMddHHmmss
	 * @param endTime yyyyMMddHHmmss
	 * @author sangwenhao
	 * @throws ParseException 
	 * @date 2017年9月27日
	 * @see com.gaibo.biz.services.IQueryOrderInfo#queryOrderInfo(java.lang.String, java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	@Override
	public String queryOrderInfo(String startTime, String endTime,Map<String,Object> map) {
		logger.info("进入service层-queryOrderInfo ......");
		Calendar now = Calendar.getInstance();
		String value = null ;
		ResultVo resultVo = new ResultVo();
		
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			
			Date startDate = sdf.parse(startTime);
			
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate); 
			
			//默认查询当前月的
			//如果是当前月，有时间范围的根据实际范围查询
			int startMoth = (startCalendar.get(Calendar.MONTH)+1) ;
			if((startCalendar.get(Calendar.YEAR) + startMoth) == (now.get(Calendar.YEAR) + now.get(Calendar.MONTH)+1)){
				value = queryOrderBySpecify(startTime, endTime,map);
			}else {
				//根据时间范围查询 startTime所在月份的数据
				String param = startCalendar.get(Calendar.YEAR)+""+(startMoth < 10 ? "0" + (startMoth) : startMoth) ;
				value = queryOrderByHistory(param,map);
			}
			
//			value = "{\"record\":[[33318,\"cash_order\",802,14,\"cash\",\"Wed, 01 Mar 2017 10:28:44 GMT\"],[33318,\"cash_order\",921,123,\"cash\",\"Wed, 01 Mar 2017 10:29:32 GMT\"]],\"status\":\"success\"}";
			
			JetinnoResultVo resultVos = JSON.parseObject(value, JetinnoResultVo.class);
			
			List<OrderInfoDo> results = new ArrayList<OrderInfoDo>();
			/*
			//返回结果有异常--TODO 前端界面配合改造
			if(StringUtils.equals("failed", resultVos.getStatus()) && StringUtils.isNotBlank(resultVos.getMessage())){
				
				resultVo.setIsError("true");
				resultVo.setMessage("服务器出现异常");
				resultVo.setErrorInfo(resultVos.getMessage());
				
				return JSON.toJSONString(resultVo) ;
			}
			*/
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String userName = (String) map.get("userName");
			String selectmachineCode = (String) map.get("selectmachineCode");//前段选择的机器编码默认的时“全部”
			if(StringUtils.isEmpty(selectmachineCode)||"undefined".equals(selectmachineCode)){
				selectmachineCode="ALL";
			}
			List<String> machines = userMachineProvideSerice.findMachineByUser(userName);
			List<String>  machies1 = new ArrayList<String>();
			machies1.add("ALL");
			machies1.addAll(machines);
			resultVo.setMachines(machies1);//机器编码
			/*boolean flag = false ;
			if(StringUtils.equals(userName, GaiboConstant.USERNAME) ){
				flag = true ;
			}*/
			if(resultVos != null && resultVos.getRecord()!= null){
				for(List<String> list : resultVos.getRecord()){
					//过滤用户机器-暂时
				  if(machines.contains(list.get(0))){
					  if(StringUtils.equals("ALL", selectmachineCode)
							 || StringUtils.equals(selectmachineCode, list.get(0))){
						  OrderInfoDo vo = new OrderInfoDo();
						  vo.setMachineNo(list.get(0));
						  vo.setOrderNo(list.get(1));
						  vo.setProductCode(list.get(2));
						  vo.setProductName(ProductInit.getProductInfo(list.get(2)));
						  vo.setPrice(new BigDecimal(StringUtils.defaultString(list.get(3), "-1")).divide(BigDecimal.valueOf(100)).setScale(1,BigDecimal.ROUND_HALF_UP).toPlainString());
						  vo.setPayWay(PayWayMap.getPayWay(list.get(4)));
						  vo.setOrderTime(simpleDateFormat.format(new Date(list.get(5)+"+0800")));
						  results.add(vo) ;
					  }
				}
					
				}
			}
			resultVo.setOrderInfoVos(results);
		} catch (ParseException e) {
			resultVo.setIsError("true");
			resultVo.setMessage("服务器出现异常");
			resultVo.setErrorInfo(e.getMessage());
			e.printStackTrace();
		}
		
		return JSON.toJSONString(resultVo) ;
	}

	@Override
	public String queryOrderByCurrent(Map<String,Object> map) {
		logger.info("进入service层-queryOrderByCurrent ......");
		//用户名
		String userName = (String) map.get("userName");
		//密码
		String password = (String) map.get("password");
		
		// md5校验顺序：QID=100001&USERNAME=user&PASSWORD=password&QLEVEL=CURRENTT
		StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=CURRENT");

		String mac = MD5Utils.getMD5HEX(uri.toString());
		
		uri.append("&MAC=").append(mac) ;
		
		String httpPath = url + uri ;
		
		httpPath.replace("&PASSWORD="+GaiboConstant.PASSWORD, "").intern();
		logger.info(" >>>>>>>>>>>>>>>>url:{}",  httpPath);

		String response = HttpHelper.execute(httpPath);
		
		return response;
	}

	@Override
	public String queryOrderBySpecify(String startTime, String endTime,Map<String,Object> map) {
		logger.info("进入service层-queryOrderBySpecify ......");
		//用户名
		String userName = (String) map.get("userName");
		//密码
		String password = (String) map.get("password");
		
		// QID=100002&QLEVEL=SPECIFY&STARTTIME=20170329000000&ENDTIME=20170329235959&USERNAME=user&MAC=167f80431828fbed670dfa6a7e715b5e
		// md5校验顺序：QID=100002&USERNAME=user&PASSWORD=password&QLEVEL=SPECIFY
		StringBuilder uri = new StringBuilder("QID=").append("100002")
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=SPECIFY");

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac).append("&STARTTIME=").append(startTime)
			.append("&ENDTIME=").append(endTime);
		
		String httpPath = url + uri ;
		
		httpPath.replace("&PASSWORD="+GaiboConstant.PASSWORD, "").intern();
		logger.info(" >>>>>>>>>>>>>>>>url:{}",  httpPath);

		String response = HttpHelper.execute(httpPath);
		
		return response;
	}

	/**
	 * @param month YYYYMM
	 * @author sangwenhao
	 * @date 2017年9月27日
	 * @see com.gaibo.biz.services.IQueryOrderInfo#queryOrderByHistory(java.lang.String)
	 */
	@Override
	public String queryOrderByHistory(String month,Map<String,Object> map) {
		logger.info("进入service层-queryOrderByHistory ......");
		// QID=100003&QLEVEL=HISTORY&USERNAME=user&MONTH=201702&MAC=33a0fd9aa421b45aaafc4a0f39398109
		//用户名
		String userName = (String) map.get("userName");
		//密码
		String password = (String) map.get("password");
		
		// uri路径不能随意拼接
		// md5校验顺序：QID=100003&USERNAME=user&PASSWORD=password&QLEVEL=HISTORY&MONTH=201702
		StringBuilder uri = new StringBuilder("QID=").append(QID)
				.append("&USERNAME=").append(GaiboConstant.USERNAME)
				.append("&PASSWORD=").append(GaiboConstant.PASSWORD)
				.append("&QLEVEL=HISTORY&MONTH=").append(month);

		String mac = MD5Utils.getMD5HEX(uri.toString());

		uri.append("&MAC=").append(mac).append("&MONTH=").append(month) ;

		String httpPath = url + uri ;
		
		httpPath.replace("&PASSWORD="+GaiboConstant.PASSWORD, "").intern();
		logger.info(" >>>>>>>>>>>>>>>>url:{}",  httpPath);

		String response = HttpHelper.execute(httpPath);

		return response;
	}

}
