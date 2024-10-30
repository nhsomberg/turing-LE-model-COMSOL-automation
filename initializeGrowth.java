// initializeGrowth program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
/* Initialize the growth from a random generation */

with(model.param()); // Set the light to zero for the initial grwoth
  String storedW1 = get("w1"); // Get the old light values
  set("w1", "0"); // Set it to darkness
  String storedW2 = get("w2"); // Get the old light values
  set("w2", "0"); // Set it to darkness
endwith();

with(model.sol("sol1").feature("v1")); // Set the solver to initialize
  set("initmethod", "init");
  set("initsol", "zero");
endwith();

with(model.sol("sol1").feature("t1")); // Set the times
  set("tlist", "range(0,time_step,1000)"); // Set the time list to initilaize
endwith();

model.sol("sol1").runAll();

with(model.result("pg2")); // Solve the computation
  set("window", "window1");
endwith();
model.result("pg2").run();

// Return settings that were changed
with(model.param()); // Set the lights back
  set("w1", storedW1);
  set("w2", storedW2);
endwith();

with(model.sol("sol1").feature("t1")); // Set the times back
  set("tlist", "range(0,time_step,time_stop)");
endwith();        