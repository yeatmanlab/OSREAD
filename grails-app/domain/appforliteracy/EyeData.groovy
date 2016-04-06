package appforliteracy

/*
    Class structure for eye data. This is super basic and we can change this.
 */

class EyeData {
    
    int sampleRate
    String patientId
    
    static constraints = {
        sampleRate blank: false
        patientId blank: false
    }
}
