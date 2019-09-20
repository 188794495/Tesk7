//package com.controller;
//
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import javax.servlet.http.HttpSession;
//
//public class JsonCrudModel<T> {
//
//    @RequestMapping("yanzhengma")
//    @ResponseBody
//    public JsonCrudModel<Object> begin(HttpSession session, String yzm) {
//
//        final JsonCrudModel<Object> json = new JsonCrudModel<Object>();
//
//        String yzm1 = (String) session.getAttribute("yzm");
//        if (yzm != null && yzm1 != null) {
//            if (yzm.equals(yzm1)) {
//                json.setMessage("success");
//            } else {
//                json.setMessage("error");
//            }
//        } else {
//            json.setMessage("error");
//        }
//
//        return json;
//
//    }
//}