package com.xdlr.civilization.contract;

import org.fisco.bcos.channel.client.TransactionSucCallback;
import org.fisco.bcos.channel.event.filter.EventLogPushWithDecodeCallback;
import org.fisco.bcos.web3j.abi.EventEncoder;
import org.fisco.bcos.web3j.abi.FunctionReturnDecoder;
import org.fisco.bcos.web3j.abi.TypeReference;
import org.fisco.bcos.web3j.abi.datatypes.Event;
import org.fisco.bcos.web3j.abi.datatypes.Function;
import org.fisco.bcos.web3j.abi.datatypes.Type;
import org.fisco.bcos.web3j.abi.datatypes.Utf8String;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint256;
import org.fisco.bcos.web3j.abi.datatypes.generated.Uint32;
import org.fisco.bcos.web3j.crypto.Credentials;
import org.fisco.bcos.web3j.protocol.Web3j;
import org.fisco.bcos.web3j.protocol.core.RemoteCall;
import org.fisco.bcos.web3j.protocol.core.methods.response.Log;
import org.fisco.bcos.web3j.protocol.core.methods.response.TransactionReceipt;
import org.fisco.bcos.web3j.tuples.generated.Tuple1;
import org.fisco.bcos.web3j.tuples.generated.Tuple2;
import org.fisco.bcos.web3j.tuples.generated.Tuple3;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * <p>Auto generated code.
 * <p><strong>Do not modify!</strong>
 * <p>Please use the <a href="https://docs.web3j.io/command_line.html">web3j command line tools</a>,
 * or the org.fisco.bcos.web3j.codegen.SolidityFunctionWrapperGenerator in the 
 * <a href="https://github.com/web3j/web3j/tree/master/codegen">codegen module</a> to update.
 *
 * <p>Generated with web3j version none.
 */
@SuppressWarnings("unchecked")
public class Integral extends Contract {
    public static String BINARY = "608060405234801561001057600080fd5b506113ef806100206000396000f300608060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630feea42914610088578063366389ae146101055780633d5330b3146101d8578063626e0420146102615780637c27c0d8146102ee578063ac1059d0146103ea578063e69d3a8314610477575b600080fd5b34801561009457600080fd5b506100ef600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610570565b6040518082815260200191505060405180910390f35b34801561011157600080fd5b506101c2600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff16906020019092919050505061063a565b6040518082815260200191505060405180910390f35b3480156101e457600080fd5b5061023f600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610963565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b34801561026d57600080fd5b506102d8600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff1690602001909291905050506109ea565b6040518082815260200191505060405180910390f35b3480156102fa57600080fd5b50610355600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506109fe565b60405180806020018481526020018363ffffffff1663ffffffff168152602001828103825285818151815260200191508051906020019080838360005b838110156103ad578082015181840152602081019050610392565b50505050905090810190601f1680156103da5780820380516001836020036101000a031916815260200191505b5094505050505060405180910390f35b3480156103f657600080fd5b50610461600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190505050610c18565b6040518082815260200191505060405180910390f35b34801561048357600080fd5b506104ee600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190505050610c2c565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b83811015610534578082015181840152602081019050610519565b50505050905090810190601f1680156105615780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b60008061057b610dfb565b9050806000846040518082805190602001908083835b6020831015156105b65780518252602082019150602081019050602083039250610591565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002018190555061062f836040805190810160405280601f81526020017f456e746572207468652065786869626974696f6e2068616c6c20616761696e00815250610e08565b506001915050919050565b600080610645610dfb565b905060a0604051908101604052808681526020018581526020018281526020018463ffffffff168152602001600063ffffffff168152506000866040518082805190602001908083835b6020831015156106b4578051825260208201915060208101905060208303925061068f565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600082015181600001908051906020019061070392919061131e565b50602082015181600101908051906020019061072092919061131e565b506040820151816002015560608201518160030160006101000a81548163ffffffff021916908363ffffffff16021790555060808201518160030160046101000a81548163ffffffff021916908363ffffffff1602179055509050506107bb856040805190810160405280600f81526020017f496e697469616c697a6520757365720000000000000000000000000000000000815250610e08565b507f2a5b5b77706d3d14dc9e69a03af86facbd9373687ac9f5fc4dee072cb898bc4a85856000886040518082805190602001908083835b60208310151561081757805182526020820191506020810190506020830392506107f2565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff166040518080602001806020018463ffffffff1663ffffffff168152602001838103835286818151815260200191508051906020019080838360005b838110156108b4578082015181840152602081019050610899565b50505050905090810190601f1680156108e15780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b8381101561091a5780820151818401526020810190506108ff565b50505050905090810190601f1680156109475780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a160019150509392505050565b600080826040518082805190602001908083835b60208310151561099c5780518252602082019150602081019050602083039250610977565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160049054906101000a900463ffffffff169050919050565b60006109f6838361100a565b905092915050565b6060600080600080600080876040518082805190602001908083835b602083101515610a3f5780518252602082019150602081019050602083039250610a1a565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010192506000876040518082805190602001908083835b602083101515610aaf5780518252602082019150602081019050602083039250610a8a565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002015491506000876040518082805190602001908083835b602083101515610b205780518252602082019150602081019050602083039250610afb565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff169050828282828054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610c015780601f10610bd657610100808354040283529160200191610c01565b820191906000526020600020905b815481529060010190602001808311610be457829003601f168201915b505050505092509550955095505050509193909250565b6000610c248383611194565b905092915050565b6060600080846040518082805190602001908083835b602083101515610c675780518252602082019150602081019050602083039250610c42565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060040160008463ffffffff1667ffffffffffffffff1681526020019081526020016000206000016000856040518082805190602001908083835b602083101515610cf95780518252602082019150602081019050602083039250610cd4565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060040160008563ffffffff1667ffffffffffffffff16815260200190815260200160002060010154818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610de95780601f10610dbe57610100808354040283529160200191610de9565b820191906000526020600020905b815481529060010190602001808311610dcc57829003601f168201915b50505050509150915091509250929050565b6000804290508091505090565b600080610e13610dfb565b90506040805190810160405280848152602001828152506000856040518082805190602001908083835b602083101515610e625780518252602082019150602081019050602083039250610e3d565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600401600080876040518082805190602001908083835b602083101515610ed15780518252602082019150602081019050602083039250610eac565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160049054906101000a900463ffffffff1663ffffffff1667ffffffffffffffff1681526020019081526020016000206000820151816000019080519060200190610f5292919061131e565b506020820151816001015590505060016000856040518082805190602001908083835b602083101515610f9a5780518252602082019150602081019050602083039250610f75565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160048282829054906101000a900463ffffffff160192506101000a81548163ffffffff021916908363ffffffff1602179055505092915050565b6000637fffffff826000856040518082805190602001908083835b60208310151561104a5780518252602082019150602081019050602083039250611025565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff160163ffffffff1611156110a7576000905061118e565b816000846040518082805190602001908083835b6020831015156110e057805182526020820191506020810190506020830392506110bb565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282829054906101000a900463ffffffff160192506101000a81548163ffffffff021916908363ffffffff160217905550611188836040805190810160405280600a81526020017f41646420706f696e747300000000000000000000000000000000000000000000815250610e08565b50600190505b92915050565b60008163ffffffff166000846040518082805190602001908083835b6020831015156111d557805182526020820191506020810190506020830392506111b0565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff1663ffffffff1610156112315760009050611318565b816000846040518082805190602001908083835b60208310151561126a5780518252602082019150602081019050602083039250611245565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282829054906101000a900463ffffffff160392506101000a81548163ffffffff021916908363ffffffff160217905550611312836040805190810160405280601281526020017f436f6e73756d7074696f6e20706f696e74730000000000000000000000000000815250610e08565b50600190505b92915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061135f57805160ff191683800117855561138d565b8280016001018555821561138d579182015b8281111561138c578251825591602001919060010190611371565b5b50905061139a919061139e565b5090565b6113c091905b808211156113bc5760008160009055506001016113a4565b5090565b905600a165627a7a72305820c607c1df95927978e6787643863acaf7ac5c52754e8e851f0f83e2fe687fa07e0029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"lastTime\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Name\",\"type\":\"string\"},{\"name\":\"TokenAllValues\",\"type\":\"uint32\"}],\"name\":\"userInit\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"recordNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Value\",\"type\":\"uint32\"}],\"name\":\"throwRubbish\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"infoQuery\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Value\",\"type\":\"uint32\"}],\"name\":\"buyThing\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"num\",\"type\":\"uint32\"}],\"name\":\"recordQuery\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ID\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"Name\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"TokenAllValues\",\"type\":\"uint32\"}],\"name\":\"TestUser\",\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_LASTTIME = "lastTime";

    public static final String FUNC_USERINIT = "userInit";

    public static final String FUNC_RECORDNUM = "recordNum";

    public static final String FUNC_THROWRUBBISH = "throwRubbish";

    public static final String FUNC_INFOQUERY = "infoQuery";

    public static final String FUNC_BUYTHING = "buyThing";

    public static final String FUNC_RECORDQUERY = "recordQuery";

    public static final Event TESTUSER_EVENT = new Event("TestUser", 
            Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}));
    ;

    @Deprecated
    protected Integral(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    protected Integral(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, credentials, contractGasProvider);
    }

    @Deprecated
    protected Integral(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        super(BINARY, contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    protected Integral(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        super(BINARY, contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static TransactionDecoder getTransactionDecoder() {
        return transactionDecoder;
    }

    public RemoteCall<TransactionReceipt> lastTime(String userID) {
        final Function function = new Function(
                FUNC_LASTTIME, 
                Arrays.<Type>asList(new Utf8String(userID)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void lastTime(String userID, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_LASTTIME,
                Arrays.<Type>asList(new Utf8String(userID)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String lastTimeSeq(String userID) {
        final Function function = new Function(
                FUNC_LASTTIME,
                Arrays.<Type>asList(new Utf8String(userID)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple1<String> getLastTimeInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_LASTTIME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<String>(

                (String) results.get(0).getValue()
                );
    }

    public Tuple1<BigInteger> getLastTimeOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_LASTTIME,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<TransactionReceipt> userInit(String userID, String Name, BigInteger TokenAllValues) {
        final Function function = new Function(
                FUNC_USERINIT,
                Arrays.<Type>asList(new Utf8String(userID),
                new Utf8String(Name),
                new Uint32(TokenAllValues)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userInit(String userID, String Name, BigInteger TokenAllValues, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERINIT,
                Arrays.<Type>asList(new Utf8String(userID),
                new Utf8String(Name),
                new Uint32(TokenAllValues)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userInitSeq(String userID, String Name, BigInteger TokenAllValues) {
        final Function function = new Function(
                FUNC_USERINIT,
                Arrays.<Type>asList(new Utf8String(userID),
                new Utf8String(Name),
                new Uint32(TokenAllValues)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple3<String, String, BigInteger> getUserInitInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERINIT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple3<String, String, BigInteger>(

                (String) results.get(0).getValue(),
                (String) results.get(1).getValue(),
                (BigInteger) results.get(2).getValue()
                );
    }

    public Tuple1<BigInteger> getUserInitOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_USERINIT,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<BigInteger> recordNum(String userID) {
        final Function function = new Function(FUNC_RECORDNUM,
                Arrays.<Type>asList(new Utf8String(userID)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> throwRubbish(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_THROWRUBBISH,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void throwRubbish(String userID, BigInteger Value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_THROWRUBBISH,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String throwRubbishSeq(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_THROWRUBBISH,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getThrowRubbishInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_THROWRUBBISH,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getThrowRubbishOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_THROWRUBBISH,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<Tuple3<String, BigInteger, BigInteger>> infoQuery(String userID) {
        final Function function = new Function(FUNC_INFOQUERY,
                Arrays.<Type>asList(new Utf8String(userID)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint32>() {}));
        return new RemoteCall<Tuple3<String, BigInteger, BigInteger>>(
                new Callable<Tuple3<String, BigInteger, BigInteger>>() {
                    @Override
                    public Tuple3<String, BigInteger, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple3<String, BigInteger, BigInteger>(
                                (String) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue(),
                                (BigInteger) results.get(2).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> buyThing(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_BUYTHING,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyThing(String userID, BigInteger Value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYTHING,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String buyThingSeq(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_BUYTHING,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(Value)),
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple2<String, BigInteger> getBuyThingInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_BUYTHING,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple2<String, BigInteger>(

                (String) results.get(0).getValue(),
                (BigInteger) results.get(1).getValue()
                );
    }

    public Tuple1<BigInteger> getBuyThingOutput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getOutput();
        final Function function = new Function(FUNC_BUYTHING,
                Arrays.<Type>asList(),
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint256>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple1<BigInteger>(

                (BigInteger) results.get(0).getValue()
                );
    }

    public RemoteCall<Tuple2<String, BigInteger>> recordQuery(String userID, BigInteger num) {
        final Function function = new Function(FUNC_RECORDQUERY,
                Arrays.<Type>asList(new Utf8String(userID),
                new Uint32(num)),
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}));
        return new RemoteCall<Tuple2<String, BigInteger>>(
                new Callable<Tuple2<String, BigInteger>>() {
                    @Override
                    public Tuple2<String, BigInteger> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple2<String, BigInteger>(
                                (String) results.get(0).getValue(),
                                (BigInteger) results.get(1).getValue());
                    }
                });
    }

    public List<TestUserEventResponse> getTestUserEvents(TransactionReceipt transactionReceipt) {
        List<EventValuesWithLog> valueList = extractEventParametersWithLog(TESTUSER_EVENT, transactionReceipt);
        ArrayList<TestUserEventResponse> responses = new ArrayList<TestUserEventResponse>(valueList.size());
        for (EventValuesWithLog eventValues : valueList) {
            TestUserEventResponse typedResponse = new TestUserEventResponse();
            typedResponse.log = eventValues.getLog();
            typedResponse.ID = (String) eventValues.getNonIndexedValues().get(0).getValue();
            typedResponse.Name = (String) eventValues.getNonIndexedValues().get(1).getValue();
            typedResponse.TokenAllValues = (BigInteger) eventValues.getNonIndexedValues().get(2).getValue();
            responses.add(typedResponse);
        }
        return responses;
    }

    public void registerTestUserEventLogFilter(String fromBlock, String toBlock, List<String> otherTopcs, EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TESTUSER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,fromBlock,toBlock,otherTopcs,callback);
    }

    public void registerTestUserEventLogFilter(EventLogPushWithDecodeCallback callback) {
        String topic0 = EventEncoder.encode(TESTUSER_EVENT);
        registerEventLogPushFilter(ABI,BINARY,topic0,callback);
    }

    @Deprecated
    public static Integral load(String contractAddress, Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractAddress, web3j, credentials, gasPrice, gasLimit);
    }

    @Deprecated
    public static Integral load(String contractAddress, Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return new Integral(contractAddress, web3j, transactionManager, gasPrice, gasLimit);
    }

    public static Integral load(String contractAddress, Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return new Integral(contractAddress, web3j, credentials, contractGasProvider);
    }

    public static Integral load(String contractAddress, Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return new Integral(contractAddress, web3j, transactionManager, contractGasProvider);
    }

    public static RemoteCall<Integral> deploy(Web3j web3j, Credentials credentials, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Integral.class, web3j, credentials, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Integral> deploy(Web3j web3j, Credentials credentials, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Integral.class, web3j, credentials, gasPrice, gasLimit, BINARY, "");
    }

    public static RemoteCall<Integral> deploy(Web3j web3j, TransactionManager transactionManager, ContractGasProvider contractGasProvider) {
        return deployRemoteCall(Integral.class, web3j, transactionManager, contractGasProvider, BINARY, "");
    }

    @Deprecated
    public static RemoteCall<Integral> deploy(Web3j web3j, TransactionManager transactionManager, BigInteger gasPrice, BigInteger gasLimit) {
        return deployRemoteCall(Integral.class, web3j, transactionManager, gasPrice, gasLimit, BINARY, "");
    }

    public static class TestUserEventResponse {
        public Log log;

        public String ID;

        public String Name;

        public BigInteger TokenAllValues;
    }
}
