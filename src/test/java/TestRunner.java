import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
//@IncludeTags("authentifiationValideRemeberMe")
@IncludeTags("REQ_POEC24P2G3-61")

public class TestRunner {
}
