package appforliteracy

class EyeData {
    
    int sampleRate
    String patientId
    
    static constraints = {
        sampleRate blank: false
        patientId blank: false
    }
}
