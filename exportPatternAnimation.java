// exportPatternAnimation program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein

/* Exports an animation of the growth */

// Get the full export path from the method
String exportPath = getExportPath()+"Animation\\"; 
String modelName = exportPath+buildFileName();

// Plot the pattern (and not the mesh)
model.result("pg1").feature("mesh1").active(false);
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();
model.result("pg1").feature("surf1").active(true);
with(model.result("pg1"));
  set("window", "window1");
endwith();
model.result("pg1").run();

// Export the animation
with(model.result("pg1"));
  set("data", "dset1"); // Ensures that all frames are selected
  set("window", "window1");
endwith();
model.result("pg1").run();
with(model.result("pg1"));
  set("data", "dset2");
  set("window", "window1");
endwith();
model.result("pg1").run();
with(model.result().export("anim1"));
  set("sweeptype", "solutions");
  set("solnumtype", "all");
  set("giffilename", modelName+"_Animation");
endwith();
model.result().export("anim1").run();