package appforliteracy

import metafunctionality.ModuleOutput
import metafunctionality.Module


class FileOutputController {

    def output() {
        Learner learner = Learner.findByUserID(params.id)
        List<Module> modules = learner.getModules()
        [modules: modules]
    }

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
