import appforliteracy.Module
//import appforliteracy.moduleInputDomains.FirstExample
//import appforliteracy.moduleInputDomains.SecondExample
//import appforliteracy.moduleInputDomains.ThirdExample

import appforliteracy.Learner
import appforliteracy.Researcher
import appforliteracy.Role
import appforliteracy.User
import appforliteracy.UserRole

import metafunctionality.Module
//import firstexample.FirstExample
import metafunctionality.ModuleOutput

class BootStrap {

    def init = { /*servletContext ->

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
        module.save()*/
        
        def adminRole = new Role('ROLE_ADMIN').save()
        def userRole = new Role('ROLE_USER').save()
        def researcherRole = new Role('ROLE_RESEARCHER').save()
        
        def testUser1 = new User('sam@uw.edu','password','Kinn','Sam').save()
        def testUser2 = new User('joe@uw.edu','password','Kesting','Joe').save()
        def testUser3 = new User('erin@uw.edu','password','Peach','Erin').save()
        def testUser4 = new User('jason@uw.edu','password','Yeatman','Jason').save()
        def testUser5 = new User('patrick@uw.edu','password','Donnelly','Patrick').save()
        def testUser6 = new User('anat@uw.edu','password','Caspi','Anat').save()
        
        UserRole.create testUser1, userRole
        UserRole.create testUser2, userRole
        UserRole.create testUser3, userRole
        UserRole.create testUser4, researcherRole
        UserRole.create testUser5, researcherRole
        UserRole.create testUser6, adminRole
        
        /*def learner1 = new Learner(testUser1).save()
        def learner2 = new Learner(testUser2).save()
        def learner3 = new Learner(testUser3).save()
        def researcher1 = new Researcher(testUser4).save()
        def researcher2 = new Researcher(testUser5).save()
        def researcher3 = new Researcher(testUser6).save()*/

               
        UserRole.withSession {
            it.flush()
            it.clear()
        }
        
        //assert Learner.count() == 3
        //assert Researcher.count() == 3
        assert User.count() == 7
        assert Role.count() == 3
        assert UserRole.count() == 6
        
//        module.isCompleted = true
//        Module module = new Module()
//        module.inputID = firstExample.moduleDataID
//        module.type = firstExample.type
//        module.isCompleted = true

//        ModuleOutput output = new ModuleOutput()
//        output.headers = ["word", "accuracy"]
//        output.valueRows = ["Hello,100"]
//        output.type = "FirstExample"

//        module.outputIDs = [output.moduleDataID]

        //learner.moduleIDs = [module.moduleId]

        //firstExample.save(flush: true)
        //researcher.save(flush: true)
        //learner.save(flush: true)
        //module.save(flush: true)
        //output.save(flush: true)

        //module.save(flush: true)
        //output.save(flush: true)
    }
    def destroy = {
    }
}
