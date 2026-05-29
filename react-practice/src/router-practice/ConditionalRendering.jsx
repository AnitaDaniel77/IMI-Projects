// CONDITIONAL RENDERING with ternary operators
// Render one component or another based on a condition
//
// Real life: like the Capitec app showing "Good morning Anita"
// on weekday mornings but a different message on weekends —
// same screen, different content based on a condition.

// the two messages shown depending on the day
function Workdays() {
  return <h1>Get it done!</h1>;
}

function Weekends() {
  return <h1>Get some rest</h1>;
}

function CurrentMessage() {
  // getDay returns the day as a number: 0 = Sunday, 6 = Saturday
  const day = new Date().getDay();

  // ternary: if day is between 1 and 5 (Mon-Fri) show Workdays
  // otherwise show Weekends
  return (
    <div>
      {day >= 1 && day <= 5 ? <Workdays /> : <Weekends />}
    </div>
  );
}

// simpler example using a boolean
function IsItSummerYet() {
  const summer = true;

  // if summer is true show the beach message, otherwise stay home
  return (
    <h1>{summer ? "Let's go to the beach" : "Stay home"}</h1>
  );
}

export { CurrentMessage, IsItSummerYet };