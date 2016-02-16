package appforliteracy

class EyeData {
    
    double[][] eyeLocation
    int sampleRate
    String patientId
    
    static constraints = {
        eyeLocation blank: false
        sampleRate blank: false
        patientId blank: false
    }
}
