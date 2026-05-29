// CONDITIONAL RENDERING
// Render components based on whether a condition is true or false
//
// Real life: like the Capitec app showing different content on
// the home screen depending on the situation — same screen,
// different content based on a condition.

// the two messages shown depending on the day
function Workdays() {
  return <h1>Get it done!</h1>;
}

function Weekends() {
  return <h1>Get some rest</h1>;
}

// APPROACH 1: ternary operator
// shortest way for a simple true or false choice
function CurrentMessageTernary() {
  // getDay returns 0 to 6, where 0 is Sunday and 6 is Saturday
  const day = new Date().getDay();

  // if Monday to Friday show Workdays, otherwise Weekends
  return (
    <div>
      {day >= 1 && day <= 5 ? <Workdays /> : <Weekends />}
    </div>
  );
}

// APPROACH 2: if statement
// clear and readable for a simple two-way choice
function CurrentMessageIf() {
  const day = new Date().getDay();

  // if Monday to Friday return Workdays
  if (day >= 1 && day <= 5) {
    return <Workdays />;
  }
  // otherwise return Weekends
  return <Weekends />;
}

// APPROACH 3: element variables
// separates the logic from the return statement, good for complex cases
function CurrentMessageVariable({ day }) {
  const weekday = (day >= 1 && day <= 5);
  const weekend = (day === 0 || day === 6);
  let message;

  if (weekday) {
    message = <Workdays />;
  } else if (weekend) {
    message = <Weekends />;
  }

  // the chosen message is rendered here
  return <div>{message}</div>;
}

// APPROACH 4: logical AND operator
// shows something or nothing, no else needed
// Real life: only show a low balance warning IF Anita's balance is under 100
function LowBalanceWarning() {
  const balance = 50; // Anita's current balance

  const isLow = balance < 100;

  return (
    <div>
      <h1>Anita's Account</h1>
      {/* if balance is low show the warning, otherwise show nothing */}
      {isLow && <h2>Warning: your balance is low</h2>}
    </div>
  );
}

// CONDITIONAL COMPONENTS
// A parent returns a different child component based on a condition
// Real life: a Log In button that becomes a Log Out button once
// Anita is signed into the Capitec app

// the two child buttons
function LoginButton() {
  return <button>Log In</button>;
}

function LogoutButton() {
  return <button>Log Out</button>;
}

// parent decides which child to render based on the isLoggedIn prop
function LogInOutButton(props) {
  // if logged in show Logout, otherwise show Login
  if (props.isLoggedIn) {
    return <LogoutButton />;
  }
  return <LoginButton />;
}

export {
  CurrentMessageTernary,
  CurrentMessageIf,
  CurrentMessageVariable,
  LowBalanceWarning,
  LogInOutButton,
};