import appforliteracy.Learner

import metafunctionality.Module
import appforliteracy.Researcher
import firstexample.FirstExample

class BootStrap {

    def init = { servletContext ->

        Researcher researcher = new Researcher()
        researcher.position = "Boss"
        researcher.email = "example@gmail.com"
        researcher.password = "password"
        researcher.lastName = "Nye"
        researcher.firstName = "Bill"
        researcher.learnerIDs = ["12"]


        Learner learner = new Learner()
        learner.email = "example2@gmail.com"
        learner.password = "password"
        learner.lastName = "Baratheon"
        learner.firstName = "Stannis"
        learner.researcherID = researcher.id
        learner.disability = "Secondborn Son Syndrome"
        learner.dateOfBirth = new Date(1990, 6, 15)

        learner.save()

        researcher.learnerIDs = [learner.id]
        researcher.save()

        FirstExample firstExample = new FirstExample()
        firstExample.type = "FirstExample"
        firstExample.name = "Example1"
        firstExample.word = "Hall"
        firstExample.answer = "Ball"
        firstExample.rhymingCandidates = ["Game", "Alligator", "Pinwheel"]
        firstExample.save()

        Module module = new Module()
        module.inputID = firstExample.moduleDataID
        module.type = firstExample.type
        module.save()
    }
    def destroy = {
    }
}
