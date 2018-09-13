## 拒绝策略
拒绝策略：
当任务源源不断的过来，而我们的系统又处理不过来的时候，我们要采取的策略是拒绝服务。
RejectedExecutionHandler接口提供了拒绝任务处理的自定义方法的机会。
在ThreadPoolExecutor中已经包含四种处理策略。

