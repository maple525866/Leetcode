package com.code.realTest;

/**
 * @author maple
 * @Description
 * @createTime:2025-11-24 18:35
 */
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RpcBatchRequestTest {

    static RpcService rpcService = new RpcService();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // rpc 请求参数
        List<Integer> requestIds = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        // rpc 调用
        List<String> results = batchGetDetails(requestIds);

        // 输出
        for (String result : results) {
            System.out.println(result);
        }
        // 预期输出
        // details 0
        // details 1
        // details 2
        // .......
        // details 999
    }

    /**
     * 某个 rpc service 的接口只提供单个调用
     * 此处需要做一个封装，多次请求后返回
     *
     * 要求按照顺序返回
     *
     * @param ids
     * @return
     */
    public static List<String> batchGetDetails(List<Integer> ids) throws ExecutionException, InterruptedException {
        // 单次调用
        // RpcService rpcService = new RpcService();
        // rpcService.rpcGetDetailsById(1);

        // TODO 在此处实现批量调用
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(30,
                100,
                30,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(1000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy());
        List<Future<String>> future = new ArrayList<>();
        List<String> res = new ArrayList<>();

        for(int id : ids){
            Future<String> submit = threadPoolExecutor.submit(() -> {
                return rpcService.rpcGetDetailsById(id);
            });
            future.add(submit);
        }

        for(Future<String> submit : future){
            res.add(submit.get());
        }
        return res;
    }
}

class RpcService {
    public String rpcGetDetailsById(int id) {
        // 模拟 rpc service 耗时
        try {
            Thread.sleep(20L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return "details " + id;
    }
}
