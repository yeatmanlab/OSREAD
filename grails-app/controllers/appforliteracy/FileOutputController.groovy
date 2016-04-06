package appforliteracy

import metafunctionality.ModuleOutput
import metafunctionality.Module


class FileOutputController {

    /*
        The output of a module is saved to a file (type specified by module). This controller corresponds to the process
        of a researcher downloading the results file.
     */


    /*
        Returns the modules of the learner (so they can be printed, chosen, etc.)
     */
    def output() {
        Learner learner = Learner.findById(params.id)
        List<Module> modules = learner.getModules()
        [modules: modules]
    }

    /*
        Enables the researcher to download a file with the module results.
     */
    //TODO: This seems .csv specific, do we want to change this to be type agnostic
    def downloadFile = {
        ModuleOutput output = ModuleOutput.findByModuleDataID(params.outputID)
        String fileName = output.type + ".csv" //TODO: Better name
        try {
            FileWriter writer = new FileWriter(fileName)
            for (int i = 0; i < output.headers.size() - 1; i++) {
                String header = output.headers.get(i)
                writer.append(header)
                writer.append(',')
            }
            writer.append(output.headers.get(output.headers.size() - 1))
            writer.append('\n')
            for (line in output.valueRows) {
                writer.append(line)
                writer.append('\n')
            }
            writer.flush()
            File f = new File(fileName)

            response.setContentType("text/csv")
            response.setHeader("Content-disposition", "attachment;filename=\"${fileName}\"")
            response.outputStream << f.bytes
            writer.close()
            f.delete()
        } catch (Exception e) {
            println(e.message)
            render "Error!"
        }
    }
}