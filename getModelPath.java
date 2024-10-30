// getModelPath program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
// Returns the model path (without subfolders). Doesn't append filenames.

with(model.variable("var1")); // Get the export path from the model variables
  String modelPath = get("modelPath");
endwith();

fullModelPath = modelPath;