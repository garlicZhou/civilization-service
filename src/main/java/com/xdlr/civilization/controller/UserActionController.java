package com.xdlr.civilization.controller;

import com.xdlr.civilization.contract.IntegralClient;
import com.xdlr.civilization.autoconfigure.VendingServerConfig;
import com.xdlr.civilization.utils.Base64ImageUtils;
import com.xdlr.civilization.utils.GlobalVariable;
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserActionController {

    @Autowired
    IntegralClient integralClient;

    @Autowired
    VendingServerConfig.VendingServer vendingServer;

    @RequestMapping(value = "/register")
    public UserActionResponse register(@RequestParam(value = "userId") String userId,
                                       @RequestParam(value = "name") String name,
                                       @RequestParam(value = "userImg") String userImg) {
        int result = integralClient.initUserInfo(userId, name, BigInteger.valueOf(GlobalVariable.INIT_TOKEN),userImg);
        userImg = userId.replaceAll(" ", "+");
        Base64ToImg(userImg,userId);
        return new UserActionResponse(userId, GlobalVariable.INIT_TOKEN, UserActionResponse.ACTION_TYPE_REGISTER, result == 1);
    }

    @RequestMapping(value = "/openCan")
    public UserActionResponse throwRubbish(@RequestParam(value = "userId") String userId){
        int result = integralClient.throwRubbish(userId, BigInteger.valueOf(GlobalVariable.TOKEN_AWARD_PER_PHOTO));
        return new UserActionResponse(userId, GlobalVariable.TOKEN_AWARD_PER_PHOTO, UserActionResponse.ACTION_TYPE_GARBAGE, result == 1);
    }

    @RequestMapping(value = "/vending")
    public UserActionResponse vending(
            @RequestParam(value = "userId") String userId,
            @RequestParam(value = "value") int value) {
        int result = integralClient.buyThing(userId, BigInteger.valueOf(value));
        return new UserActionResponse(userId, value, UserActionResponse.ACTION_TYPE_VENDING_MACHINE, result == 1);
    }

    @RequestMapping("/renderingUserInfo")
    public UserActionResponse renderingUserInfo(@RequestParam(value = "userId" ) String userId) throws Exception {
        Tuple4<String,BigInteger,BigInteger,String> tuple4 = integralClient.queryUserInfo(userId);
//        UserInfo userInfo = new UserInfo(tuple4.getValue1(),tuple4.getValue2().intValue(), tuple4.getValue3().intValue()
        double value = Math.random()*10000;
        UserInfo userInfo = new UserInfo(tuple4.getValue1(),tuple4.getValue2().intValue(), new Double(value).intValue()
        ,tuple4.getValue4());

        vendingServer.sendUserInfo(userInfo);
        System.out.println(userInfo.toString());
        return new UserActionResponse(userId, userInfo.getValue(),UserActionResponse.ACTION_TYPE_VENDING_MACHINE,
                userInfo.getUserId() != null );
    }

    @RequestMapping(value = "/updateUserInfo")
    public UserActionResponse update(@RequestParam(value = "userId") String userId ) {
        int result = integralClient.lastEntryTime(userId);
        return new UserActionResponse(userId, 1, UserActionResponse.ACTION_TYPE_UPDATE, result == 1);
    }

//    @RequestMapping(value = "/queryAllUserInfo")
//    public List<UserInfo> queryAllUserInfo(){
//
//    }

    private String Base64ToImg(String base64, String uid) {
        String path = "images/" + new SimpleDateFormat("yyyyMMdd").format(new Date()) + "/" + uid + ".jpg";
        Base64ImageUtils.Base64ToImage(base64, path);
        return path;
    }


}
