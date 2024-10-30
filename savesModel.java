// savesModel program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
/* Saves the model as an mph file */

String modelPath = getModelPath(); // Get the full export path from the method
String modelName = modelPath+buildFileName();

try {
  model.save(modelName+".mph"); // Save the model
} catch (Exception e) {
  playSound("success.wav");
}