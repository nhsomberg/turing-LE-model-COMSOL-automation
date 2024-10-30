// exportMesh program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein

/* Exports the mesh as an image */

// Get the full export path from the method
String exportPath = getExportPath();
String modelName = exportPath+buildFileName();

// Plot the pattern (and not the mesh)
model.result("pg1").feature("mesh1").active(true);
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();
model.result("pg1").feature("surf1").active(false);
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();

with(model.result().export("img1"));
  set("pngfilename", modelName+"_mesh_Final");
endwith();
model.result().export("img1").run();