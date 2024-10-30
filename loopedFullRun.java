// loopedFullRun program
// COMSOL Java automation program for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein

// Script performs a looped computation
// of the given parameter range and steps
// while automatically exporting results.


// Get the needed loop variables
with(model.param());
  String rateStartString = get("sweep_start"); // Start growth rate
  String rateStep = get("sweep_step"); // Growth rate step
  String rateStop = get("sweep_stop"); // Stoping growth rate
endwith();

// Get the export options
with(model.variable("var1"));
  // These are all booleans that indicate if certain animations
  // or pictures should be exported. They are either set to
  // "on" or "off"
  String expFinal = get("expFinal");
  String expAnim = get("expAnim");
  String expMeshAnim = get("expMeshAnim");
  String expMeshFinal = get("expMeshFinal");
  String expBothAnim = get("expBothAnim");
endwith();

String on = "on"; // Define a string for comparison in the options

// Convert rateStart from a string to a double
Double rateStart = Double.parseDouble(rateStartString);

// Growth Rate Sweep
// For rateStart < rateCurr < rateStop, increase rateCurr by rateStep
for (double rateCurr = rateStart; rateCurr <= Double.parseDouble(rateStop); rateCurr = rateCurr+Double.parseDouble(rateStep)) {
  
  // Update the growth rate for the current iteration of the for loop
  with(model.param());
    set("rad_step", String.format("%.2f", rateCurr));
  endwith();
  
  // Run the initialization method
  initializeGrowth();
  
  // Run the growth
  with(model.sol("sol1").feature("v1"));
    // Change the solver to solution
    set("initmethod", "sol");
    set("initsol", "sol1");
  endwith();
  model.study("std1").run(); // Compute!
  // Plot the results, often only plots first iteration for some reason
  useGraphics(model.result("pg1"), "");
  
  // Should plot the results while solving (bugs have been experienced)
  plotSolver();
  
  // Export the pattern image (if selected)
  if (on.equals(expFinal)) {
    exportPattern();
  }
  
  // Export the mesh image
  if (on.equals(expMeshFinal)) {
    exportMesh();
  }
  
  // Export the pattern animation
  if (on.equals(expAnim)) {
    exportPatternAnimation();
  }
  
  // Export the mesh animation
  if (on.equals(expMeshAnim)) {
    exportMeshAnimation();
  }
  
  // Export the overlayed animation
  if (on.equals(expBothAnim)) {
    exportMeshPatternAnimation();
  }
  
  // Save the model
  savesModel();
  
  // Update the index
  updateIndex();
  
}
// Notify the user
notifyDone();
