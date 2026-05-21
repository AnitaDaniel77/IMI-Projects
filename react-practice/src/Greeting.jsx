// Greeting receives "name" as a prop — destructured from props object
function Greeting({ name }) {
  return (
    <div>
      {/* Curly brackets output the value of name dynamically */}
      <h2>Welcome, {name}!</h2>
      <p>Ready to build with React.</p>
    </div>
  )
}

// Makes Greeting available to import in other files
export default Greeting