// Greeting component — receives name as a prop
function Greeting({ name }) {
  return (
    <div>
      {/* Display the name passed in from App */}
      <h2>Welcome, {name}!</h2>
      <p>Ready to build with React.</p>
    </div>
  )
}

// Export so App.jsx can import it
export default Greeting