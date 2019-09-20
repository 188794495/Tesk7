package com.controller;

import com.aliyun.AliyunOSSClientUtil;
import com.aliyun.OSSClientConstants;
import com.aliyun.OSSClientUtil;
import com.aliyun.oss.OSSClient;
import com.pojo.User;
import com.service.UserService;
import com.utils.DesUtils;
import com.utils.JwtUtil;
import com.utils.MD5Utils;
import com.utils.QiniuCloudUtil;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

import static com.aliyun.OSSClientConstants.*;

/**
 * @author Administrator
 */
@Controller
@RequestMapping("")
public class UserController {

    Logger logger = Logger.getLogger(UserController.class);
    @Resource
    private UserService userService;

    /**
     * 注册页面的controller
     *
     * @return
     */


    /**
     * 转向注册页面
     */
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    /**
     * 转向头像页面
     */
    @RequestMapping("/picture")
    public String picture() {
        return "picture";
    }


    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    @ResponseBody
    public ResultInfo uploadImg(@RequestParam MultipartFile file, HttpServletRequest request) {
        ResultInfo result = new ResultInfo();
        if (file.isEmpty()) {
            result.setCode(400);
            result.setMsg("文件为空，请重新上传");
            return result;
        }else {

        try {
            byte[] bytes = file.getBytes();
            String imageName = UUID.randomUUID().toString();

            QiniuCloudUtil qiniuUtil = new QiniuCloudUtil();
            try {
                //使用base64方式上传到七牛云
                String url = qiniuUtil.put64image(bytes, imageName);
                result.setCode(200);
                result.setMsg("文件上传成功");
                result.setInfo(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return result;
        } catch (IOException e) {
            result.setCode(500);
            result.setMsg("文件上传发生异常！");
            return result;
        }
        }
    }




    /**
     * 转向登录页面
     */
    @RequestMapping("/user")
    public String login() {
        return "user";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)

    public String login(@RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "pwd", required = false) String pwd,
                        HttpServletRequest request,
                        HttpServletResponse response,
                        Model model) throws Exception {
        DesUtils des = new DesUtils();
        MD5Utils md = new MD5Utils();
        User user = userService.loginCheck(name, md.getMD5Code(pwd));
        if (name.isEmpty()) {
            model.addAttribute("error", "用户名不能为空");
            return "user";
        }
        if (pwd.isEmpty()) {
            model.addAttribute("error", "密码不能为空");
            return "user";
        }
        if (user != null) {
            HttpSession session = request.getSession(true);
            session.setMaxInactiveInterval(24*60*60);
            logger.info("登陆成功");
            String token = JwtUtil.createToken(user.getId());
            logger.info(String.valueOf(user.getId() + System.currentTimeMillis()));
            logger.info("token=" + token);
            Cookie cookie = new Cookie("token",session.getId());
            cookie.setPath("/");
            //有效期单位为秒
            cookie.setMaxAge(24*60*60);
            response.addCookie(cookie);
            //将数据存储到session中
            session.setAttribute("user", user);
            return "home";
        } else {
            logger.info("登陆失败");
            model.addAttribute("error", "请输入正确的用户名和密码");
            return "user";
        }
    }
//    public String login(@RequestParam(value = "message", required = false) String message,
//                        @RequestParam(value = "pwd", required = false) String pwd,
//                        HttpServletRequest request,
//                        HttpServletResponse response,
//                        Model model) throws Exception {
//        DesUtils des = new DesUtils();
//        MD5Utils md = new MD5Utils();
//
//        if (message.isEmpty()) {
//            model.addAttribute("error", "用户名不能为空");
//            return "user";
//        }
//        if (pwd.isEmpty()) {
//            model.addAttribute("error", "密码不能为空");
//            return "user";
//        }
//        else{
//            String mobileRegex = "^1(3|4|5|7|8|9)\\d{9}$";
//            String emailRegex = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
//            User user=null;
//            user.setPwd(md.getMD5Code(pwd));
//            if (message.matches(mobileRegex)) {
//                user.setPhone(message);
//            } else {
//                if (message.matches(emailRegex)) {
//                    user.setEmail(message);
//                } else {
//                    user.setName(message);
//                }
//            }
//            User user1=userService.loginCheck1(user);
//        if (user1!= null) {
//            HttpSession session = request.getSession(true);
//            session.setMaxInactiveInterval(24*60*60);
//            logger.info("登陆成功");
//            String token = JwtUtil.createToken(user.getId());
//            logger.info(String.valueOf(user.getId() + System.currentTimeMillis()));
//            logger.info("token=" + token);
//            Cookie cookie = new Cookie("token",session.getId());
//            cookie.setPath("/");
//            //有效期单位为秒
//            cookie.setMaxAge(24*60*60);
//            response.addCookie(cookie);
//            //将数据存储到session中
//            session.setAttribute("user", user);
//            return "home";
//        } else {
//            logger.info("登陆失败");
//            model.addAttribute("error", "请输入正确的用户名和密码");
//            return "user";
//        }
//        }


    /**
     * 用户退出
     */

    @RequestMapping(value = "/outLogin", method = RequestMethod.GET)
    public String outLogin(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    logger.info("开始清理");
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    request.getSession().removeAttribute("user");
                }
            }
        }
        return "user";
    }
}