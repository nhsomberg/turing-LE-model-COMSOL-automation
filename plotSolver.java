// plotSoler program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
/* Plot the results while solving */
// This method has mixed success

with(model.result("pg1"));
  set("window", "window1");
endwith();

model.result("pg1").run();

with(model.result("pg1"));
  set("data", "dset2");
  set("window", "window1");
endwith();

model.result("pg1").run();