package appforliteracy

import org.grails.web.json.JSONArray
import org.grails.web.json.JSONObject


class ParseDataService {
    final DOMAINPACKAGE = "appforliteracy.moduleInputDomains."

    ParseDataService() {
    }

    List<String> parseDataFile(JSONObject data) throws IllegalStateException {
        List<String> keys = new ArrayList<>()
        String type = data["type"]
        if (type == null || !(type instanceof String)) {
            throw new IllegalStateException("Type misformatted")
            //TODO: Use custom exception
        }
        keys.add("type")

        String name = data["name"]
        if (name == null || !(name instanceof String)) {
            throw new IllegalStateException("name misformatted")
            //TODO: Use custom exception
        }
        keys.add("name")

        Class config = Class.forName(type.toLowerCase().trim() + "." + "FetchInputHeadersService")
        Map<String,String> paramMap = config.newInstance().getHeaders()
        for (param in paramMap.keySet()) {
            try {
                println(param)
                println(paramMap.get(param))
                verifyKey(data, param, paramMap.get(param))
            } catch (Exception e) {
                throw e
            }
            keys.add(param)
        }
        return keys
    }

    void verifyKey(JSONObject data, String key, String keyType) throws IllegalStateException {
        if(data[key] == null) {
            throw new IllegalStateException("key: " + key + " does not exist")
            //TODO: Throw customized Exception
        }
        if (keyType.charAt(0) == '[' && keyType.charAt(keyType.length() - 1) == ']') {
            keyType = keyType.substring(1, keyType.length() - 1)
            if (!(data[key].getClass().equals(JSONArray.newInstance().getClass()))) {
                throw new IllegalStateException("Value of key: " + key + " is not an array")
                //TODO: Throw customized exception
            }
            Class type = Class.forName(getFullClassString(keyType))
            for (int i = 0; i < data[key].size(); i++) {
                if (!type.equals(data[key][i].getClass())) {
                    throw new IllegalStateException("Value of key: " + key + " at index: " + i + " is of wrong type")
                    //TODO: Throw customized exception extending IllegalStateException
                }
            }
        } else {
            Class type = Class.forName(getFullClassString(keyType))
            if (!type.equals(data[key].getClass())) {
                throw new IllegalStateException("Value of key: " + key + " is of wrong type")
                //TODO: Throw customized exception extending IllegalStateException
            }
        }
    }

    String getFullClassString (String type) {
        return "java.lang." + type
    }
}
