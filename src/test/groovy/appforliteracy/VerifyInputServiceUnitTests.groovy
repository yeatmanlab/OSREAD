package appforliteracy

import org.grails.web.json.JSONObject
import org.junit.Before
import org.junit.Test

/**
 * Created by josephkesting on 1/27/16.
 */
class VerifyInputServiceUnitTests extends GroovyTestCase {

    final DATAFOLDER = "./src/test/groovy/appforliteracy/TestDataVerifyInputService/"
    ParseInputService verify = new ParseInputService(DATAFOLDER + "testInputConfig.txt") //TODO:Reconfigure to get @Before bloc working

    @Before
    void setup() {
        verify = new ParseInputService(DATAFOLDER + "testInputConfig.txt")
    }

    @Test
    void testValidInput() {
        try {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputPass.txt"))
        } catch (Exception e) {

            assertTrue("Failed on valid input: " + e.message, false)
        }
    }

    @Test
    void testNoName() {
        shouldFail {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputFailNoName.txt"))
        }
    }

    @Test
    void testNoType() {
        shouldFail {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputFailNoType.txt"))
        }
    }

    @Test
    void testTypeNotFound() {
        shouldFail {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputFailTypeNotFound.txt"))
        }
    }

    @Test
    void testWrongType() {
        shouldFail {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputFailWrongType.txt"))
        }
    }

    @Test
    void testWrongTypeInArray() {
        shouldFail {
            verify.parseInputFile(getJSONFromPath(DATAFOLDER + "testInputFailWrongTypeInArray.txt"))
        }
    }

    static def getJSONFromPath (String path) {
        File f = new File(path)
        return new JSONObject(f.text)
    }
}
