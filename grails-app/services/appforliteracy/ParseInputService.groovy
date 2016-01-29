package appforliteracy

import grails.transaction.Transactional
import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject
import org.springframework.web.multipart.MultipartFile

//@Transactional
class ParseInputService {

    String pathToConfig;

    ParseInputService(String pathToConfig) {
        this.pathToConfig = pathToConfig
    }

    List<String> parseInputFile(JSONObject input) throws IllegalStateException {
        List<String> keys = new ArrayList<>()
        String type = input["type"]
        if (type == null || !(type instanceof String)) {
            throw new IllegalStateException("Type misformatted")
            //TODO: Use custom exception
        }
        keys.add("type")
        String name = input["name"]
        if (name == null || !(name instanceof String)) {
            throw new IllegalStateException("name misformatted")
            //TODO: Use custom exception
        }
        keys.add("name")
        File config = new File(pathToConfig)
        Scanner s = new Scanner(config)
        boolean found = false
        while (!found && s.hasNextLine()) {
            String header = s.nextLine()
            if (header.equals(type)) {
                found = true
            }
        }
        if (found == false) {
            throw new IllegalArgumentException("type: " + type + " not found in config file: " + pathToConfig)
        }
        String line = s.nextLine().trim()
        while (!line.equals("}")) { //TODO: Better while condition
            String[] splitString = line.split(":")
            if (splitString.length == 2) {
                String key = splitString[0].trim()
                String keyType = splitString[1].trim()
                try {
                    verifyKey(input, key, keyType)
                } catch (Exception e) {
                    throw e
                }
                keys.add(key)
            }
            line = s.nextLine().trim()
        }
        return keys
    }

    def verifyKey(JSONObject input, String key, String keyType) throws IllegalStateException {
        if(input[key] == null) {
            throw new IllegalStateException("key: " + key + " does not exist")
            //TODO: Throw customized Exception
        }
        if (keyType.charAt(0) == '[' && keyType.charAt(keyType.length() - 1) == ']') {
            keyType = keyType.substring(1, keyType.length() - 1)
            if (!(input[key].getClass().equals(JSONArray.newInstance().getClass()))) {

                throw new IllegalStateException("Value of key: " + key + " is not an array")
                //TODO: Throw customized exception
            }
            Class type = Class.forName(getFullClassString(keyType))
            for (int i = 0; i < input[key].size(); i++) {
                if (!type.equals(input[key][i].getClass())) {
                    throw new IllegalStateException("Value of key: " + key + " at index: " + i + " is of wrong type")
                    //TODO: Throw customized exception extending IllegalStateException
                }
            }
        } else {

            Class type = Class.forName(getFullClassString(keyType))
            if (!type.equals(input[key].getClass())) {
                throw new IllegalStateException("Value of key: " + key + " is of wrong type")
                //TODO: Throw customized exception extending IllegalStateException
            }
        }
    }

    static def getFullClassString (String type) {
        return "java.lang." + type
    }
}
