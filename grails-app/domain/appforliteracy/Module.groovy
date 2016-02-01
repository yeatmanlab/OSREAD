package appforliteracy

class Module {
    
    String moduleId
    String contentName //upload file button
    boolean isCompleted
    
    static constraints = {
        moduleId blank: false, unique: true
        contentName blank: false
    }
}
