// Import Greeting component from its own file
import Greeting from './Greeting.jsx'

// Root component
function App() {
  return (
    // One parent element wrapping everything
    <div>
      {/* Static heading */}
      <h1>Hello Anita</h1>

      {/* Same component reused with different props */}
      <Greeting name="Anita" />
      <Greeting name="Vito" />
    </div>
  )
}

// Export so main.jsx can render it
export default App