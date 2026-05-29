// DAY MESSAGE APP
// Shows a message based on the day of the week and asks about
// breakfast if it is morning
// Combines if-else (for the day message) and ternary (for breakfast)

function DayMessage() {
  // get the current date and time
  const time = new Date();

  // get the day as a full word like "Monday" using the locale string
  const day = time.toLocaleString("en-US", { weekday: "long" });

  // morning is true if the hour is between 6 and 12
  const morning = time.getHours() >= 6 && time.getHours() <= 12;

  // declare the message but do not assign it yet
  let dayMessage;

  // if-else assigns a different message based on the day
  if (day.toLowerCase() === "monday") {
    dayMessage = "Happy Monday";
  } else if (day.toLowerCase() === "tuesday") {
    dayMessage = "Tuesday, 4 days to go";
  } else if (day.toLowerCase() === "wednesday") {
    dayMessage = "Halfway there";
  } else if (day.toLowerCase() === "thursday") {
    dayMessage = "Almost Friday";
  } else if (day.toLowerCase() === "friday") {
    dayMessage = "Happy Friday";
  } else {
    dayMessage = "Stay calm and keep having fun";
  }

  return (
    <div>
      {/* show the day message from the if-else above */}
      <h1>{dayMessage}</h1>

      {/* ternary: if morning show the breakfast question, otherwise empty */}
      <h2>{morning ? "Have you had breakfast yet?" : ""}</h2>
    </div>
  );
}

export default DayMessage;