package test.java.galc;
import java.util.Map;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.datascience.core.base.ContValue;
import com.datascience.core.base.LObject;
import com.datascience.core.base.Worker;
import com.datascience.galc.dataGenerator.SyntheticData;
import com.datascience.galc.dataGenerator.SyntheticDataGenerator;
import com.datascience.galc.ContinuousIpeirotis;
import com.datascience.galc.DatumContResults;
import com.datascience.galc.WorkerContResults;

public class BaseScenarios {
	
	@Test
	public void test_GenerateSyntheticData(){
		String fileSeparator = System.getProperty("file.separator");
		String syntheticDataFile = System.getProperty("user.dir").concat(fileSeparator).concat("datasets").concat(fileSeparator).concat("synthetic-options.txt");
		
		SyntheticData data = new SyntheticDataGenerator(syntheticDataFile).generate();
		
		ContinuousIpeirotis contIpeirotis = new ContinuousIpeirotis();
		contIpeirotis.setData(data);		
		
		Map<LObject<ContValue>, DatumContResults> objectsResults = contIpeirotis.getObjectsResults();
		Map<Worker<ContValue>, WorkerContResults> workersResults = contIpeirotis.getWorkersResults();
		
		System.out.println(objectsResults);
		System.out.println(workersResults);
		
		assertFalse(objectsResults.size() == 0);
		assertFalse(workersResults.size() == 0);

	}

}
