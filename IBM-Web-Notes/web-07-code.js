// Checks whether anything was typed in the input
function textChecker() {
  var text = document.getElementById("textField1").value;
  if (text === "") {
    alert("Nothing was typed");
  } else {
    alert("You typed: " + text);
  }
}

// Uses the document accessors to count parts of the page
function pageInfo() {
  var paragraphs = document.getElementsByTagName("p").length;
  var images = document.images.length;
  var scripts = document.scripts.length;
  alert("Paragraphs: " + paragraphs + ", images: " + images + ", scripts: " + scripts + ", head found: " + (document.head !== null));
}