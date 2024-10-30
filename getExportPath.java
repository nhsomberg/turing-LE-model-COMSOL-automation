// getExportPath program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
// This method exports the full export path, without the file name or subfolders appended to it
// An example output would be

with(model.variable("var1")); // Get the export path from the model variables
  String exportPath = get("exportPath");
endwith();

fullExportPath = exportPath; // Some redundancy left over here from how I used to use this method.