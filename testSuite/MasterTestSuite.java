package pa3.testSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({HashMapTest.class, HeapTest.class, MinPriorityQueueTest.class})
public class MasterTestSuite {

}
