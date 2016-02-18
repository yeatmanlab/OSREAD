Creating a New Module
Pick a name for the module (Hereafter this will be referred to as TYPE)

Defining Module Input:
1. Define a domain for the module input. This domain class must do the following:
-extend the ModuleInput class
-define the module input data as fields in the domain

Example:

class FirstExample extends ModuleInput {

    static hasMany = [words: String]
    List words
}

2. Define the configuration of your module input in the module-input-configuration/input-config.txt:

The config file entry must take the following form:
TYPE
{
	fieldName: dataType
}

The following dataTypes are accepted as input:
String
Integer
Double
Boolean

or any arrays of the above types:
[String]
[Integer]
[Double]
[Boolean]

Example:
FirstExampleInput
{
    words: [String]
}

3. Define an input file and test:

The input file must take this form:

{
	"type": "TYPE",
	"name": "Module Name",
	"field1Name": "Field 1 Input"
	"field2Name": "Field 2 Input"
	...
}

Example: 
{
	"type": "FirstExampleInput",
	"name": "Example Input 1",
	"words": [
		"Micha",
		"Loves",
		"Magic"			
	]
}

Program the Module:

There are only three requirements when programming a new App for Literacy module:

1. It must be programmed within the grails framework. If you have no experience with this here is a solid tutorial that will get you started: http://grails.asia/grails-tutorial-for-beginners/

-Programming within the grails framework also means that you will need to properly place the files you are adding.

Controllers should be placed in AppForLiteracy/grails-app/controllers/appforliteracy

Views should be placed under the appropriate controller folder in AppForLiteracy/grails-app/views

Any services you need should be placed in AppForLiteracy/grails-app/services/appforliteracy

Paste the following under the <content> tag in TYPE.iml:

	  <sourceFolder url="file://$MODULE_DIR$/grails-app/controllers" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/domain" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/init" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/services" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/taglib" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/utils" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/src/main/groovy" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/main/java" isTestSource="false" />
      <sourceFolder url="file://$MODULE_DIR$/src/integration-test/groovy" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/integrationTest/groovy" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/integrationTest/java" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/src/test/groovy" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/test/java" isTestSource="true" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/conf" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/i18n" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/grails-app/views" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/main/resources" type="java-resource" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/integrationTest/resources" type="java-test-resource" />
      <sourceFolder url="file://$MODULE_DIR$/../ExampleModule/src/test/resources" type="java-test-resource" />
      <excludeFolder url="file://$MODULE_DIR$/../ExampleModule/.gradle" />
      <excludeFolder url="file://$MODULE_DIR$/../ExampleModule/build" />

This will enable Grails to recognize the controllers, domains, and services you create.

Delete grails-app/init/Bootstrap.groovy











