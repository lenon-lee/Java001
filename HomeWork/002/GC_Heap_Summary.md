#物理机
MEM=32G; CPU=6100U;
#GC实验
##自适应参数
         GC方式 | 堆内存大小 | 循环次数| 
|-------------:|------:|-----:|
|           串行 |  640M | 6319 |
|           并行 |  640M | 7587 | 
|          CMS |  640M | 7009 | 
|           G1 |  640M | 7724 | 
|           串行 |  832M | 5987 |
|           并行 |  832M | 7632 |  
|          CMS |  832M | 6757 | 
|           G1 |  832M | 8621 | 

##关闭自适应参数
    GC方式 | 堆内存大小 | 循环次数  
|--------:|------:|-----:|
|      并行 |  640M | 9400 |
|      并行 |  832M | 9628 |  
|      并行 |  960M | 8299 |
|      并行 |    1G | 6697 |
|      并行 | 1280M | 8845 | 
|      并行 | 1920M | 6356 | 

##猜想
要达到比较优化的吞吐量，除了已经提到的因素以外，可能还需要根据CPU计算能力匹配合适的堆内存大小。

#Superbenchmarker
##Commands: 
java -jar -Xmx512m -Xms512m gateway-server-0.0.1-SNAPSHOT.jar
最大堆内存512M、初始堆内存512M，栈大小缺省1M，缺省并行GC，自适应参数值
sb -u http://localhost:8088/api/hello -c 20 -N 60
url: “http://localhost:8088/api/hello”
并发请求数: 20
持续时长: 60秒

##Result:
    106461  (RPS: 1567.7)
    ---------------Finished!----------------
    Finished at 2022/1/23 21:10:28 (took 00:01:08.0079820)
    Status 200:    106463

    RPS: 1742.6 (requests/second)
    Max: 549ms
    Min: 0ms
    Avg: 1.1ms

    50%   below 0ms
    60%   below 0ms
    70%   below 1ms
    80%   below 1ms
    90%   below 3ms
    95%   below 5ms
    98%   below 8ms
    99%   below 11ms
    99.9%   below 33ms
