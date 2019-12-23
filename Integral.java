package civilizaition;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Callable;
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
import org.fisco.bcos.web3j.tuples.generated.Tuple4;
import org.fisco.bcos.web3j.tx.Contract;
import org.fisco.bcos.web3j.tx.TransactionManager;
import org.fisco.bcos.web3j.tx.gas.ContractGasProvider;
import org.fisco.bcos.web3j.tx.txdecode.TransactionDecoder;

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
    public static String BINARY = "608060405234801561001057600080fd5b506115d9806100206000396000f300608060405260043610610083576000357c0100000000000000000000000000000000000000000000000000000000900463ffffffff1680630feea429146100885780633d5330b314610105578063626e04201461018e5780637c27c0d81461021b578063a358b39a14610383578063ac1059d01461049c578063e69d3a8314610529575b600080fd5b34801561009457600080fd5b506100ef600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610622565b6040518082815260200191505060405180910390f35b34801561011157600080fd5b5061016c600480360381019080803590602001908201803590602001908080601f01602080910402602001604051908101604052809392919081815260200183838082843782019150505050505091929192905050506106ec565b604051808263ffffffff1663ffffffff16815260200191505060405180910390f35b34801561019a57600080fd5b50610205600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190505050610773565b6040518082815260200191505060405180910390f35b34801561022757600080fd5b50610282600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610787565b60405180806020018581526020018463ffffffff1663ffffffff16815260200180602001838103835287818151815260200191508051906020019080838360005b838110156102de5780820151818401526020810190506102c3565b50505050905090810190601f16801561030b5780820380516001836020036101000a031916815260200191505b50838103825284818151815260200191508051906020019080838360005b83811015610344578082015181840152602081019050610329565b50505050905090810190601f1680156103715780820380516001836020036101000a031916815260200191505b50965050505050505060405180910390f35b34801561038f57600080fd5b50610486600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290505050610ab5565b6040518082815260200191505060405180910390f35b3480156104a857600080fd5b50610513600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190505050610e02565b6040518082815260200191505060405180910390f35b34801561053557600080fd5b506105a0600480360381019080803590602001908201803590602001908080601f0160208091040260200160405190810160405280939291908181526020018383808284378201915050505050509192919290803563ffffffff169060200190929190505050610e16565b6040518080602001838152602001828103825284818151815260200191508051906020019080838360005b838110156105e65780820151818401526020810190506105cb565b50505050905090810190601f1680156106135780820380516001836020036101000a031916815260200191505b50935050505060405180910390f35b60008061062d610fe5565b9050806000846040518082805190602001908083835b6020831015156106685780518252602082019150602081019050602083039250610643565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600201819055506106e1836040805190810160405280601f81526020017f456e746572207468652065786869626974696f6e2068616c6c20616761696e00815250610ff2565b506001915050919050565b600080826040518082805190602001908083835b6020831015156107255780518252602082019150602081019050602083039250610700565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160049054906101000a900463ffffffff169050919050565b600061077f83836111f4565b905092915050565b606060008060606000806000806000896040518082805190602001908083835b6020831015156107cc57805182526020820191506020810190506020830392506107a7565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060010193506000896040518082805190602001908083835b60208310151561083c5780518252602082019150602081019050602083039250610817565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206002015492506000896040518082805190602001908083835b6020831015156108ad5780518252602082019150602081019050602083039250610888565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff1691506000896040518082805190602001908083835b60208310151561092e5780518252602082019150602081019050602083039250610909565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600401905083838383838054600181600116156101000203166002900480601f0160208091040260200160405190810160405280929190818152602001828054600181600116156101000203166002900480156109ff5780601f106109d4576101008083540402835291602001916109ff565b820191906000526020600020905b8154815290600101906020018083116109e257829003601f168201915b50505050509350808054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610a9b5780601f10610a7057610100808354040283529160200191610a9b565b820191906000526020600020905b815481529060010190602001808311610a7e57829003601f168201915b505050505090509750975097509750505050509193509193565b600080610ac0610fe5565b905060c0604051908101604052808781526020018681526020018281526020018563ffffffff168152602001600063ffffffff168152602001848152506000876040518082805190602001908083835b602083101515610b355780518252602082019150602081019050602083039250610b10565b6001836020036101000a03801982511681845116808217855250505050505090500191505090815260200160405180910390206000820151816000019080519060200190610b84929190611508565b506020820151816001019080519060200190610ba1929190611508565b506040820151816002015560608201518160030160006101000a81548163ffffffff021916908363ffffffff16021790555060808201518160030160046101000a81548163ffffffff021916908363ffffffff16021790555060a0820151816004019080519060200190610c16929190611508565b50905050610c59866040805190810160405280600f81526020017f496e697469616c697a6520757365720000000000000000000000000000000000815250610ff2565b507f2a5b5b77706d3d14dc9e69a03af86facbd9373687ac9f5fc4dee072cb898bc4a86866000896040518082805190602001908083835b602083101515610cb55780518252602082019150602081019050602083039250610c90565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff166040518080602001806020018463ffffffff1663ffffffff168152602001838103835286818151815260200191508051906020019080838360005b83811015610d52578082015181840152602081019050610d37565b50505050905090810190601f168015610d7f5780820380516001836020036101000a031916815260200191505b50838103825285818151815260200191508051906020019080838360005b83811015610db8578082015181840152602081019050610d9d565b50505050905090810190601f168015610de55780820380516001836020036101000a031916815260200191505b509550505050505060405180910390a16001915050949350505050565b6000610e0e838361137e565b905092915050565b6060600080846040518082805190602001908083835b602083101515610e515780518252602082019150602081019050602083039250610e2c565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060050160008463ffffffff1667ffffffffffffffff1681526020019081526020016000206000016000856040518082805190602001908083835b602083101515610ee35780518252602082019150602081019050602083039250610ebe565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060050160008563ffffffff1667ffffffffffffffff16815260200190815260200160002060010154818054600181600116156101000203166002900480601f016020809104026020016040519081016040528092919081815260200182805460018160011615610100020316600290048015610fd35780601f10610fa857610100808354040283529160200191610fd3565b820191906000526020600020905b815481529060010190602001808311610fb657829003601f168201915b50505050509150915091509250929050565b6000804290508091505090565b600080610ffd610fe5565b90506040805190810160405280848152602001828152506000856040518082805190602001908083835b60208310151561104c5780518252602082019150602081019050602083039250611027565b6001836020036101000a0380198251168184511680821785525050505050509050019150509081526020016040518091039020600501600080876040518082805190602001908083835b6020831015156110bb5780518252602082019150602081019050602083039250611096565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160049054906101000a900463ffffffff1663ffffffff1667ffffffffffffffff168152602001908152602001600020600082015181600001908051906020019061113c929190611508565b506020820151816001015590505060016000856040518082805190602001908083835b602083101515611184578051825260208201915060208101905060208303925061115f565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160048282829054906101000a900463ffffffff160192506101000a81548163ffffffff021916908363ffffffff1602179055505092915050565b6000637fffffff826000856040518082805190602001908083835b602083101515611234578051825260208201915060208101905060208303925061120f565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff160163ffffffff1611156112915760009050611378565b816000846040518082805190602001908083835b6020831015156112ca57805182526020820191506020810190506020830392506112a5565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282829054906101000a900463ffffffff160192506101000a81548163ffffffff021916908363ffffffff160217905550611372836040805190810160405280600a81526020017f41646420706f696e747300000000000000000000000000000000000000000000815250610ff2565b50600190505b92915050565b60008163ffffffff166000846040518082805190602001908083835b6020831015156113bf578051825260208201915060208101905060208303925061139a565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160009054906101000a900463ffffffff1663ffffffff16101561141b5760009050611502565b816000846040518082805190602001908083835b602083101515611454578051825260208201915060208101905060208303925061142f565b6001836020036101000a038019825116818451168082178552505050505050905001915050908152602001604051809103902060030160008282829054906101000a900463ffffffff160392506101000a81548163ffffffff021916908363ffffffff1602179055506114fc836040805190810160405280601281526020017f436f6e73756d7074696f6e20706f696e74730000000000000000000000000000815250610ff2565b50600190505b92915050565b828054600181600116156101000203166002900490600052602060002090601f016020900481019282601f1061154957805160ff1916838001178555611577565b82800160010185558215611577579182015b8281111561157657825182559160200191906001019061155b565b5b5090506115849190611588565b5090565b6115aa91905b808211156115a657600081600090555060010161158e565b5090565b905600a165627a7a72305820bb0ff0f1b8e2224fd644a34627c77f66b6e91ebce410c94a15b7932d319c85680029";

    public static final String ABI = "[{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"lastTime\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"recordNum\",\"outputs\":[{\"name\":\"\",\"type\":\"uint32\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Value\",\"type\":\"uint32\"}],\"name\":\"throwRubbish\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"}],\"name\":\"infoQuery\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"},{\"name\":\"\",\"type\":\"uint32\"},{\"name\":\"\",\"type\":\"string\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Name\",\"type\":\"string\"},{\"name\":\"TokenAllValues\",\"type\":\"uint32\"},{\"name\":\"userImg\",\"type\":\"string\"}],\"name\":\"userInit\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":false,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"Value\",\"type\":\"uint32\"}],\"name\":\"buyThing\",\"outputs\":[{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"nonpayable\",\"type\":\"function\"},{\"constant\":true,\"inputs\":[{\"name\":\"userID\",\"type\":\"string\"},{\"name\":\"num\",\"type\":\"uint32\"}],\"name\":\"recordQuery\",\"outputs\":[{\"name\":\"\",\"type\":\"string\"},{\"name\":\"\",\"type\":\"uint256\"}],\"payable\":false,\"stateMutability\":\"view\",\"type\":\"function\"},{\"anonymous\":false,\"inputs\":[{\"indexed\":false,\"name\":\"ID\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"Name\",\"type\":\"string\"},{\"indexed\":false,\"name\":\"TokenAllValues\",\"type\":\"uint32\"}],\"name\":\"TestUser\",\"type\":\"event\"}]";

    public static final TransactionDecoder transactionDecoder = new TransactionDecoder(ABI, BINARY);

    public static final String FUNC_LASTTIME = "lastTime";

    public static final String FUNC_RECORDNUM = "recordNum";

    public static final String FUNC_THROWRUBBISH = "throwRubbish";

    public static final String FUNC_INFOQUERY = "infoQuery";

    public static final String FUNC_USERINIT = "userInit";

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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void lastTime(String userID, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_LASTTIME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String lastTimeSeq(String userID) {
        final Function function = new Function(
                FUNC_LASTTIME, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID)), 
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

    public RemoteCall<BigInteger> recordNum(String userID) {
        final Function function = new Function(FUNC_RECORDNUM, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Uint32>() {}));
        return executeRemoteCallSingleValueReturn(function, BigInteger.class);
    }

    public RemoteCall<TransactionReceipt> throwRubbish(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_THROWRUBBISH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void throwRubbish(String userID, BigInteger Value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_THROWRUBBISH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String throwRubbishSeq(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_THROWRUBBISH, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
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

    public RemoteCall<Tuple4<String, BigInteger, BigInteger, String>> infoQuery(String userID) {
        final Function function = new Function(FUNC_INFOQUERY, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID)), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Uint256>() {}, new TypeReference<Uint32>() {}, new TypeReference<Utf8String>() {}));
        return new RemoteCall<Tuple4<String, BigInteger, BigInteger, String>>(
                new Callable<Tuple4<String, BigInteger, BigInteger, String>>() {
                    @Override
                    public Tuple4<String, BigInteger, BigInteger, String> call() throws Exception {
                        List<Type> results = executeCallMultipleValueReturn(function);
                        return new Tuple4<String, BigInteger, BigInteger, String>(
                                (String) results.get(0).getValue(), 
                                (BigInteger) results.get(1).getValue(), 
                                (BigInteger) results.get(2).getValue(), 
                                (String) results.get(3).getValue());
                    }
                });
    }

    public RemoteCall<TransactionReceipt> userInit(String userID, String Name, BigInteger TokenAllValues, String userImg) {
        final Function function = new Function(
                FUNC_USERINIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(Name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(TokenAllValues), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userImg)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void userInit(String userID, String Name, BigInteger TokenAllValues, String userImg, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_USERINIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(Name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(TokenAllValues), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userImg)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String userInitSeq(String userID, String Name, BigInteger TokenAllValues, String userImg) {
        final Function function = new Function(
                FUNC_USERINIT, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(Name), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(TokenAllValues), 
                new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userImg)), 
                Collections.<TypeReference<?>>emptyList());
        return createTransactionSeq(function);
    }

    public Tuple4<String, String, BigInteger, String> getUserInitInput(TransactionReceipt transactionReceipt) {
        String data = transactionReceipt.getInput().substring(10);
        final Function function = new Function(FUNC_USERINIT, 
                Arrays.<Type>asList(), 
                Arrays.<TypeReference<?>>asList(new TypeReference<Utf8String>() {}, new TypeReference<Utf8String>() {}, new TypeReference<Uint32>() {}, new TypeReference<Utf8String>() {}));
        List<Type> results = FunctionReturnDecoder.decode(data, function.getOutputParameters());;
        return new Tuple4<String, String, BigInteger, String>(

                (String) results.get(0).getValue(), 
                (String) results.get(1).getValue(), 
                (BigInteger) results.get(2).getValue(), 
                (String) results.get(3).getValue()
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

    public RemoteCall<TransactionReceipt> buyThing(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_BUYTHING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
                Collections.<TypeReference<?>>emptyList());
        return executeRemoteCallTransaction(function);
    }

    public void buyThing(String userID, BigInteger Value, TransactionSucCallback callback) {
        final Function function = new Function(
                FUNC_BUYTHING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
                Collections.<TypeReference<?>>emptyList());
        asyncExecuteTransaction(function, callback);
    }

    public String buyThingSeq(String userID, BigInteger Value) {
        final Function function = new Function(
                FUNC_BUYTHING, 
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(Value)), 
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
                Arrays.<Type>asList(new org.fisco.bcos.web3j.abi.datatypes.Utf8String(userID), 
                new org.fisco.bcos.web3j.abi.datatypes.generated.Uint32(num)), 
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
        List<Contract.EventValuesWithLog> valueList = extractEventParametersWithLog(TESTUSER_EVENT, transactionReceipt);
        ArrayList<TestUserEventResponse> responses = new ArrayList<TestUserEventResponse>(valueList.size());
        for (Contract.EventValuesWithLog eventValues : valueList) {
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
