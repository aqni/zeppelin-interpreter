package org.apache.zeppelin.iginx;

import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;
import org.apache.zeppelin.interpreter.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class IginxInterpreter11 extends Interpreter {
  private static final Logger logger = LoggerFactory.getLogger(IginxInterpreter11.class);
  private Map<String, Thread> taskMap = new ConcurrentHashMap<String, Thread>(); // 处理开启、关闭、取消任务

  // 构造器
  public IginxInterpreter11(Properties property) {
    super(property);
  }

  // repl解释器的生命周期管理:打开解析器，设置程序的初始化信息
  @Override
  public void open() {
    logger.info("Successfully find ** location");
  }

  // repl解释器的生命周期管理:关闭解析器，释放相关资源
  @Override
  public void close() {
    for (Thread task : taskMap.values()) {
      task.interrupt();
    }
    taskMap.clear();
  }

  /**
   * * 解释执行代码的接口.最主要的程序执行方法，负责前后台交互。 * 核心思想：解析命令=>实例化NewIntepreter操作客户端=>操作NewIntepreter客户端进行数据查询 *
   * => 获取返回结果 封装成InterpreterResult对象 * * @param s Zeppelin 前台交互式界面的用户输入, 注意不包含第一行的 %NewInterpreter
   * ---->新的解析器的名称 * @param context 用于存储Paragraph相关的信息。当前Interpreter
   * 插件的上下文，包含插件的配置信息（包括noteId,replName,paragraphId,paragraphText等） * @return
   * InterpreterResult用于存储Job的状态信息以及执行结果，具体包括： - 状态码：SUCCESS，INCOMPLETE，ERROR，KEEP_PREVIOUS_RESULT -
   * 类型：Text（Default),HTML,ANGULAR,TABLE,IMG,SVG,NULL等
   */
  @Override
  public InterpreterResult interpret(String s, InterpreterContext context) {
    logger.info("RUN NewInterpreter script: {}", s);
    return new InterpreterResult(InterpreterResult.Code.SUCCESS, "Please input!");
  }

  // 执行代码过程中交互控制和易用性增强:调用cancel 方法中止 interpret 方法
  @Override
  public void cancel(InterpreterContext context) {
    Thread taskThread = taskMap.remove(context.getParagraphId());
    if (taskThread != null && taskThread.isAlive()) {
      taskThread.interrupt();
    }
  }

  /**
   * * 返回形式 * * @return FormType.SIMPLE enables simple pattern replacement (eg. Hello
   * ${name=world}), * FormType.NATIVE handles form in API * FormType.NONE
   */
  @Override
  public FormType getFormType() {
    return FormType.SIMPLE;
  }

  // 获取执行进度的百分比，0-100
  @Override
  public int getProgress(InterpreterContext context) {
    return 0;
  }
}
