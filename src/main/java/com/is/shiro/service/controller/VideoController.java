package com.is.shiro.service.controller;


import com.is.shiro.service.msg.JsonData;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("video")
public class VideoController {


    @RequestMapping("/LogoutController")
    public JsonData updateVideo(){
        return JsonData.buildSuccess("video更新成功");

    }

}
