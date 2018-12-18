package fixSysDateTest;

import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
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
// Mock対象のClassを定義する
@PrepareForTest({ OutputDate.class, Date.class })
public class FixSysDateUsingPowerMock2 {

	OutputDate output = new OutputDate();

	@Before
	public void setUp() {
		setDatemock();
	}

	@Test
	public void test() {
		output.getDate();
	}

	/**
	 * システム日付けを固定する
	 * この方法だとミリ秒まで固定する
	 */
	private static void setDatemock() {
		String strDate = "2018-01-01 10:10:10.111";
		// 時間を2018年1月1日10時10分10秒にセットする(月は0が1月)
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		try {
			PowerMockito.whenNew(Date.class).withNoArguments().thenReturn(sdFormat.parse(strDate));
			when(new Date()).thenReturn(sdFormat.parse(strDate));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
