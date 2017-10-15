package init;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.gaibo.biz.server.IProductService;
import com.gaibo.biz.server.IWarningServer;
import com.gaibo.biz.share.vo.Product;
import com.gaibo.biz.share.vo.WarningFromDb;

public class ProductInit implements InitializingBean{
	
	@Autowired
	private IProductService productService;
	@Autowired
	private IWarningServer  warningServer;
	
	public static Map<String,String> productInfoMap = new HashMap<String,String>();
	public static Map<String,String> warningInfoMap = new HashMap<String,String>();
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		List<Product> list = productService.queryProductList();
		for(Product product : list){
			productInfoMap.put(product.getProductCode(), product.getProductChineseName());
		}
		
		List<WarningFromDb> queryWarning = warningServer.queryWarning();
		
		for(WarningFromDb dto:queryWarning){
			warningInfoMap.put(dto.getWarningId(), dto.getWarningChinese());
		}
	}
	
	public static String getProductInfo(String key){
		String productInfo = productInfoMap.get(key);
		if(StringUtils.isBlank(productInfo)){
			productInfo = key ;
		}
		return productInfo ;
	}
	
	public static String getWarningInfo(String key){
		String warning = warningInfoMap.get(key);
		return warning;
	}
}
