package com.controller;


import com.aliyun.OSSClientUtil;
import com.cloopen.rest.sdk.CCPRestSDK;
import com.pojo.User;
import com.service.UserService;
import com.utils.DesUtils;
import com.utils.MD5Utils;
import com.utils.Randomutil;
import com.utils.SendEmail;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import static com.aliyun.OSSClientConstants.*;

/**
 * @author Administrator
 */
@RequestMapping("")
@Controller

public class SDKTestSendTemplateSMS  {

    Logger logger = (Logger) Logger.getLogger(String.valueOf(SDKTestSendTemplateSMS.class));
    @Resource
    private UserService userService;

    @RequestMapping(value = "/email", method = RequestMethod.GET)
    public String email(){
        return "email";
    }
    @RequestMapping(value = "/getEmail", method = RequestMethod.POST)
    public String getEmail(@RequestParam(value = "email", required = false) String email,
                        String emailCode,HttpSession session){
        SendEmail sendEmail=new SendEmail();
        Randomutil randomutil=new Randomutil();

        emailCode= Randomutil.getRandom();
        session.setAttribute("emailCode", emailCode);
        try {
            sendEmail.sendingEmail(email,emailCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "registerEmail";
    }
    /**
     * 判断验证码的正确性以及注册
     * @param name
     * @param pwd
     * @param emailCode
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/registEmail", method = RequestMethod.POST)
    public String regist(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "pwd", required = false) String pwd,
                           @RequestParam(value = "pwd1", required = false) String pwd1,
                           @RequestParam(value = "emailCode", required = false) String emailCode,
                           @RequestParam(value = "email", required = false) String email,

                           HttpSession session,
                           Model model
    ) throws Exception {

        if (!pwd.equals(pwd1)){
            model.addAttribute("error","两次密码不一致");
            return "registerEmail";
        }
        User user = new User();
        DesUtils des = new DesUtils();
        MD5Utils md = new MD5Utils();
        user.setName(name);
        user.setEmail(email);
        user.setPwd(md.getMD5Code(pwd));
        String  emailCode1 = (String) session.getAttribute("emailCode");

        logger.info("emailCode:"+emailCode);
        logger.info("emailCode1:"+emailCode1);
        if (emailCode!=null && emailCode1!=null){
            if (emailCode.equals(emailCode1)){
                if (userService.selectByName(name)==null){
                    if (userService.selectByEmail(email)==null){
                        userService.register(user);
                        logger.info("注册成功，注册的用户名为："+name+","+"密码为："+pwd+","+"手机号为"+email);
                        return "success";
                    }else {
                        model.addAttribute("error","邮箱已被注册");
                    }
                }else {
                    model.addAttribute("error","用户名已经存在");
                    return "registerEmail";
                }
            }else {
                model.addAttribute("error","验证码错误");
            }
        }else {
            model.addAttribute("error","验证码不能为空");
        }
        return "registerEmail";
    }



    /**
     * 实现验证码的发送
     * @param session
     * @return
     */
    @RequestMapping(value = "/getYzm", method = RequestMethod.POST)
    public String yzm(HttpSession session){

            HashMap<String,Object> result=null;
            //初始化SDK
            CCPRestSDK restAPI =new CCPRestSDK();
            restAPI.init("app.cloopen.com", "8883");
            restAPI.setAccount(
                    "8aaf07086cdb49dc016cddcc60260288","b12981a35fc145638c12c117f67a5648");
            restAPI.setAppId("8aaf07086cdb49dc016cddcc607b028e");

            //用随机数当验证码
            int mobile_code = (int) ((Math.random()*9+1)*100000);
            String yzm = String.valueOf(mobile_code);
            //	第一个参数是手机号，第二个参数是你是用的第几个模板，第三个参数是你的验证码，第四个是在几分钟之内输入有效
            result =restAPI.sendTemplateSMS("13273804671","1" ,new String[]{yzm,"10"});
            session.setAttribute("yzm", yzm);
            logger.info("SDKTestGetSubAccounts result=" + result);

            if("000000".equals(result.get("statusCode"))){
                //正常返回输出data包体信息（map）
                HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
                Set<String> keySet = data.keySet();
                for(String key:keySet){
                    Object object = data.get(key);
                    logger.info(key +" = "+object);
                }
            }else{
                //异常返回输出错误码和错误信息
                logger.info("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
            }
            return "register";
    }


    /**
     * 判断验证码的正确性以及注册
     * @param name
     * @param pwd
     * @param yzm
     * @param session
     * @param model
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String register(@RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "pwd", required = false) String pwd,
                           @RequestParam(value = "pwd1", required = false) String pwd1,
                           @RequestParam(value = "yzm", required = false) String yzm,
                           @RequestParam(value = "phone", required = false) String phone,
                           @RequestParam("file") MultipartFile file,
                           HttpSession session,
                           Model model
    ) throws Exception {
        OSSClientUtil ossClient = new OSSClientUtil();
        String url = ossClient.uploadImg2Oss(file);
        logger.info("url"+url);
        String picture="http://"+BACKET_NAME+"."+ENDPOINT+"/"+FOLDER+url;
        logger.info(picture);
        if (!pwd.equals(pwd1)){
            model.addAttribute("error","两次密码不一致");
            return "register";
        }
        User user = new User();
        DesUtils des = new DesUtils();
        MD5Utils md = new MD5Utils();
        user.setPicture(picture);
        user.setName(name);
        user.setPhone(phone);
        user.setPwd(md.getMD5Code(pwd));
        String  yzm1 = (String) session.getAttribute("yzm");

        logger.info("yzm:"+yzm);
        logger.info("yzm1:"+yzm1);
        if (yzm!=null && yzm1!=null){
            if (yzm.equals(yzm1)){
                if (userService.selectByName(name)==null){
                    if (userService.selectByPhone(phone)==null){
                        userService.register(user);
                        logger.info("注册成功，注册的用户名为："+name+","+"密码为："+pwd+","+"手机号为"+phone);
                        return "success";
                    }else {
                        model.addAttribute("error","手机号已被注册");
                    }
                }else {
                    model.addAttribute("error","用户名已经存在");
                    return "register";
                }
            }else {
                model.addAttribute("error","验证码错误");
            }
        }else {
            model.addAttribute("error","验证码不能为空");
        }
        return "register";
    }


    @RequestMapping(value = "/headImgUpload", produces = "text/html;charset=UTF-8")
    public String headImgUpload(HttpServletRequest request, MultipartFile file) {
        Map<String, Object> value = new HashMap<String, Object>();
        try {
            String url = userService.updateHead(file);
            logger.info("图片路径{}"+url);
            value.put("data", url);
            value.put("code", 0);
            value.put("msg", "图片上传成功");
        } catch (Exception e) {
            e.printStackTrace();
            value.put("code", 2000);
            value.put("msg", "图片上传成功");
        }
        return null;
    }







}
