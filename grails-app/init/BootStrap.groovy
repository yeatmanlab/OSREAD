import appforliteracy.Learner

import metafunctionality.Module
import appforliteracy.Researcher
import firstexample.FirstExample
import appforliteracy.moduleInputDomains.SecondExample
import appforliteracy.moduleInputDomains.ThirdExample

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

        SecondExample secondExample = new SecondExample()
        secondExample.type = "SecondExample"
        secondExample.name = "Example2"
        secondExample.length = 17
        secondExample.save()

        ThirdExample thirdExample = new ThirdExample()
        thirdExample.type = "ThirdExample"
        thirdExample.name = "Example3"
        thirdExample.favoriteLetter = "J"
        thirdExample.save()

        Module module = new Module()
        module.inputID = firstExample.moduleDataID
        module.type = firstExample.type
        module.save()
    }
    def destroy = {
    }
}
