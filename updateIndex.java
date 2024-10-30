// updateIndex program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
// Update the experiments index by increasing it by one

with(model.param()); // Get index from model
  String expIndex = get("expIndex");
endwith();

double doubIndex = Double.parseDouble(expIndex); // Convert index to double

doubIndex = doubIndex+1; // Add one

String indexOut = Double.toString(doubIndex); // Convert back to string

with(model.param()); // Set the model's index to the new index
  set("expIndex", indexOut);
endwith();