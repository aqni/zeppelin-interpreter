package org.apache.zeppelin.iginx;

import java.util.Properties;
import org.apache.zeppelin.interpreter.*;

public class IginxInterpreter11 extends AbstractInterpreter {

  private final IginxInterpreter8 innerInterpreter;

  public IginxInterpreter11(Properties properties) {
    super(properties);
    innerInterpreter = new IginxInterpreter8(properties);
  }

  @Override
  public ZeppelinContext getZeppelinContext() {
    return null;
  }

  @Override
  protected InterpreterResult internalInterpret(String s, InterpreterContext interpreterContext)
      throws InterpreterException {
    return innerInterpreter.interpret(s, interpreterContext);
  }

  @Override
  public void open() throws InterpreterException {
    innerInterpreter.open();
  }

  @Override
  public void close() throws InterpreterException {
    innerInterpreter.close();
  }

  @Override
  public void cancel(InterpreterContext interpreterContext) throws InterpreterException {
    innerInterpreter.cancel(interpreterContext);
  }

  @Override
  public FormType getFormType() throws InterpreterException {
    return innerInterpreter.getFormType();
  }

  @Override
  public int getProgress(InterpreterContext interpreterContext) throws InterpreterException {
    return innerInterpreter.getProgress(interpreterContext);
  }
}
