// notifyDone program
// COMSOL Java automation programs for growing Turing Patterns
// Noah H. Somberg, Christopher Konow, Milos Dolnik, and Irving R. Epstein
/* Send an email and play sound to notify that solution is finished */

with(model.variable("var1")); // Get the export path from the model variables
  String studyType = get("studyType");
endwith();

// Update the email with an actual user email
// Also requires COMSOL email configuration in settings.
sendEmail("test@email.com", "COMPUTATION COMPLETE: "+studyType, "Your most recent computation has completed. This email was generated automatically");
playSound("success.wav"); 