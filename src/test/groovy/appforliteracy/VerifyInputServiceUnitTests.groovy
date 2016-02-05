package appforliteracy

import org.grails.web.json.JSONObject
import org.junit.Before
import org.junit.Test

/**
 * Created by josephkesting on 1/27/16.
 */
class ParseDataServiceUnitTests extends GroovyTestCase {

    final DATAFOLDER = "./src/test/groovy/appforliteracy/TestDataVerifyInputService/"
    ParseDataService verify = new ParseDataService(DATAFOLDER + "testInputConfig.txt") //TODO:Reconfigure to get @Before bloc working

    @Before
    void setup() {
        verify = new ParseDataService(DATAFOLDER + "testInputConfig.txt")
    }

    @Test
    void testValidInput() {
        try {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputPass.txt"))
        } catch (Exception e) {

            assertTrue("Failed on valid data: " + e.message, false)
        }
    }

    @Test
    void testNoName() {
        shouldFail {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputFailNoName.txt"))
        }
    }

    @Test
    void testNoType() {
        shouldFail {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputFailNoType.txt"))
        }
    }

    @Test
    void testTypeNotFound() {
        shouldFail {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputFailTypeNotFound.txt"))
        }
    }

    @Test
    void testWrongType() {
        shouldFail {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputFailWrongType.txt"))
        }
    }

    @Test
    void testWrongTypeInArray() {
        shouldFail {
            verify.parseDataFile(getJSONFromPath(DATAFOLDER + "testInputFailWrongTypeInArray.txt"))
        }
    }

    static def getJSONFromPath (String path) {
        File f = new File(path)
        return new JSONObject(f.text)
    }
}
