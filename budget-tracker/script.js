const form = document.getElementById('expense-form');
const expenseList = document.getElementById('expense-list');
const total = document.getElementById('total');

let totalAmount = 0;

form.addEventListener('submit', function(event) {
  event.preventDefault();

  const description = document.getElementById('description').value;
  const amount = parseFloat(document.getElementById('amount').value);
  const category = document.getElementById('category').value;

  totalAmount += amount;

  const listItem = document.createElement('li');
  listItem.textContent = `${description} (${category}) - R${amount.toFixed(2)}`;
  expenseList.appendChild(listItem);

  total.textContent = `Total: R${totalAmount.toFixed(2)}`;

  form.reset();
});