// employee records, with specialization added for the practice task
const employees = [
  { id: 1, name: "John Doe", age: 30, department: "IT", salary: 50000, specialization: "JavaScript" },
  { id: 2, name: "Alice Smith", age: 28, department: "HR", salary: 45000, specialization: "Recruitment" },
  { id: 3, name: "Bob Johnson", age: 35, department: "Finance", salary: 60000, specialization: "Accounting" }
];

// one line of HTML for one employee
function toLine(employee) {
  return `<p>${employee.id}: ${employee.name} - ${employee.department} - ${employee.salary}</p>`;
}

// write a list of employees into the page
function showList(list) {
  document.getElementById("employeesDetails").innerHTML = list.map(toLine).join("");
}

// show everyone
function displayEmployees() {
  showList(employees);
}

// add up all salaries
function calculateTotalSalaries() {
  const totalSalaries = employees.reduce((acc, employee) => acc + employee.salary, 0);
  alert(`Total Salaries: ${totalSalaries}`);
}

// show only HR staff
function displayHREmployees() {
  const hrEmployees = employees.filter((employee) => employee.department === "HR");
  showList(hrEmployees);
}

// find one employee by id
function findEmployeeById(employeeId) {
  const foundEmployee = employees.find((employee) => employee.id === employeeId);
  const output = document.getElementById("employeesDetails");

  if (foundEmployee) {
    output.innerHTML = toLine(foundEmployee);
  } else {
    output.innerHTML = "no employee has been found with this ID";
  }
}

// practice task: show JavaScript specialists
function displayJavaScriptSpecialists() {
  const specialists = employees.filter((employee) => employee.specialization === "JavaScript");

  if (specialists.length === 0) {
    document.getElementById("employeesDetails").innerHTML = "no employee has this specialization";
  } else {
    showList(specialists);
  }
}