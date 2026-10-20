// add works on numbers and on strings
function add(a, b) {
  return a + b;
}
console.log(add(3, 4));
console.log(add("Cape", "Town"));

// constructor function, the car blueprint
function Car(make, model, year) {
  this.make = make;
  this.model = model;
  this.year = year;
}

// build one car
const c = new Car("Meridian", "Saber GT", 2012);

// add getName to the prototype after c already exists
Car.prototype.getName = function () {
  return this.make + " " + this.model + " " + this.year;
};
console.log(c.getName());

// banking version, the account-opening form
function Account(holder, balance) {
  this.holder = holder;
  this.balance = balance;
}

// one shared deposit method for every account
Account.prototype.deposit = function (amount) {
  this.balance += amount;
  return this.balance;
};

const first = new Account("Anita", 1000);
const second = new Account("Sam", 250);
console.log(first.deposit(500));
console.log(second.deposit(100));

// self-executing function, runs straight away
(function () {
  const message = "Page loaded, " + first.holder + " has R" + first.balance;
  document.getElementById("status").textContent = message;
})();