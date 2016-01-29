package appforliteracy

abstract class ModuleInput {

    static constraints = {
        name(unique: true)
    }

    String name
    String type
    Date timestamp = new Date()
}
