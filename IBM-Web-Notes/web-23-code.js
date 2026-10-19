// Check the file loaded
console.log("External script ran");

// Grab the elements we need
const output = document.getElementById("output");
const updateBtn = document.getElementById("update-btn");
const sendBtn = document.getElementById("send-btn");

// Change the balance on the page
updateBtn.addEventListener("click", function () {
  output.textContent = "Balance: R1500.00";
  console.log("Balance updated");
});

// Ask, then confirm the payment
sendBtn.addEventListener("click", function () {
  const sure = confirm("Send R500?");

  if (sure) {
    const reference = prompt("Enter a reference");
    alert("Payment sent. Reference: " + reference);
  } else {
    alert("Payment cancelled");
  }
});