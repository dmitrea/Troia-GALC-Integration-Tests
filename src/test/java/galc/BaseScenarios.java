package test.java.galc;
import org.junit.Test;

import com.datascience.galc.dataGenerator.SyntheticData;
import com.datascience.galc.*;

public class BaseScenarios {
	
	@Test
	public void test_GenerateSyntheticData(){
		String fileSeparator = System.getProperty("file.separator");
		String syntheticDataFile = System.getProperty("user.dir").concat(fileSeparator).concat("datasets").concat(fileSeparator).concat("synthetic-options.txt");
		
		SyntheticData data = new SyntheticData(false, syntheticDataFile);
		data.initDataParameters();
		data.initWorkerParameters();
		data.build();
		
		ContinuousIpeirotis contIpeirotis = new ContinuousIpeirotis();
		contIpeirotis.setData(data);		
	}

}
