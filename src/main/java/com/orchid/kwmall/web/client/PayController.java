package com.orchid.kwmall.web.client;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.orchid.kwmall.utils.AlipayConfig;
import com.orchid.kwmall.domain.Orders;
import com.orchid.kwmall.service.client.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Orchid
 * @data 2020/10/19 --- 14:28
 */
@Controller
@RequestMapping("/payment")
public class PayController {
    @Autowired
    private IOrderService orderService;
    //支付
    @RequestMapping("/pay")
    public void pay(HttpServletRequest request, HttpServletResponse response, Orders orders) {
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id,
                AlipayConfig.merchant_private_key, "json", AlipayConfig.charset,
                AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(AlipayConfig.return_url);
        alipayRequest.setNotifyUrl(AlipayConfig.notify_url);
        try {
            //商户订单号，商户网站订单系统中唯一订单号，必填
            String out_trade_no = new String(request.getParameter("WIDout_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额，必填
            String total_amount = new String(request.getParameter("WIDtotal_amount").getBytes("ISO-8859-1"),"UTF-8");
            //订单名称，必填
            String subject = new String(request.getParameter("WIDsubject").getBytes("ISO-8859-1"),"UTF-8");
            alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no
                    +"\","
                    + "\"total_amount\":\""+ total_amount +"\","
                    + "\"subject\":\""+ subject +"\","
                    + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //若想给BizContent增加其他可选请求参数，以增加自定义超时时间参数timeout_express来举例说明
            //alipayRequest.setBizContent("{\"out_trade_no\":\""+ out_trade_no+"\","
            // + "\"total_amount\":\""+ total_amount +"\","
            // + "\"subject\":\""+ subject +"\","
            // + "\"body\":\""+ body +"\","
            // + "\"timeout_express\":\"10m\","
            // + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
            //请求参数可查阅【电脑网站支付的API文档-alipay.trade.page.pay-请求参数】章节
            //请求
            String result = alipayClient.pageExecute(alipayRequest).getBody();
            //输出
            //设置输出类型
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(result);
            response.getWriter().flush();
            response.getWriter().close();
            //更新订单地址
            orders.setOid(out_trade_no);
            orders.setAddress(request.getParameter("address"));
            orders.setName(request.getParameter("name"));
            orders.setTotal(Double.valueOf(total_amount));
            orders.setTelephone(request.getParameter("telephone"));
            orderService.updateOrdersAddress(orders);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    @RequestMapping("/back")
    //支付成功的回调方法
    public String payCallBack(HttpServletRequest request, HttpServletResponse response , Model model) throws Exception {
        Map<String,String> params = new HashMap<String,String>();
        Map<String,String[]> requestParams = request.getParameterMap();
        for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用
            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        boolean signVerified = AlipaySignature.rsaCheckV1(params, AlipayConfig.alipay_public_key, AlipayConfig.charset, AlipayConfig.sign_type); //调用SDK验证签名
        // 如果签证通过
        if(signVerified) {
            //商户订单号
            String out_trade_no = new String(request.getParameter("out_trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //支付宝交易号
            String trade_no = new String(request.getParameter("trade_no").getBytes("ISO-8859-1"),"UTF-8");
            //付款金额
            String total_amount = new String(request.getParameter("total_amount").getBytes("ISO-8859-1"),"UTF-8");
            //将支付信息放入model
            model.addAttribute("out_trade_no", out_trade_no);
            model.addAttribute("trade_no", trade_no);
            model.addAttribute("total_amount", total_amount);
            //支付成功 更新订单的支付状态
            orderService.updateOrdersState(2, out_trade_no);
        }else {
            model.addAttribute("msg", "交易失败");
        }
        return "paySuccess";
    }
}
