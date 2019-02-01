# API gateway pressure test

## 压测环境：
```
系统环境：centos 7 4C/4G
压测工具：wrk
压测参数：
1、wrk -c12 -t6 -d30s --timeout 1s http://localhost:8088/api/test
2、针对异步gateway，可以提高并发数
```

## 压测项目：

#### httpServer
+ springboot-server(tomcat server)
+ netty-server
+ nodejs-server

#### gateway Server
+ zuul-gateway
+ kong-gateway
+ gravitee-gateway
+ springcloud-gateway


## 压测报告：
+ springboot-server
```$xslt
Running 30s test @ http://192.168.59.2:8080/api/test
  8 threads and 16 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     1.66ms    1.74ms  41.08ms   91.29%
    Req/Sec     1.47k   225.28     2.44k    71.08%
  352326 requests in 30.01s, 42.06MB read
Requests/sec:  11738.68
Transfer/sec:      1.40MB
```

+ zuul-gateway
```$xslt
Running 30s test @ http://192.168.59.3:8080/test
  12 threads and 400 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency   116.04ms  136.17ms 999.19ms   87.71%
    Req/Sec   394.53     70.55   640.00     71.37%
  141554 requests in 30.08s, 25.00MB read
  Socket errors: connect 0, read 0, write 0, timeout 280
Requests/sec:   4705.82
Transfer/sec:    850.94KB
```

+ kong-gateway
```$xslt
Running 30s test @ http://192.168.59.3:8000
  6 threads and 12 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency     2.20ms    1.87ms  44.70ms   90.52%
    Req/Sec     1.02k   222.86     1.73k    73.11%
  183297 requests in 30.02s, 38.27MB read
Requests/sec:   6105.55
Transfer/sec:      1.27MB
```

+ springcloud-gateway
```$xslt
Running 30s test @ http://192.168.59.3:8080/api/test
  8 threads and 100 connections
  Thread Stats   Avg      Stdev     Max   +/- Stdev
    Latency    18.64ms   11.14ms 118.46ms   75.13%
    Req/Sec   671.76     93.51     0.99k    68.71%
  160653 requests in 30.04s, 19.46MB read
Requests/sec:   5347.19
Transfer/sec:    663.23KB
```

#### 压测结论
+ 针对异步的gateway，可以尝试调高并发数，能获得较高的qps
+ 总得测算kong的qps最大
+ 这里的zuul是1.x版本，同步的gateway，而springcloud-gateway是异步版本，相对性能较高