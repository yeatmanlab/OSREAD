Creating a New Module

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
	fieldName: type
}

The following types are accepted as input:
String
Character
Integer
Double
Boolean

or any arrays of the above types:
[String]
[Character]
[Integer]
[Double]
[Boolean]

Example:
FirstExample
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
	"type": "FirstExample",
	"name": "Example Input 1",
	"words": [
		"Micha",
		"Loves",
		"Magic"			
	]
}
