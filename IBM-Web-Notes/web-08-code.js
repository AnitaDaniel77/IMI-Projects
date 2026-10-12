// Checks if the browser supports input type="date"
function supportsDate() {
  var test = document.createElement("input");
  test.setAttribute("type", "date");
  // Unsupported browsers fall back to "text"
  return test.type === "date";
}

var result = document.getElementById("result");

if (supportsDate()) {
  result.textContent = "Your browser supports the date picker.";
} else {
  // Fallback: ask for the format by hand
  result.textContent = "No date picker here. Please type the date as yyyy-mm-dd.";
  document.getElementById("birthday").setAttribute("placeholder", "yyyy-mm-dd");
}