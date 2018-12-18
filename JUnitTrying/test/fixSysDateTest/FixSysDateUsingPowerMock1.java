package fixSysDateTest;
import static org.mockito.Mockito.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import sysdate.OutputDate;

//テストランナー(PowerMockRunnerを使用するとEclemmaでカバレッジが取得できない)
@RunWith(PowerMockRunner.class)
//Mock対象のClassを定義する
@PrepareForTest({OutputDate.class, Date.class})
public class FixSysDateUsingPowerMock1 {

	OutputDate output = new OutputDate();

	@Before
	public void setUp(){
		setDatemock();
	}


	@Test
	public void test() {
		output.getDate();
	}

	/**
	 * システム日付けを固定する
	 * この方法だとミリ秒まで固定できない
	 */
	private static void setDatemock(){
		Calendar cal = Calendar.getInstance();
		//時間を2018年1月1日10時10分10秒にセットする(月は0が1月)
		cal.set(2018, 0,1,10,10,10);
		try {
			PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(cal.getTime());
			when(new Date()).thenReturn(cal.getTime());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
