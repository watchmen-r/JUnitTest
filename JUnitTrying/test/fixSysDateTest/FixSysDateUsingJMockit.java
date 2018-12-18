package fixSysDateTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.integration.junit4.JMockit;
import sysdate.OutputDate;

@RunWith(JMockit.class)
public class FixSysDateUsingJMockit {

	//private staticをつけないとダメ
	@Mocked
	private static OutputDate output = new OutputDate();

	@Before
	public void setUp() throws Exception{
		setDatemock();
	}

	@Test
	public void test() {
		output.getDate();
	}

	private  void setDatemock() throws Exception {
		String strDate = "2018-01-01 10:10:10.111";
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
		new CurrentTimeMock(sdFormat.parse(strDate));
	}

	/**
	 * dateモック用クラス
	 */
	public static class CurrentTimeMock extends MockUp<System>{
		Date mockTime;

		public CurrentTimeMock(Date mockTime){
			this.mockTime = mockTime;
		}

		@Mock
		public long currentTimeMillis(){
			return mockTime.getTime();
		}
	}

}
