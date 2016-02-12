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
        researcher.save()

        Learner learner = new Learner()
        learner.email = "example2@gmail.com"
        learner.password = "password"
        learner.lastName = "Baratheon"
        learner.firstName = "Stannis"
        learner.id = "12"
        learner.researcherID = researcher.id
        learner.disability = "Secondborn Son Syndrome"
        learner.dateOfBirth = new Date(1990, 6, 15)
        learner.save()

        FirstExample firstExample = new FirstExample()
        firstExample.type = "FirstExample"
        firstExample.name = "Example1"
        firstExample.words = ["Game", "of", "Thrones"]
        firstExample.save()

        Module module = new Module()
        module.inputID = firstExample.moduleDataID
        module.type = firstExample.type
        module.save()
    }
    def destroy = {
    }
}
