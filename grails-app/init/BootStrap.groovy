import appforliteracy.Learner

import metafunctionality.Module
import appforliteracy.Researcher
import firstexample.FirstExample
import metafunctionality.ModuleOutput

class BootStrap {

    def init = { servletContext ->

        Researcher researcher = new Researcher()
        researcher.position = "Boss"
        researcher.email = "example@gmail.com"
        researcher.password = "password"
        researcher.lastName = "Nye"
        researcher.firstName = "Bill"

        Learner learner = new Learner()
        learner.email = "example2@gmail.com"
        learner.password = "password"
        learner.lastName = "Baratheon"
        learner.firstName = "Stannis"
        learner.researcherID = researcher.userID
        learner.disability = "Secondborn Son Syndrome"
        learner.dateOfBirth = new Date(1990, 6, 15)


        researcher.learnerIDs = [learner.userID]


        FirstExample firstExample = new FirstExample()
        firstExample.type = "FirstExample"
        firstExample.name = "Example1"
        firstExample.word = "Hall"
        firstExample.answer = "Ball"
        firstExample.rhymingCandidates = ["Game", "Alligator", "Pinwheel"]


        Module module = new Module()
        module.inputID = firstExample.moduleDataID
        module.type = firstExample.type
        module.isCompleted = true

        ModuleOutput output = new ModuleOutput()
        output.headers = ["word", "accuracy"]
        output.valueRows = ["Hello,100"]
        output.type = "FirstExample"

        module.outputIDs = [output.moduleDataID]

        learner.moduleIDs = [module.moduleId]

        firstExample.save(flush: true)
        researcher.save(flush: true)
        learner.save(flush: true)
        module.save(flush: true)
        output.save(flush: true)
    }
    def destroy = {
    }
}
