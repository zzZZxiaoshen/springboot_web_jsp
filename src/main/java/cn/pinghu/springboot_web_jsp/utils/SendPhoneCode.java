package cn.pinghu.springboot_web_jsp.utils;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

/**
 * 发送验证码调用服务
 * @author shenkai
 * @date 2018/12/28
 */
public class SendPhoneCode {

    final String product = "Dysmsapi";
    final String domain = "dysmsapi.aliyuncs.com";
    /**
    * 账号id
    */
    final String accessKeyId = "LTAIr1bMGmMSHYD6";
    /**
    * 账号密码
    */
    final String accessKeySecret = "IOWDryFKraqT9x6EsJMNE4UwfRqvO3";
    /**
    * 模板签名
    */
    private String signName ="沈凯";
    /**
    *模板名称
    */
    private String templateCode="SMS_139982415";

    public  String sendCode(String phone,String date) throws ClientException {
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
        IAcsClient acsClient = new DefaultAcsClient(profile);
        SendSmsRequest request = new SendSmsRequest();
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(phone);
        request.setSignName(signName);
        request.setTemplateCode(templateCode);
        request.setTemplateParam("{'code':'"+date+"'}");
        request.setOutId("yourOutId");
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
        return sendSmsResponse.getMessage();
    }

}
