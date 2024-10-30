// fullRun program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
/* Computes the growth including the initialization, for the given parameter values

 Note that the results exports and model saving are not in this method */

initializeGrowth(); // Run the initialization method

// Run the growth
with(model.sol("sol1").feature("v1")); // Change the solver to solution
  set("initmethod", "sol");
  set("initsol", "sol1");
endwith();
model.study("std1").run();
useGraphics(model.result("pg1"), ""); // Plot the results

updateIndex(); // Update the index

// Note that the results exports and model saving are not in this method.