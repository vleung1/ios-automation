

package Framework;

import java.io.File;
import java.io.IOException;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class appiumStartTest {

@BeforeSuite
public void test() {
	CommandLine command = new CommandLine("/usr/local/bin/node");
	command.addArgument("/usr/local/bin/appium",false);
	command.addArgument("--address", false);
	command.addArgument("127.0.0.1");
	command.addArgument("--port", false);
	command.addArgument("4723");
	command.addArgument("-bp", false);
	command.addArgument("4723");
	command.addArgument("--full-reset", true);
	command.addArgument("--session-override", true);
	//command.addArgument("--no-reset", true);
	DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler();
	DefaultExecutor executor = new DefaultExecutor();
	executor.setExitValue(1);
	try {executor.execute(command, resultHandler);
	Thread.sleep(5000);System.out.println("Appium server started.");}
	catch (IOException e) 
	{e.printStackTrace();}
	catch (InterruptedException e) 
	{e.printStackTrace();}
	
}
}

