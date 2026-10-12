// Saves the email and amount in the browser's web storage
function saveDetails(event) {
  // Stops the page from reloading
  event.preventDefault();
  localStorage.setItem("email", document.getElementById("email").value);
  localStorage.setItem("amount", document.getElementById("amount").value);
  showSaved();
}

// Shows what is stored, if anything
function showSaved() {
  var email = localStorage.getItem("email");
  var amount = localStorage.getItem("amount");
  if (email) {
    document.getElementById("saved").textContent = "Saved: " + email + ", R" + amount;
  }
}

// Shows saved details when the page loads
window.onload = showSaved;