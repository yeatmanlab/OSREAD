package appforliteracy

class ModuleListService {

    static List<String> getModuleNames() {
        List<String> names = new ArrayList<>()
        names.add("FirstExample")
	names.add("SecondExample")
        //TODO: Add additional module names here

        return names
    }
}
