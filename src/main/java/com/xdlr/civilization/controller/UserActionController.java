package com.xdlr.civilization.controller;

import com.xdlr.civilization.contract.IntegralClient;
import com.xdlr.civilization.service.GlobalVariable;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class UserActionController {

    @Autowired
    IntegralClient integralClient;

    @RequestMapping(value = "/register")
    public UserActionResponse register(@RequestParam(value = "userId") String userId,
                                       @RequestParam(value = "name") String name) {
        int result = integralClient.initUserInfo(userId, name, BigInteger.valueOf(GlobalVariable.INIT_TOKEN));
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
        Tuple3<String,BigInteger,BigInteger> tuple3 = integralClient.queryUserInfo(userId);
        UserInfo userInfo = new UserInfo(tuple3.getValue1(),tuple3.getValue2().intValue(), tuple3.getValue3().intValue());
        return new UserActionResponse(userId, userInfo.getValue(),UserActionResponse.ACTION_TYPE_VENDING_MACHINE,
                userInfo.getUserId() != null );
    }

    @RequestMapping(value = "/updateUserInfo")
    public UserActionResponse update(@RequestParam(value = "userId") String userId ) {
        int result = integralClient.lastEntryTime(userId);
        return new UserActionResponse(userId, 1, UserActionResponse.ACTION_TYPE_UPDATE, result == 1);
    }

}
