# README

# Create New Module
### 1. Pick a name for your new module
Herafter this name will be referred to as **TYPE**
### 2. Create Grails Plugin
Use the following command to have Grails generate scaffolding code for your new plugin:
```sh
$ grails create-plugin TYPE
```

### 3. Add Dependeny on MetaFunctionality
```
repositories {
    ...
    maven { url "http://dl.bintray.com/osreadplugins/plugins" }
}
```
```
dependencies {
    ...
    compile "org.grails.plugins:MetaFunctionality:0.1"
    ...
}
```

##### Note - The following classes must exist in a package named type (TYPE in all lower case)

### 4. Create Input Domain
In the domains folder create a domain class with name TYPE

This domain class must do the following:

- extend the ModuleInput class

- define the module input data as fields in the domain
- This is where you are able to define the input you want to take in when the module is assigned

Example:
```
class FirstExample extends ModuleInput {
    static hasMany = [words: String]
    List words
}
```

### 5. Create FetchInputHeadersService

In the services folder create a new service named FetchInputHeadersService.

Within this service define a method that returns a Map<String, String> that represents a mapping from the fields defined in the domain class to their respective data types.

The following data types are accepted as input:
- String
- Integer
- Double
- Boolean

or any arrays of the above types:
- [String]
- [Integer]
- [Double]
- [Boolean]

Example:
```
class FetchInputHeadersService {
    def getHeaders () {
        Map<String, String> headers = new LinkedHashMap<>()
        headers.put("words", "[String]")
        return headers
    }
}
```
### 6. Create Start Controller
Create a controller to serve as the entry point of the module.

This controller must be named TYPEController.

The controller must have a method start()

This method will be passed the moduleID of the module through params.id which can be used to get the associated Module object by calling Module.findByModuleID(params.id)

Example:
```
import firstexample.FirstExample
import metafunctionality.Module
import metafunctionality.ModuleOutput

class FirstExampleController {

    def start() {
        String inputID = Module.findByModuleId(params.id).inputID
        FirstExample input = FirstExample.findByModuleDataID(inputID)
        List<String> rc = input.words
        //Store Module in saveModuleService
        [words: words]
    }
}    
```
### 7. Save Output
At the end of the module you must save the output that you wish to pass out of the module with the Module object that was passed in.

To do so you must create a ModuleOutput object and store within it the desired headers and rows of comma-separated values.

Finally store the ModuleDataID of the ModuleOutput object in the Module object.

This ModuleOutput object will be translated into a .CSV file with the associated headers and comma-separated rows of data.

Example:
```
def submit() {
    List<String> valueRows = new ArrayList<String>()
    ModuleOutput output = new ModuleOutput()
    output.headers = ["word", "accuracy"]
    
    output.valueRows = params.data
    
    Module m = //load from saveModuleService
    if (m.outputIDs != null) {
        m.outputIDs.add(output.moduleDataID)
    } else {
        m.outputIDs = [output.moduleDataID]
    }
    output.type = "FirstExample"
    m.save(flush: true)
    output.save(flush: true)
    
    //redirect to learner home
    redirect(controller: "appforliteracy.FileOutput", action: "output", params:     [id: output.moduleDataID])
}
```

### 8. Publish Plugin to Remote Maven Repository

Once you have completed your module you must publish it to the Maven repository.

There are several steps to do this:

##### 1. Create an account with bintray.com
##### 2. Request to join the organization osreadplugins
##### 3. Once your request is approved, add the following to your build.gradle file:
```
plugins {
    ...
    id "com.jfrog.bintray" version "1.2"
}
```

```
bintray {
    user = "username"
    key = "apikey"
    publications = ['maven']
    publish = true
    pkg {
        userOrg = 'osreadplugins'
        name = "TYPE"
        issueTrackerUrl = "https://github.com/username/TYPE/issues" 
        vcsUrl = "https://github.com/username/grails-TYPE"
        version {
            attributes = ['grails-plugin': "org.osread:TYPE"]
            name = 0.1
        }
    }
}
```

Your API Key can be found under 'Edit your profile'

##### 4. Publish your plugin
Enter the following command at your project root:
```sh
$ grails gradle bintrayUpload
```

##### 5. Verify Upload
You should now be able to navigate to https://bintray.com/osreadplugins/plugins
and see your plugin!

### 9. Add Dependencies into the OsREAD Main Application
Once you have published your plugin to the Maven repository you are now ready to integrate it into the main application!

Two things are required to do this:
##### 1. Add Dependency
Add the following line to the AppForLiteracy/build.gradle file:
```
dependencies {
    ...  
    compile "org.grails.plugins:TYPE:version" //version is specified in the build.gradle file of your plugin under the name field of version
    ...
}
```

##### 2. Add Your TYPE to ModuleListService
```
class ModuleListService {

    static List<String> getModuleNames() {
        List<String> names = new ArrayList<>()
        names.add("FirstExample")
        names.add("TYPE")

        //TODO: Add additional module names here

        return names
    }
}
```

You're new module should be completely functional! Test it by assigning the module with a module input file that matches your specified input plus name and type fields.
Example:
```
{
  "type": "FirstExample",
  "name": "Example Input",
  "words": [
      "Reading",
      "is",
      "cool!"
  ]    
}