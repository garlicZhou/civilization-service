package com.xdlr.civilization.contract;

import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.gas.StaticGasProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Properties;

@Component
public class IntegralClient {
    static Logger logger = LoggerFactory.getLogger(IntegralClient.class);
    static String contractAddress = "0x0a52b405bba05d46f32fa03fb8bc8c99053c97f6";

    @Autowired
    private Web3j web3j;
    @Autowired
    private Credentials credentials;

    private static BigInteger gasPrice = new BigInteger("30000000");
    private static BigInteger gasLimit = new BigInteger("30000000");

    public void recordAssetAddr(String address) throws FileNotFoundException, IOException {
        Properties prop = new Properties();
        prop.setProperty("address", address);
        final Resource contractResource = new ClassPathResource("contract.properties");
        FileOutputStream fileOutputStream = new FileOutputStream(contractResource.getFile());
        prop.store(fileOutputStream, "contract address");
    }

    public String loadAssetAddr() throws Exception {
        // load Asset contact address from contract.properties
        Properties prop = new Properties();
        final Resource contractResource = new ClassPathResource("contract.properties");
        prop.load(contractResource.getInputStream());

        String contractAddress = prop.getProperty("address");
        if (contractAddress == null || contractAddress.trim().equals("")) {
            throw new Exception(" load Asset contract address failed, please deploy it first. ");
        }
        logger.info(" load Asset address from contract.properties, address is {}", contractAddress);
        return contractAddress;
    }

    public void deployIntegralAndRecordAddr() {
        System.out.println(" deploy  start ..... \n");
        try {
            Integral asset = Integral.deploy(web3j, credentials, new StaticGasProvider(gasPrice, gasLimit)).send();
            System.out.println(" deploy Integral success, contract address is " + asset.getContractAddress());
            recordAssetAddr(asset.getContractAddress());
        } catch (Exception e) {
            System.out.println(" deploy Integral contract failed, error message is  " + e.getMessage());
        }
    }

    public int initUserInfo(String userID, String Name, BigInteger TokenAllValues) {
        try {
            logger.info("contractAddress: " + contractAddress + " web3j: " + web3j + " credentials:" + credentials);
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            TransactionReceipt result = integral.userInit(userID, Name, TokenAllValues).send();
            System.out.printf("init user info success\n");
            System.out.printf("TransactionReceipt is" + result);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(" initUserInfo exception, error message is {}", e.getMessage());
            return 0;
        }
    }

    public int lastEntryTime(String userID) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            TransactionReceipt result = integral.lastTime(userID).send();
            System.out.printf("update user time success\n");
            return 1;
        } catch (Exception e) {
            logger.error(" queryAssetAmount exception, error message is {}", e.getMessage());
            System.out.printf(" query asset account failed, error message is %s\n", e.getMessage());
            return 0;
        }
    }

    public int throwRubbish(String userID, BigInteger value) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            TransactionReceipt result = integral.throwRubbish(userID, value).send();
            logger.info("throw Rubbish success\n");
            return 1;
        } catch (Exception e) {
            logger.error(" throwRubbish exception, error message is {}", e.getMessage());
            System.out.printf(" throwRubbish failed, error message is %s\n", e.getMessage());
            return 0;
        }
    }

    public int buyThing(String userID, BigInteger value) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            TransactionReceipt result = integral.buyThing(userID, value).send();
            System.out.printf("buy thing success\n");
            System.out.printf("TransactionReceipt is " + result.getOutput());
            if (result.getOutput().equals("0x0000000000000000000000000000000000000000000000000000000000000000"))
                return 0;
            else
                return 1;
        } catch (Exception e) {
            logger.error(" buy thing exception, error message is {}", e.getMessage());

            System.out.printf(" buy thing failed, error message is %s\n", e.getMessage());
            return 0;
        }
    }

    public Tuple3 queryUserInfo(String userID) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            Tuple3<String, BigInteger, BigInteger> result = integral.infoQuery(userID).send();
            if (!result.getValue1().isEmpty()) {
                System.out.printf(" Name is %s, last time enter room is %s , TokenAllValues is %s \n", result.getValue1(), result.getValue2(), result.getValue3());
            } else {
                System.out.printf(" %s  account is not exist \n", userID);
            }
            return result;
        } catch (Exception e) {
            logger.error(" queryAssetAmount exception, error message is {}", e.getMessage());
            System.out.printf(" query asset account failed, error message is %s\n", e.getMessage());
            return new Tuple3(-1, -1, -1);
        }
    }

    public BigInteger queryRecordNum(String userID) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            BigInteger recordNum = integral.recordNum(userID).send();
            System.out.printf("record counts is " + recordNum + "\n");
            return recordNum;
        } catch (Exception e) {
            logger.error(" query Record Num exception, error message is {}", e.getMessage());
            System.out.printf("query Record Num failed, error message is %s\n", e.getMessage());
            return new BigInteger(String.valueOf(-1));
        }
    }

    public Tuple2 queryRecord(String userID, BigInteger num) {
        try {
            Integral integral = Integral.load(contractAddress, web3j, credentials, new StaticGasProvider(gasPrice, gasLimit));
            Tuple2<String, BigInteger> result = integral.recordQuery(userID, num).send();
            System.out.printf(" record is %s, record`s time is %s .\n", result.getValue1(), result.getValue2());
            return result;
        } catch (Exception e) {
            logger.error(" query Record Num exception, error message is {}", e.getMessage());
            System.out.printf("query Record Num failed, error message is %s\n", e.getMessage());
            return new Tuple2(-1, -1);
        }
    }
}
