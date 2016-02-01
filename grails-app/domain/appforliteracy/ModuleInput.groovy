package appforliteracy

abstract class ModuleInput {

    static constraints = {
        name(unique: true)
        moduleInputID(unique: true)
    }

    String moduleInputID = UUID.randomUUID().toString()
    String name
    String type
    Date timestamp = new Date()
}
