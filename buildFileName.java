// buildFileName program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
// This method takes the various parameters as input and outputs the name of the file

with(model.variable("var1")); // Get the export path from the model variables
  String studyType = get("studyType");
endwith();

with(model.param());
  // Get various parameters from the model
  String expIndex = get("expIndex");
  String date = get("date");
  String a = get("a");
  String b = get("b");
  String rad_step = get("rad_step");
  String time_stop = get("time_stop");
  // Build the file name from the parameters
  filename = date+"_"+expIndex+"_"+studyType+"_a_"+a+"_b_"+b+"_GR_"+rad_step+"_"+time_stop;